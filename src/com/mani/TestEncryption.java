package com.mani;

import java.io.InputStream;
import java.net.URL;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;

class AESencrp {
	private static final String ALGO = "AES";
	/*
	 * private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e',
	 * 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	 */

	private static byte[] keyValue = new byte[] { '0', 'x', 'i', 'a', 'o', 'm', 'i', 'd', 'e', 'l', 'h', 'i', 'v', 'e',
			'r', 'y' };

	public static byte[] encrypt(byte[] Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data);
		// String encryptedValue = new BASE64Encoder().encode(encVal);
		return encVal;
	}

	public static byte[] decrypt(byte[] encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);

		byte[] decValue = c.doFinal(encryptedData);
		return decValue;
	}

	private static Key generateKey() throws Exception {

		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}

public class TestEncryption {

	public static void main(String[] args) throws Exception {
		InputStream in = new URL(
				"http://in-upload.store.mi.com/upload/fileshow?type=3&f=kyc/in/2020-08-01/37306fb4345d8259144ab48766afa6c3.jpg")
						.openStream();
		byte[] array = IOUtils.toByteArray(in);

		// byte[] array = new byte[] { 127, -128, 0 };
		byte[] arrayEnc = AESencrp.encrypt(array);
		byte[] arrayDec = AESencrp.decrypt(arrayEnc);

		System.out.println("Plain Text : " + java.util.Arrays.toString(array));
		System.out.println("Encrypted Text : " + java.util.Arrays.toString(arrayEnc));
		System.out.println("Decrypted Text : " + java.util.Arrays.toString(arrayDec));
	}
}
