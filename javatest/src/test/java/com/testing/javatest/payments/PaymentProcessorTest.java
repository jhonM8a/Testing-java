package com.testing.javatest.payments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class PaymentProcessorTest {

	@Test
	public void payment_is_correct() {

		PaymentGateway payementsGateway = Mockito.mock(PaymentGateway.class);

		Mockito.when(payementsGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		
		PaymentProcessor paymentProcessesor = new PaymentProcessor(payementsGateway);

		assertTrue(paymentProcessesor.makePayment(1000));
	}
	
	@Test
	public void payment_is_incorrect() {

		PaymentGateway payementsGateway = Mockito.mock(PaymentGateway.class);

		Mockito.when(payementsGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
		
		PaymentProcessor paymentProcessesor = new PaymentProcessor(payementsGateway);

		assertFalse(paymentProcessesor.makePayment(1000));
	}	
}
