package com.synechron.plan.model;

import java.io.Serializable;
import java.util.List;

public class PlanBenifits implements Serializable{

	private Plan plan;
	private List<Covers> covers;
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
	@Override
	public String toString() {
		return "PlanBenifits [plan=" + plan + ", covers=" + covers + "]";
	}	
	
}