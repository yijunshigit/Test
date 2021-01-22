package testgit;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Screct {

	public static void main(String args[]) throws Exception {
		String email = "";

		String apitoken = "c02f0bff-ea00-4d1c-ab0a-7c8bd4a3ee48";

		String nonce = "";
		for (int n = 0; n < 10; n++) {
			nonce += (int) (10 * (Math.random()));
		}
		System.out.println("random=" + nonce);

		Date date = new Date();
		System.out.println("timestamp=" + (date.getTime() + 4 * 60 * 1000) / 1000);

		String screct = email + "&" + apitoken + "&" + (date.getTime() + 4 * 60 * 1000) / 1000 + "&" + nonce + "&" + "v2";
		//System.out.println(screct);
		String sha256 = Screct.getSHA256StrJava(screct);
		System.out.println("sign="+sha256);

	}

	public static String getSHA256StrJava(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	/**
	 * 将byte转为16进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();

	}

}
