package com.maverick.trainingproject.Model;

public class DependentMedicalHistoryModel extends MedicalHistoryModel{
	
	
	protected String dependentRelation;
	protected String DependentName;
	
	
	public String getDependentName() {
		return DependentName;
	}
	public void setDependentName(String dependentName) {
		DependentName = dependentName;
	}
	
	public String getDependentRelation() {
		return dependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		this.dependentRelation = dependentRelation;
	}
	
	

}
