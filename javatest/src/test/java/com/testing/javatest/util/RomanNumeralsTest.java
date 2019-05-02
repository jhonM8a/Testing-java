/**
 * 
 */
package com.testing.javatest.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Clase para testear casos de {@link RomanNumerals}
 * 
 * @author jochoa
 *
 */
public class RomanNumeralsTest {

	private RomanNumerals romanNumerals;
	
	@Before
	public void setup(){
		romanNumerals = new RomanNumerals();
	}
	
	@Test
	public void given_number_one_then_return_equivalent_in_roman(){
		
		assertEquals("I", romanNumerals.arabicToRoman(1));
		
	}
	@Test
	public void given_number_two_then_return_equivalent_in_roman(){
		assertEquals("II", romanNumerals.arabicToRoman(2));
	}
	
	@Test
	public void given_5_then_return_equivalent_in_roman(){
		assertEquals("VI", romanNumerals.arabicToRoman(6));
	}
}
