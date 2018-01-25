/*
 * Copyright 2015 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xh.http.download;

import android.text.TextUtils;
import android.util.Log;

import com.xh.http.Connection;
import com.xh.http.Headers;
import com.xh.http.HttpConnection;
import com.xh.http.Logger;
import com.xh.http.NetworkExecutor;
import com.xh.http.XhOkHttp;
import com.xh.http.error.NetworkError;
import com.xh.http.error.ServerError;
import com.xh.http.error.StorageReadWriteError;
import com.xh.http.error.StorageSpaceNotEnoughError;
import com.xh.http.error.TimeoutError;
import com.xh.http.error.URLError;
import com.xh.http.error.UnKnownHostError;
import com.xh.http.tools.HeaderUtils;
import com.xh.http.tools.IOUtils;
import com.xh.http.tools.NetUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.UnknownHostException;

/**
 * <p>
 * File downloader.
 * </p>
 * Created by YanZhenjie on Jul 31, 2015 9:11:55 AM.
 */
public class Downloader {

    private HttpConnection mHttpConnection;

    public Downloader(NetworkExecutor executor) {
        this.mHttpConnection = new HttpConnection(executor);
    }

    private void validateParam(DownloadRequest downloadRequest, DownloadListener downloadListener) {
        if (downloadRequest == null)
            throw new IllegalArgumentException("DownloadRequest == null.");
        if (downloadListener == null)
            throw new IllegalArgumentException("DownloadListener == null.");
    }

    private void validateDevice(String savePathDir) throws Exception {
        if (!NetUtils.isNetworkAvailable())
            throw new NetworkError("Network is not available, please check network and permission: INTERNET, " +
                    "ACCESS_WIFI_STATE, ACCESS_NETWORK_STATE.");

        if (!IOUtils.createFolder(savePathDir))
            throw new StorageReadWriteError("SD card isn't available, please check SD card and permission: WRITE_EXTERNAL_STORAGE." +
                    "\nYou must pay attention to Android6.0 RunTime Permissions: https://github.com/yanzhenjie/AndPermission." +
                    "\nFailed to create folder: " + savePathDir);
    }

    private Connection getConnectionRetry(DownloadRequest downloadRequest) throws Exception {
        Connection connection = mHttpConnection.getConnection(downloadRequest);
        Exception exception = connection.exception();
        if (exception != null)
            throw exception;

        Headers responseHeaders = connection.responseHeaders();
        int responseCode = responseHeaders.getResponseCode();

        if (responseCode == 416) {
            downloadRequest.removeHeader("Range");
            return mHttpConnection.getConnection(downloadRequest);
        }
        return connection;
    }

    private String getRealFileName(DownloadRequest request, Headers responseHeaders) throws IOException {
        String fileName = null;
        String contentDisposition = responseHeaders.getContentDisposition();
        if (!TextUtils.isEmpty(contentDisposition)) {
            fileName = HeaderUtils.parseHeadValue(contentDisposition, "filename", null);
            if (!TextUtils.isEmpty(fileName)) {
                try {
                    fileName = URLDecoder.decode(fileName, request.getParamsEncoding());
                } catch (UnsupportedEncodingException e) {
                    // Do nothing.
                }
                if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                    fileName = fileName.substring(1, fileName.length() - 1);
                }
            }
        }

