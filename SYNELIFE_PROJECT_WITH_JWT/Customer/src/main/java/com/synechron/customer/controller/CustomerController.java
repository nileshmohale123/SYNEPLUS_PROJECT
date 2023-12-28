package com.synechron.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.customer.model.Customer;
import com.synechron.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer createCustomer = customerService.createCustomer(customer);

		return new ResponseEntity<Customer>(createCustomer, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomer = customerService.getAllCustomer();

		return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		Customer updateCustomer = customerService.updateCustomer(id, customer);

		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok().build();
	}
}