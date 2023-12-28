package com.synechron.life.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class InsurancePolicy {

	private int insurancePolicyId;
	private String insurancePolicyNumber;
	private String insurancePolicyType;
	private long insurancePolicyCoverageAmount;
	private String insurancePolicyPremium;
	private String insurancePolicyStartDate;
	private String insurancePolicyEndDate;
	private String planId;
	private String custId;
	
	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public InsurancePolicy() {
		
	}
	

	public InsurancePolicy(int insurancePolicyId, String insurancePolicyNumber, String insurancePolicyType,
			long insurancePolicyCoverageAmount, String insurancePolicyPremium, String insurancePolicyStartDate,
			String insurancePolicyEndDate) {
		super();
		this.insurancePolicyId = insurancePolicyId;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insurancePolicyType = insurancePolicyType;
		this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
		this.insurancePolicyPremium = insurancePolicyPremium;
		this.insurancePolicyStartDate = insurancePolicyStartDate;
		this.insurancePolicyEndDate = insurancePolicyEndDate;
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

}
