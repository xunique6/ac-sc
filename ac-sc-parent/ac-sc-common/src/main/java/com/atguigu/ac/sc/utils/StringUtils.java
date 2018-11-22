package com.atguigu.ac.sc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	/***
	 * 判断传入的字符串是否为null或者空串
	 * @param source
	 * @return
	 */
	public static  boolean stringCheck(String source) {
		
		return source != null && !"".equals(source);
	}
	
	public static String md5(String source)  {
		//检验字符串
		boolean checkResult = stringCheck(source);
		
		if(!checkResult) {
			throw new RuntimeException(ACConst.PWD_INVALID);
		}
		
		byte[] inputBytes = source.getBytes();
		
		String algorithm = "md5";
		
		byte[]outputBytes = null;
		
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			outputBytes = digest.digest(inputBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		//②声明字符数组
		char[] characters = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		for (int i = 0; i < outputBytes.length; i++) {
				byte b = outputBytes[i];
				int lowValue = b & 15;
				int highValue = (b>>4)&15;
				
				char lowChar = characters[lowValue];
				char highChar = characters[highValue];
				
				builder.append(highChar).append(lowChar);
		}
		
		return builder.toString();
	}
	
}
