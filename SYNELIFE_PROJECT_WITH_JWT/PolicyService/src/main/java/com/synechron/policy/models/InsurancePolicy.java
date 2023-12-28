package com.synechron.policy.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurancePolicy")
public class InsurancePolicy {

	@Id
	@Column(name = "policyId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insurancePolicyId;

	@Column(name = "policyNumber")
	private String insurancePolicyNumber;

	@Column(name = "policyType")
	private String insurancePolicyType;

	@Column(name = "policyCoverageAmount")
	private long insurancePolicyCoverageAmount;

	@Column(name = "policyPremium")
	private String insurancePolicyPremium;

	@Column(name = "policyStartDate")
	private String insurancePolicyStartDate;

	@Column(name = "policyEndDate")
	private String insurancePolicyEndDate;

	@Column(name = "customerId")
	private String custId;

	@Column(name = "planId")
	private String planId;

	public InsurancePolicy() {

	}

	public InsurancePolicy(int insurancePolicyId, String insurancePolicyNumber, String insurancePolicyType,
			long insurancePolicyCoverageAmount, String insurancePolicyPremium, String insurancePolicyStartDate,
			String insurancePolicyEndDate, String custId, String planId) {
		super();
		this.insurancePolicyId = insurancePolicyId;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insurancePolicyType = insurancePolicyType;
		this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
		this.insurancePolicyPremium = insurancePolicyPremium;
		this.insurancePolicyStartDate = insurancePolicyStartDate;
		this.insurancePolicyEndDate = insurancePolicyEndDate;
		this.custId = custId;
		this.planId = planId;
	}

	public int getInsurancePolicyId() {
		return insurancePolicyId;
	}

	public void setInsurancePolicyId(int insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getInsurancePolicyType() {
		return insurancePolicyType;
	}

	public void setInsurancePolicyType(String insurancePolicyType) {
		this.insurancePolicyType = insurancePolicyType;
	}

	public long getInsurancePolicyCoverageAmount() {
		return insurancePolicyCoverageAmount;
	}

	public void setInsurancePolicyCoverageAmount(long insurancePolicyCoverageAmount) {
		this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
	}

	public String getInsurancePolicyPremium() {
		return insurancePolicyPremium;
	}

	public void setInsurancePolicyPremium(String insurancePolicyPremium) {
		this.insurancePolicyPremium = insurancePolicyPremium;
	}

	public String getInsurancePolicyStartDate() {
		return insurancePolicyStartDate;
	}

	public void setInsurancePolicyStartDate(String insurancePolicyStartDate) {
		this.insurancePolicyStartDate = insurancePolicyStartDate;
	}

	public String getInsurancePolicyEndDate() {
		return insurancePolicyEndDate;
	}

	public void setInsurancePolicyEndDate(String insurancePolicyEndDate) {
		this.insurancePolicyEndDate = insurancePolicyEndDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

}
