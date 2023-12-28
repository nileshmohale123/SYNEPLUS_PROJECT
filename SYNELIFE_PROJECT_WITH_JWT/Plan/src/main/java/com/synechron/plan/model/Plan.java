package com.synechron.plan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int planId;
	private String planName;
	private String minAgeEntry;
	private String maxAgeEntry;
	private String minAgeMaturity;
	private String maxAgeMaturity;
	private String minPolicyTerm;
	private String maxPolicyTerm;
	
	public Plan() {
		super();
	}
	public Plan(int planId, String planName, String minAgeEntry, String maxAgeEntry, String minAgeMaturity,
			String maxAgeMaturity, String minPolicyTerm, String maxPolicyTerm) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.minAgeEntry = minAgeEntry;
		this.maxAgeEntry = maxAgeEntry;
		this.minAgeMaturity = minAgeMaturity;
		this.maxAgeMaturity = maxAgeMaturity;
		this.minPolicyTerm = minPolicyTerm;
		this.maxPolicyTerm = maxPolicyTerm;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getMinAgeEntry() {
		return minAgeEntry;
	}
	public void setMinAgeEntry(String minAgeEntry) {
		this.minAgeEntry = minAgeEntry;
	}
	public String getMaxAgeEntry() {
		return maxAgeEntry;
	}
	public void setMaxAgeEntry(String maxAgeEntry) {
		this.maxAgeEntry = maxAgeEntry;
	}
	public String getMinAgeMaturity() {
		return minAgeMaturity;
	}
	public void setMinAgeMaturity(String minAgeMaturity) {
		this.minAgeMaturity = minAgeMaturity;
	}
	public String getMaxAgeMaturity() {
		return maxAgeMaturity;
	}
	public void setMaxAgeMaturity(String maxAgeMaturity) {
		this.maxAgeMaturity = maxAgeMaturity;
	}
	public String getMinPolicyTerm() {
		return minPolicyTerm;
	}
	public void setMinPolicyTerm(String minPolicyTerm) {
		this.minPolicyTerm = minPolicyTerm;
	}
	public String getMaxPolicyTerm() {
		return maxPolicyTerm;
	}
	public void setMaxPolicyTerm(String maxPolicyTerm) {
		this.maxPolicyTerm = maxPolicyTerm;
	}
	@Override
	public String toString() {
		return "PlanAndBenifit [planId=" + planId + ", planName=" + planName + ", minAgeEntry=" + minAgeEntry
				+ ", maxAgeEntry=" + maxAgeEntry + ", minAgeMaturity=" + minAgeMaturity + ", maxAgeMaturity="
				+ maxAgeMaturity + ", minPolicyTerm=" + minPolicyTerm + ", maxPolicyTerm=" + maxPolicyTerm + "]";
	}
	
}
