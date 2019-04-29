/**
 * 
 */
package com.testing.javatest.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Clase parar testear los casos de FizzBuzz
 * @author jochoa
 *
 */
public class FizzBuzzTest {
	
	private FizzBuzz fizzBuzz;
	
	@Before
	public void setup(){
		fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void given_number_divisible_three_then_return_Fizz(){
		
		assertEquals(FizzBuzz.fizzBuzz.Fizz.toString(), fizzBuzz.fizzBuzz(6));
	}
	
	@Test
	public void given_number_divisible_five_then_return_Buzz(){
		assertEquals(FizzBuzz.fizzBuzz.Buzz.toString(), fizzBuzz.fizzBuzz(10));
	}
	
	@Test
	public void given_number_divisible_for_5_or_3(){
		assertEquals(FizzBuzz.fizzBuzz.FizzBuzz.toString(), fizzBuzz.fizzBuzz(30));
	}
	
	@Test
	public void given_number_NOT_divisible_for_five_o_three_then_return_equals_number(){
		
		assertEquals("16", fizzBuzz.fizzBuzz(16));
	}

}
