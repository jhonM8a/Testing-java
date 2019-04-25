package com.testing.javatest.payments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentProcessorTest {
	private PaymentGateway payementsGateway;
	private PaymentProcessor paymentProcessesor;

	@Before
	public void setup() {
		payementsGateway = Mockito.mock(PaymentGateway.class);
		paymentProcessesor = new PaymentProcessor(payementsGateway);
	}

	@Test
	public void payment_is_correct() {

		Mockito.when(payementsGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

		assertTrue(paymentProcessesor.makePayment(1000));
	}

	@Test
	public void payment_is_incorrect() {

		Mockito.when(payementsGateway.requestPayment((PaymentRequest) Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

		assertFalse(paymentProcessesor.makePayment(1000));
	}
}
