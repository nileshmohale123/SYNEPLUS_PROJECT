package com.synechron.life.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synechron.life.exception.ResourceNotFoundException;
import com.synechron.life.model.Covers;
import com.synechron.life.model.Customer;
import com.synechron.life.model.InsurancePolicy;
import com.synechron.life.model.Payment;
import com.synechron.life.model.Plan;
import com.synechron.life.model.SyneLife;

@RestController
@RequestMapping("/synelife")
public class SyneLifeController {

	@Autowired
	RestTemplate temp;

	@GetMapping("/getDetails/{id}")
	public ResponseEntity<SyneLife> getDetails(@PathVariable Integer id)throws Exception {
		SyneLife life = new SyneLife();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Customer cust = temp
				.exchange("http://localhost:9091/customer/get/" + id, HttpMethod.GET, entity, Customer.class).getBody();
		try {
			if(cust != null) {
				life.setCustomer(cust);
			}
		} catch (Exception e) {			
			throw new ResourceNotFoundException("User not found with id: " + cust);
		}
		InsurancePolicy policy = temp.exchange("http://localhost:9090/api/getInsurancePolicyByCustId/" + id,
				HttpMethod.GET, entity, InsurancePolicy.class).getBody();
		int planId = Integer.valueOf(policy.getPlanId());
		Plan plan = temp.exchange("http://localhost:8082/plan/get/" + planId, HttpMethod.GET, entity, Plan.class)
				.getBody();
		List<Covers> cover = temp
				.exchange("http://localhost:8081/cover/get/" + planId, HttpMethod.GET, entity, List.class).getBody();
		
		Payment payment = temp.exchange("http://localhost:9095/payment/getpayment/" + id, HttpMethod.GET, entity, Payment.class)
				.getBody();
		life.setPayment(payment);
		life.setPlan(plan);
		life.setCovers(cover);
		life.setInsPolicy(policy);
		return new ResponseEntity<SyneLife>(life, HttpStatus.OK);
	}

}
