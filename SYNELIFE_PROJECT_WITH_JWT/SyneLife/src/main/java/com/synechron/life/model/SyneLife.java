package com.synechron.life.model;

import java.util.List;

public class SyneLife {

	private Plan plan;
	private List<Covers> covers;
	private Customer customer;
	private InsurancePolicy insPolicy;
	private Payment payment;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<Covers> getCovers() {
		return covers;
	}

	public void setCovers(List<Covers> covers) {
		this.covers = covers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InsurancePolicy getInsPolicy() {
		return insPolicy;
	}

	public void setInsPolicy(InsurancePolicy insPolicy) {
		this.insPolicy = insPolicy;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	

}
