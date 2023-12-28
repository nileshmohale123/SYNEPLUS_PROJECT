package com.synechron.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synechron.payment.model.Payment;
import com.synechron.payment.service.PaymentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException
	{
		return paymentService.doPayment(payment);
	}
	@GetMapping("/getpayment/{custId}")
	public Payment getpaystatusBycustId(@PathVariable int custId) throws JsonProcessingException {
		
		return paymentService.getPaymentById(custId);
	}
}
