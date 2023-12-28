package com.synechron.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.synechron.policy.models.InsurancePolicy;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

	public InsurancePolicy findByInsurancePolicyNumber(String insurancePolicyNo);

	public InsurancePolicy findByCustId(String custId);

}
