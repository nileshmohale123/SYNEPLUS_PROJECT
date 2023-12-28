package com.synechron.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synechron.payment.model.Payment;
import com.synechron.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	// Logger logger=LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public Payment doPayment(Payment payment) throws JsonProcessingException {

		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentStatus());
		// logger.info("Order_Service" + new
		// ObjectMapper().writeValueAsString(payment));
		return paymentRepository.save(payment);
	}

	public String paymentStatus() {
		return new Random().nextBoolean() ? "Success" : "Success";
	}

	@Override
	public Payment getPaymentById(int custId) throws JsonProcessingException {

		return paymentRepository.findById(custId).orElse(null);
	}
}
