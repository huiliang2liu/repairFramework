//package com.xh.util;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import dalvik.system.DexFile;
//
//import android.renderscript.Element;
//
///**
// * @version 创建时间：2018-1-3 下午1:53:42 项目：repair 包名：com.xh.util 文件名：ClassL.java
// *          作者：lhl 说明 DexPathList关键函数:
// */
//
//public class ClassL {
//	public DexPathList(ClassLoader definingContext, String dexPath,
//			String librarySearchPath, File optimizedDirectory) {
//
//		if (definingContext == null) {
//			throw new NullPointerException("definingContext == null");
//		}
//
//		if (dexPath == null) {
//			throw new NullPointerException("dexPath == null");
//		}
//
//		if (optimizedDirectory != null) {
//			if (!optimizedDirectory.exists()) {
//				throw new IllegalArgumentException(
//						"optimizedDirectory doesn't exist: "
//								+ optimizedDirectory);
//			}
//
//			if (!(optimizedDirectory.canRead() && optimizedDirectory.canWrite())) {
//				throw new IllegalArgumentException(
//						"optimizedDirectory not readable/writable: "
//								+ optimizedDirectory);
//			}
//		}
//
//		this.definingContext = definingContext;
//
//		ArrayList<IOException> suppressedExceptions = new ArrayList<IOException>();
//		// save dexPath for BaseDexClassLoader
//		this.dexElements = makeDexElements(splitDexPath(dexPath),
//				optimizedDirectory, suppressedExceptions, definingContext);
//
//		// Native libraries may exist in both the system and
//		// application library paths, and we use this search order:
//		//
//		// 1. This class loader's library path for application libraries
//		// (librarySearchPath):
//		// 1.1. Native library directories
//		// 1.2. Path to libraries in apk-files
//		// 2. The VM's library path from the system property for system
//		// libraries
//		// also known as java.library.path
//		//
//		// This order was reversed prior to Gingerbread; see http://b/2933456.
//		this.nativeLibraryDirectories = splitPaths(librarySearchPath, false);
//		this.systemNativeLibraryDirectories = splitPaths(
//				System.getProperty("java.library.path"), true);
//		List<File> allNativeLibraryDirectories = new ArrayList<>(
//				nativeLibraryDirectories);
//		allNativeLibraryDirectories.addAll(systemNativeLibraryDirectories);
//
//		this.nativeLibraryPathElements = makePathElements(
//				allNativeLibraryDirectories, suppressedExceptions,
//				definingContext);
//
//		if (suppressedExceptions.size() > 0) {
//			this.dexElementsSuppressedExceptions = suppressedExceptions
//					.toArray(new IOException[suppressedExceptions.size()]);
//		} else {
//			dexElementsSuppressedExceptions = null;
//		}
//	}
//
//	private static List<File> splitPaths(String searchPath,
//			boolean directoriesOnly) {
//		List<File> result = new ArrayList<>();
//
//		if (searchPath != null) {
//			for (String path : searchPath.split(File.pathSeparator)) {
//				if (directoriesOnly) {
//					try {
//						StructStat sb = Libcore.os.stat(path);
//						if (!S_ISDIR(sb.st_mode)) {
//							continue;
//						}
//					} catch (ErrnoException ignored) {
//						continue;
//					}
//				}
//				result.add(new File(path));
//			}
//		}
//
//		return result;
//	}
//
//	private static Element[] makeDexElements(List<File> files,
//			File optimizedDirectory, List<IOException> suppressedExceptions,
//			ClassLoader loader) {
//		return makeElements(files, optimizedDirectory, suppressedExceptions,
//				false, loader);
//	}
//
//	private static Element[] makeElements(List<File> files,
//			File optimizedDirectory, List<IOException> suppressedExceptions,
//			boolean ignoreDexFiles, ClassLoader loader) {
//		Element[] elements = new Element[files.size()];
//		int elementsPos = 0;
//		/*
//		 * Open all files and load the (direct or contained) dex files up front.
//		 */
//		for (File file : files) {
//			File zip = null;
//			File dir = new File("");
//			DexFile dex = null;
//			String path = file.getPath();
//			String name = file.getName();
//
//			if (path.contains(zipSeparator)) {
//				String split[] = path.split(zipSeparator, 2);
//				zip = new File(split[0]);
//				dir = new File(split[1]);
//			} else if (file.isDirectory()) {
//				// We support directories for looking up resources and native
//				// libraries.
//				// Looking up resources in directories is useful for running
//				// libcore tests.
//				elements[elementsPos++] = new Element(file, true, null, null);
//			} else if (file.isFile()) {
//				if (!ignoreDexFiles && name.endsWith(DEX_SUFFIX)) {
//					// Raw dex file (not inside a zip/jar).
//					try {
//						dex = loadDexFile(file, optimizedDirectory, loader,
//								elements);
//					} catch (IOException suppressed) {
//						System.logE("Unable to load dex file: " + file,
//								suppressed);
//						suppressedExceptions.add(suppressed);
//					}
//				} else {
//					zip = file;
//
//					if (!ignoreDexFiles) {
//						try {
//							dex = loadDexFile(file, optimizedDirectory, loader,
//									elements);
//						} catch (IOException suppressed) {
//							/*
//							 * IOException might get thrown "legitimately" by
//							 * the DexFile constructor if the zip file turns out
//							 * to be resource-only (that is, no classes.dex file
//							 * in it). Let dex == null and hang on to the
//							 * exception to add to the tea-leaves for when
//							 * findClass returns null.
//							 */
//							suppressedExceptions.add(suppressed);
//						}
//					}
//				}
//			} else {
//				System.logW("ClassLoader referenced unknown path: " + file);
//			}
//
//			if ((zip != null) || (dex != null)) {
//				elements[elementsPos++] = new Element(dir, false, zip, dex);
//			}
//		}
//		if (elementsPos != elements.length) {
//			elements = Arrays.copyOf(elements, elementsPos);
//		}
//		return elements;
//	}
// }
