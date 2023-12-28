package com.synechron.policy.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.synechron.policy.exception.ResourceNotFoundException;
import com.synechron.policy.models.InsurancePolicy;
import com.synechron.policy.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyService {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;;

	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 */

	// insert
	// insurancePolicy-----------------------------------------------------------
	public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
		// insurancePolicy.setInsurancePolicyId(generatePolicyId());
		insurancePolicy.setInsurancePolicyNumber(generatePolicyNumber());
		Date date = new Date();
		insurancePolicy.setInsurancePolicyStartDate(date.toLocaleString());
		return insurancePolicyRepository.save(insurancePolicy);

	}

	// getByInsurancePolicyId------------------------------------------------------------
	public InsurancePolicy getByInsurancePolicyId(int insurancePolicyId) {

		return insurancePolicyRepository.findById(insurancePolicyId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + insurancePolicyId));

	}

	// delete Insurance
	// Policy---------------------------------------------------------------
	public String deleteInsurancePolicyById(int insurancePolicyId) {
		insurancePolicyRepository.deleteById(insurancePolicyId);
		return "" + insurancePolicyId;

	}

	// display
	// InsuarncePolicy-------------------------------------------------------------------
	public List<InsurancePolicy> displayAllPolicy() {
		List<InsurancePolicy> insurancePolicies = insurancePolicyRepository.findAll();

		return insurancePolicies;

	}

	public InsurancePolicy getByInsurancePolicyNo(String insurancePolicyNo) {

		return insurancePolicyRepository.findByInsurancePolicyNumber(insurancePolicyNo);
	}

	public InsurancePolicy getInsurancePolicyByCustId(String custId) {

		return insurancePolicyRepository.findByCustId(custId);
	}

	public String generatePolicyNumber() {
		// Generate a unique policy number using a custom algorithm or a unique
		// identifier
		String policyNumber = "SYNP-" + generateRandomNumber(1000, 9999) + "-" + generateRandomNumber(1000, 9999);
		return policyNumber;
	}

	private int generateRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	// The correct syntax to retrieve the next value from a sequence in PostgreSQL
	/*
	 * public int generatePolicyId() { // Retrieve the next value from the sequence
	 * Integer policyId = jdbcTemplate.queryForObject("SELECT NEXTVAL('policyId')",
	 * Integer.class); return policyId; }
	 */

	/*
	 * // update Insurance
	 * Policy------------------------------------------------------------ public
	 * ResponseStructure<InsurancePolicy> updateInsurancePolicy(InsurancePolicy
	 * insurancePolicy, int insurancePolicyId) { InsurancePolicy insurancePolicy2 =
	 * insurancePolicyDao.updateInsurancePolicy(insurancePolicy, insurancePolicyId);
	 * 
	 * if(insurancePolicy2 != null) {
	 * responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
	 * responseStructure.setMsg("Data is updated suceesfully because id is present"
	 * ); responseStructure.setData(insurancePolicy2); return responseStructure;
	 * }else { responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
	 * responseStructure.setMsg("given id is not present in database");
	 * responseStructure.setData(null); return responseStructure; } }
	 */
}
