package com.xh.encryption;

public class EncryptionFactory {
	/**
	 * 获取AES加密
	 * @param key
	 * @return
	 */
	public static IEncryption getAES(Key key) {
		return new AES(key);
	}
/**
 * 获取DES加密
 * @param key
 * @return
 */
	public static IEncryption getDES(Key key) {
		return new DES(key);
	}
/**
 * 获取RSA公钥加密私钥解密
 * @param key
 * @return
 */
	public static IEncryption getRSAPublic(Key key) {
		return new RSAPublic(key);
	}
/**
 * 获取RSA私钥加密公钥解密
 * @param key
 * @return
 */
	public static IEncryption getRSAPrivate(Key key) {
		return new RSAPrivate(key);
	}
/**
 * 获取md5签名
 * @return
 */
	public static ISign getMD5() {
		return new MD5();
	}
/**
 * 获取RSA签名
 * @param key
 * @return
 */
	public static ISign getRSASign(Key key) {
		return new RSASign(key);
	}
	public static Key createRSAKey() throws Exception{
		return creatKey2Key(getCreatKey());
	}
	public static Key createAESKey(String key){
		return new Key(Key.TYPE_AES, key, "");
	}
	public static Key CreateDESKey(String key){
		return new Key(Key.TYPE_DES, key, "");
	}
public static CreatKey getCreatKey() throws Exception{
	return new CreatKey();
}
public static Key creatKey2Key(CreatKey creatKey) throws Exception{
	return new Key(Key.TYPE_RSA, creatKey.getPublicKeyString(), creatKey.getPrivateKeyString());
}
	public static void main(String[] args) {
		try {
			System.out.println("\t\tAES");
			IEncryption aes = getAES(new Key(Key.TYPE_AES,
					"1235678912356789", ""));
			String text = "刘慧良";
			text = aes.encryption(text);
			System.out.println(text.trim());
			text = aes.decryption(text);
			System.out.println(text.trim());
			System.out.println("\n\t\tDES");
			IEncryption des = getDES(new Key(Key.TYPE_DES, "123456789", ""));
			text = des.encryption(text);
			System.out.println(text.trim());
			text = des.decryption(text);
			System.out.println(text.trim());
			Key key=createRSAKey();
			System.out.println("\n\t\tkey");
			System.out.println("\n\t\tpublicKey");
			System.out.println(key.getPublicKey().trim());
			
			
			System.out.println("\n\t\tprivateKey");
			System.out.println(key.getPrivateKey().trim());
			System.out.println("\n\t\tRSAPublic");
			IEncryption rsaPubic=getRSAPublic(key);
			text=rsaPubic.encryption(text);
			System.out.println(text.trim());
			text=rsaPubic.decryption(text);
			System.out.println(text.trim());
			System.out.println("\n\t\tRSAPrivate");
			IEncryption rsaPrivate=getRSAPrivate(key);
			text=rsaPrivate.encryption(text);
			System.out.println(text.trim());
			text=rsaPrivate.decryption(text);
			System.out.println(text.trim());
			System.out.println("\n\t\tsign");
			System.out.println("\n\t\tMD5");
			ISign iSignMD5=getMD5();
			String sign=iSignMD5.sign(text);
			System.out.println(sign.trim());
			System.out.println(iSignMD5.verify(text, sign));
			System.out.println("\n\t\tRSASign");
			ISign iSignRSA=getRSASign(key);
			sign=iSignRSA.sign(text);
			System.out.println(sign.trim());
			System.out.println(iSignRSA.verify(text, sign));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
