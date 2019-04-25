package com.testing.javatest.payments;

public interface PaymentGateway {

	PaymentResponse requestPayment(PaymentRequest request);
}
