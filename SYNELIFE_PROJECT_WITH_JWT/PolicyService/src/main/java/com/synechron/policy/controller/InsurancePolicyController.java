package com.synechron.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.policy.models.InsurancePolicy;
import com.synechron.policy.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;

	// insert
	// insurancePolicy------------------------------------------------------------------
	@PostMapping("/saveInsurancePolicy")
	public ResponseEntity<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		InsurancePolicy insurancePolicy2 = insurancePolicyService.insertInsurancePolicy(insurancePolicy);

		return new ResponseEntity<>(insurancePolicy2, HttpStatus.CREATED);
	}

	// getByInsurancePolicyId-------------------------------------------------------------------------------
	@GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
	public ResponseEntity<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId) {
		InsurancePolicy insurancePolicy2 = insurancePolicyService.getByInsurancePolicyId(insurancePolicyId);
		return new ResponseEntity<>(insurancePolicy2, HttpStatus.OK);
	}
	
	@GetMapping("/getInsurancePolicyByCustId/{custId}")
	public ResponseEntity<InsurancePolicy> getByInsurancePolicyNo(@PathVariable String custId) {
		InsurancePolicy insurancePolicy2 = insurancePolicyService.getInsurancePolicyByCustId(custId);
		return new ResponseEntity<>(insurancePolicy2, HttpStatus.OK);
	}

	// delete Insurance
	// Policy-------------------------------------------------------------------------------------
	@DeleteMapping("/deleteInsurancePolicy/{insurancePolicyId}")
	public ResponseEntity<String> deleteInsurancePolicy(@PathVariable int insurancePolicyId) {
		insurancePolicyService.deleteInsurancePolicyById(insurancePolicyId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);

	}

	// display
	// InsuarncePolicy------------------------------------------------------------------------------------
	@GetMapping("/displayAllPolicy")
	public ResponseEntity<List<InsurancePolicy>> displayAllPolicy() {

		List<InsurancePolicy> displayAllPolicy = insurancePolicyService.displayAllPolicy();
		return new ResponseEntity<List<InsurancePolicy>>(displayAllPolicy, HttpStatus.OK);
	}

	/*
	 * // update Insurance //
	 * Policy-----------------------------------------------------------------------
	 * -------------
	 * 
	 * @PutMapping("/updateInsurancePolicy/{insurancePolicyId}") public
	 * ResponseStructure<InsurancePolicy> updateInsurancePolicy(@RequestBody
	 * InsurancePolicy insurancePolicy,
	 * 
	 * @PathVariable int insurancePolicyId) { return
	 * insurancePolicyService.updateInsurancePolicy(insurancePolicy,
	 * insurancePolicyId); }
	 */
}
