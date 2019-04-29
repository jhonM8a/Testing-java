/**
 * 
 */
package com.testing.javatest.util;

/**
 * 	Clase para manejo de retorno de palabras,
 * 
 * @author jochoa
 *
 */
public class FizzBuzz {

	public enum fizzBuzz{
		Fizz, Buzz, FizzBuzz;
	}
	
	public static String fizzBuzz(int number) {
		
		if (number % 5 == 0 && number % 3 == 0) {
			return fizzBuzz.FizzBuzz.toString();
		}
		if (number % 3 == 0) {
			return fizzBuzz.Fizz.toString();
		}
		if (number % 5 == 0) {
			return fizzBuzz.Buzz.toString();
		}

		else {
			return Integer.valueOf(number).toString();
		}

	}

}
