package com.synechron.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
