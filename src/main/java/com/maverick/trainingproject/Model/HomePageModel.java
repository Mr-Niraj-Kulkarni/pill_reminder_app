package com.maverick.trainingproject.Model;

import java.sql.Time;

public class HomePageModel {
	protected int pillTableid;
	protected int userId;
	protected int checkbox;
	protected String pillName;
	protected int dosageAmount;
	protected Time pillTime;
	protected Integer dependentId;
	protected String dependentRelation;
	protected String dependentName;
	
	public String getDependentRelation() {
		return dependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		this.dependentRelation = dependentRelation;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public int getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(int checkbox) {
		this.checkbox = checkbox;
	}
	public String getPillName() {
		return pillName;
	}
	public void setPillName(String pillName) {
		this.pillName = pillName;
	}
	public int getDosageAmount() {
		return dosageAmount;
	}
	public void setDosageAmount(int dosageAmount) {
		this.dosageAmount = dosageAmount;
	}
	public Time getPillTime() {
		return pillTime;
	}
	public void setPillTime(Time pillTime) {
		this.pillTime = pillTime;
	}
	public Integer getDependentId() {
		return dependentId;
	}
	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPillTableid() {
		return pillTableid;
	}
	public void setPillTableid(int pillTableid) {
		this.pillTableid = pillTableid;
	}
	
	
}
