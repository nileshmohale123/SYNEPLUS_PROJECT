package com.synechron.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
