package com.synechron.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synechron.payment.model.Payment;


public interface PaymentService {

	public Payment doPayment(Payment payment) throws JsonProcessingException;
	public Payment getPaymentById(int custId) throws JsonProcessingException;
}
