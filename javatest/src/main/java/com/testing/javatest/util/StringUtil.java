/**
 * 
 */
package com.testing.javatest.util;

/**
 * @author sumel
 *
 */
public class StringUtil {

	public static String repeat(String str, int times) {
		
		if(times<0){
			throw new IllegalArgumentException("times negative not allow");
		}
		String result = "";
		
		for (int i = 0; i < times; i++) {
			result += str;
		}
		
		return result;
	}
}
