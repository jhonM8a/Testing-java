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

		if (times < 0) {
			throw new IllegalArgumentException("times negative not allow");
		}
		String result = "";

		for (int i = 0; i < times; i++) {
			result += str;
		}

		return result;
	}

	public static boolean isEmpty(String str) {

		if (str == null) {
			return true;
		}

		if (str.equals("")) {
			return true;
		}

		if(str.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
