/**
 * 
 */
package com.testing.javatest.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para generar test de StringUtil
 * 
 * @author sumel
 *
 */

public class StringUtilTest {
	@Test
	public void repeatStringOnce() {

		String result = StringUtil.repeat("hola", 1);

		Assert.assertEquals("hola", result);

	}

	@Test
	public void repeatStringMultipleTimes() {

		String result = StringUtil.repeat("hola", 2);

		Assert.assertEquals("holahola", result);

	}

	@Test
	public void repeatStringZeroTimes() {

		String result = StringUtil.repeat("hola", 0);

		Assert.assertEquals("", result);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void repeatStringNegativeTimes() {

		String result = StringUtil.repeat("hola", -1);

	}	
	
	@Test
	public void string_is_null() {
		
		assertTrue(StringUtil.isEmpty(null));
	}
	
	@Test
	public void string_is_empty_and_not_null() {
		assertTrue(StringUtil.isEmpty(""));
	}
	
	@Test
	public void string_is_not_empty_with_spacr_and_not_null() {
		assertTrue(StringUtil.isEmpty(" "));
	}
	@Test
	public void string_is_not_empty() {
		assertFalse(StringUtil.isEmpty("No Vacio"));
	}
}

