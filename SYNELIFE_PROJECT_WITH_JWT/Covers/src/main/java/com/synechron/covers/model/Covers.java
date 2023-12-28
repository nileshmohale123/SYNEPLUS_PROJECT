package com.synechron.covers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Covers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int coverId;
	private String coverName;
	private int planId;

	public Covers() {
		super();
	}

	public Covers(int coverId, String coverName, int planId) {
		super();
		this.coverId = coverId;
		this.coverName = coverName;
		this.planId = planId;
	}

	public int getCoverId() {
		return coverId;
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId;
	}

	public String getCoverName() {
		return coverName;
	}

	public void setCoverName(String coverName) {
		this.coverName = coverName;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "Covers [coverId=" + coverId + ", coverName=" + coverName + ", planId=" + planId + "]";
	}
}
