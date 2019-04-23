package com.testing.javatest.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordUtilTest {

	@Test
	public void weakWhenLessThan8letters() {

		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("123456"));

	}

	@Test
	public void weakWhenHasOnlyLetters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefgh"));
	}
	
	@Test
	public void weakWhenHasLettersAndNumbers() {
		assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd12345678"));
	}	
	
	@Test
	public void weakWhenHasLettersAndNumbersAndMore8letters() {
		assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd12345678!"));
	}
	
}


