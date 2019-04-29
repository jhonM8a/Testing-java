/**
 * 
 */
package com.testing.javatest.util;

/**
 * clase para trabjar con numero romanos
 * 
 * @author jochoa
 *
 */
public class RomanNumerals {
	
	public static String arabicToRoman(int number){
		
		String numberRoman = "";
		
		if(number>=5){
			numberRoman +="V";
			number -=5;
		}
		
		if (number >= 4) {
			numberRoman += "IV";
			number -= 4;
		}

		while (number >= 1) {
			numberRoman += "I";
			number -= 1;
		}
		return numberRoman;
	}

}
