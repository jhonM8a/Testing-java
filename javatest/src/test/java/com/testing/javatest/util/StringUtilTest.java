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
	public void testRepeat() {

		String result = StringUtil.repeat("hola", 1);

		Assert.assertEquals("hola", result);

		System.out.println(result);

	}
}
