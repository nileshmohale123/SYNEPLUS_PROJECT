package com.synechron.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.customer.exception.ResourceNotFoundException;
import com.synechron.customer.model.Customer;
import com.synechron.customer.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomer() {

		return customerRepository.findAll();

	}

	public Customer getCustomerById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	public Customer updateCustomer(int id, Customer customer) {

		Customer existcust = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		existcust.setName(customer.getName());
		existcust.setEmail(customer.getEmail());

		return customerRepository.save(existcust);

	}

	public void deleteCustomer(int id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

		customerRepository.delete(customer);
	}
}
