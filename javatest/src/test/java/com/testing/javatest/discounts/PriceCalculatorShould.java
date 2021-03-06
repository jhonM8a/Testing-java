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
	
	@Test
	public void total_is_sum_of_prices() {
		
		PriceCalculator priceCalculator = new PriceCalculator();
		
		priceCalculator.addPrice(10.0);
		priceCalculator.addPrice(20.0);
		
		assertThat(priceCalculator.getTotal(), is(30.0));
	}
	
	@Test 
	public void apply_discount_to_prices() {
		PriceCalculator priceCalculator = new PriceCalculator();
		
		priceCalculator.setDiscount(50);
		priceCalculator.addPrice(12.5);
		priceCalculator.addPrice(17.5);
		
		assertThat(priceCalculator.getTotal(), is(15.0));
	}
}
