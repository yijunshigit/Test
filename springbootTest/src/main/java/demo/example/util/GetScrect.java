package demo.example.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;



public class GetScrect {

	public String getScrect(String email,String url,String key){
       String emailString = email;
		
		String urlString=url;

		String apitoken = key;

		String nonce = "";
		for (int n = 0; n < 10; n++) {
			nonce += (int) (10 * (Math.random()));
		}
		System.out.println("random=" + nonce);

		Date date = new Date();
		System.out.println("timestamp=" + (date.getTime() + 10 * 60 * 1000) / 1000);

		String screct = emailString + "&" + apitoken + "&" + (date.getTime() + 4 * 60 * 1000) / 1000 + "&" + nonce + "&" + "v2";
		
		//System.out.println(screct);
		String sha256 = GetScrect.getSHA256StrJava(screct);
		System.out.println("sign="+sha256+"\n");
		String s=urlString+"email="+emailString+"&amp;timestamp="+(date.getTime() + 4 * 60 * 1000) / 1000+"&sign="+sha256+"&nonce="+nonce+"&sign_version=v2";
		System.out.println(s);
		return s;
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