        // From url.
        if (TextUtils.isEmpty(fileName)) {
            String url = request.url();
            URI uri = URI.create(url);
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                fileName = Integer.toString(url.hashCode());
            } else {
                String[] slash = path.split("/");
                fileName = slash[slash.length - 1];
            }
        }
        return fileName;
    }

    public void download(int what, DownloadRequest request, DownloadListener downloadListener) {
        validateParam(request, downloadListener);

        Connection connection = null;
        RandomAccessFile randomAccessFile = null;
        String savePathDir = request.getFileDir();
        String fileName = request.getFileName();
        try {
            if (TextUtils.isEmpty(savePathDir))
                savePathDir = XhOkHttp.getContext().getFilesDir().getAbsolutePath();

            validateDevice(savePathDir);

            Headers responseHeaders;
            int responseCode;
            File tempFile;
            long rangeSize;

            request.removeHeader("Range"); // ȥ���������Լ���ӵ�ͷ��

            if (TextUtils.isEmpty(fileName)) {// �Զ�������
                // ̽���ļ�����
                connection = getConnectionRetry(request);
                Exception tempE = connection.exception();
                if (tempE != null) throw tempE;
                responseHeaders = connection.responseHeaders();

                fileName = getRealFileName(request, responseHeaders);

                tempFile = new File(savePathDir, fileName + ".nohttp");
                if (request.isRange() && tempFile.exists() && tempFile.length() > 0) { // �ļ����ڲ�����Ҫ�ϵ㡣
                    connection.close(); // �Ͽ�̽���ļ�����

                    // ���Ӷϵ���Ϣ����¼�ϵ㿪ʼ����
                    rangeSize = tempFile.length();
                    request.setHeader("Range", "bytes=" + rangeSize + "-");

                    connection = getConnectionRetry(request); // ����ԭ��������Ϊ���Ӷϵ�����ӡ�
                    tempE = connection.exception();
                    if (tempE != null) throw tempE;
                    responseHeaders = connection.responseHeaders();

                    if (!request.containsHeader("Range")) { // ��������֧�ֶϵ㣬��ͷ��ʼ��
                        IOUtils.delFileOrFolder(tempFile);
                        rangeSize = 0;
                    }
                } else { // �Զ�����û�����ع���ʹ��ԭ���ӿ�ʼ���ء�
                    IOUtils.delFileOrFolder(tempFile);
                    rangeSize = 0;
                }
            } else {
                tempFile = new File(savePathDir, fileName + ".nohttp");
                if (request.isRange() && tempFile.exists() && tempFile.length() > 0) { // �ļ����ڲ�����Ҫ�ϵ㡣
                    // ���Ӷϵ���Ϣ����¼�ϵ㿪ʼ����
                    rangeSize = tempFile.length();
                    request.setHeader("Range", "bytes=" + rangeSize + "-");
                } else {
                    IOUtils.delFileOrFolder(tempFile);
                    rangeSize = 0;
                }

                connection = getConnectionRetry(request);
                Exception tempE = connection.exception();
                if (tempE != null) throw tempE;
                responseHeaders = connection.responseHeaders();

                if (!request.containsHeader("Range")) { // ��������֧�ֶϵ㣬��ͷ��ʼ��
                    IOUtils.delFileOrFolder(tempFile);
                    rangeSize = 0;
                }
            }

            Logger.i("----------Response Start----------");
            responseCode = responseHeaders.getResponseCode();
            InputStream serverStream = connection.serverStream();
            if (responseCode >= 400) {
                ServerError error = new ServerError("Download failed, the server response code is " + responseCode + ": " + request.url());
                error.setErrorBody(IOUtils.toString(serverStream));
                throw error;
            } else {
                long contentLength;
                // �ļ��ܴ�С
                if (responseCode == 206) {
                    // Content-Range: bytes [�ļ���Ŀ�ʼ�ֽ�]-[�ļ����ܴ�С - 1]/[�ļ����ܴ�С]��
                    String range = responseHeaders.getContentRange(); // Sample��Accept-Range:bytes 1024-2047/2048��
                    try {
                        contentLength = Long.parseLong(range.substring(range.indexOf('/') + 1));// ��ȡ'/'֮����ܴ�С��
                    } catch (Throwable e) {
                        throw new ServerError("ResponseCode is 206, but content-Range error in Server HTTP header information: " + range + ".");
                    }
                } else if (responseCode == 304) {
                    int httpContentLength = responseHeaders.getContentLength();
                    downloadListener.onStart(what, true, httpContentLength, responseHeaders, httpContentLength);
                    downloadListener.onProgress(what, 100, httpContentLength, 0);
                    Logger.d("-------Download finish-------");
                    downloadListener.onFinish(what, savePathDir + File.separator + fileName);
                    return;
                } else { // such as: 200.
                    rangeSize = 0L; // ��������֧��Range��
                    contentLength = responseHeaders.getContentLength();// ֱ�����ء�
                }

                // ��֤�ļ��Ѿ����ڡ�
                File lastFile = new File(savePathDir, fileName);
                if (lastFile.exists()) {
                    if (request.isDeleteOld())
                        IOUtils.delFileOrFolder(lastFile);
                    else {
                        downloadListener.onStart(what, true, lastFile.length(), responseHeaders, lastFile.length());
                        downloadListener.onProgress(what, 100, lastFile.length(), 0);
                        Logger.d("-------Download finish-------");
                        downloadListener.onFinish(what, lastFile.getAbsolutePath());
                        return;
                    }
                }

                if (IOUtils.getDirSize(savePathDir) < contentLength)
                    throw new StorageSpaceNotEnoughError("The folder is not enough space to save the downloaded file: " + savePathDir + ".");

                // ��Ҫ�������أ�������ʱ�ļ���
                if (responseCode != 206 && !IOUtils.createNewFile(tempFile))
                    throw new StorageReadWriteError("SD card isn't available, please check SD card and permission: WRITE_EXTERNAL_STORAGE." +
                            "\nYou must pay attention to Android6.0 RunTime Permissions: https://github.com/yanzhenjie/AndPermission." +
                            "\nFailed to create file: " + tempFile);

                if (request.isCanceled()) {
                    Log.w("NoHttpDownloader", "Download handle is canceled.");
                    downloadListener.onCancel(what);
                    return;
                }

                // ֪ͨ��ʼ�����ˡ�
                Logger.d("-------Download start-------");
                downloadListener.onStart(what, rangeSize > 0, rangeSize, responseHeaders, contentLength);

                randomAccessFile = new RandomAccessFile(tempFile, "rws");
                randomAccessFile.seek(rangeSize);

                byte[] buffer = new byte[8096];
                int len;

                int oldProgress = 0;// �ɵĽ��ȼ�¼����ֹ�ظ�֪ͨ��
                long count = rangeSize;// ׷��Ŀǰ�Ѿ����صĽ��ȡ�

                long startTime = System.currentTimeMillis();
                long speedCount = 0;
                long oldSpeed = 0;

                while (((len = serverStream.read(buffer)) != -1)) {
                    if (request.isCanceled()) {
                        Log.i("NoHttpDownloader", "Download handle is canceled.");
                        downloadListener.onCancel(what);
                        break;
                    } else {
                        randomAccessFile.write(buffer, 0, len);

                        count += len;
                        speedCount += len;

                        long time = System.currentTimeMillis() - startTime;
                        time = Math.max(time, 1);

                        long speed = speedCount * 1000 / time;

                        boolean speedChanged = oldSpeed != speed && time >= 300;

                        if (contentLength != 0) {
                            int progress = (int) (count * 100 / contentLength);
                            if (progress != oldProgress && speedChanged) {
                                downloadListener.onProgress(what, progress, count, speed);

                                speedCount = 0;
                                oldSpeed = speed;
                                startTime = System.currentTimeMillis();
                            } else if (speedChanged) {
                                downloadListener.onProgress(what, oldProgress, count, speed);

                                speedCount = 0;
                                oldSpeed = speed;
                                startTime = System.currentTimeMillis();
                            } else if (progress != oldProgress) {
                                downloadListener.onProgress(what, progress, count, oldSpeed);
                            }
                            oldProgress = progress;
                        } else if (speedChanged) {
                            downloadListener.onProgress(what, 0, count, speed);

                            speedCount = 0;
                            oldSpeed = speed;
                            startTime = System.currentTimeMillis();
                        } else {
                            downloadListener.onProgress(what, 0, count, oldSpeed);
                        }
                    }
                }
                if (!request.isCanceled()) {
                    //noinspection ResultOfMethodCallIgnored
                    tempFile.renameTo(lastFile);
                    Logger.d("-------Download finish-------");
                    downloadListener.onFinish(what, lastFile.getAbsolutePath());
                }
            }
        } catch (MalformedURLException e) {
            Logger.e(e);
            downloadListener.onDownloadError(what, new URLError(e.getMessage()));
        } catch (UnknownHostException e) {
            Logger.e(e);
            downloadListener.onDownloadError(what, new UnKnownHostError(e.getMessage()));
        } catch (SocketTimeoutException e) {
            Logger.e(e);
            downloadListener.onDownloadError(what, new TimeoutError(e.getMessage()));
        } catch (IOException e) {
            Exception newException = e;
            if (!IOUtils.canWrite(savePathDir))
                newException = new StorageReadWriteError("SD card isn't available, please check SD card and permission: WRITE_EXTERNAL_STORAGE." +
                        "\nYou must pay attention to Android6.0 RunTime Permissions: https://github.com/yanzhenjie/AndPermission." +
                        "\nFailed to create folder: " + savePathDir);
            else if (IOUtils.getDirSize(savePathDir) < 1024)
                newException = new StorageSpaceNotEnoughError("The folder is not enough space to save the downloaded file: " + savePathDir + ".");
            Logger.e(newException);
            downloadListener.onDownloadError(what, newException);
        } catch (Exception e) {// NetworkError | ServerError | StorageCantWriteError | StorageSpaceNotEnoughError
            if (!NetUtils.isNetworkAvailable())
                e = new NetworkError("Network is not available, please check network and permission: " +
                        "INTERNET, ACCESS_WIFI_STATE, ACCESS_NETWORK_STATE.");
            Logger.e(e);
            downloadListener.onDownloadError(what, e);
        } finally {
            Logger.i("----------Response End----------");
            IOUtils.closeQuietly(randomAccessFile);
            IOUtils.closeQuietly(connection);
        }
    }

}