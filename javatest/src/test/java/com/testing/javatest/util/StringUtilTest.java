/**
 * 
 */
package com.testing.javatest.util;

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
}
