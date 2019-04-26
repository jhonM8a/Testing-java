package com.testing.javatest.discounts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PriceCalculatorShould {

	@Test
	public void total_zero_when_there_are_prices() {
		
		PriceCalculator priceCalculator = new PriceCalculator();
		
		assertThat(priceCalculator.getTotal(), is(0.0));
	}
}
