package com.maverick.trainingproject.Model;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;


public class UserProfileModel {

	private String userName;
	private String userEmail;
	private String userContact;
	private String userBloodGroup;
	private Date userDateOfBirth;
	private float userWeight;
	private float userHeight;
	private String userProfilePic;
	
	private int userId;
	private int userProfileId;
	
	private String dependentRelation;
	private String dependentName;
	private String dependentEmail;
	private String dependentContact;
	private String dependentBloodGroup;
	private Date dependentDateOfBirth;
	private float dependentWeight;
	private float dependentHeight;
	
	ArrayList<String> relationsList;
	
	private String oldDependentEmail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserBloodGroup() {
		return userBloodGroup;
	}
	public void setUserBloodGroup(String userBloodGroup) {
		this.userBloodGroup = userBloodGroup;
	}
	public Date getUserDateOfBirth() {
		return userDateOfBirth;
	}
	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}
	public float getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(float userWeight) {
		this.userWeight = userWeight;
	}
	public String getUserProfilePic() {
		return userProfilePic;
	}
	public float getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(float userHeight) {
		this.userHeight = userHeight;
	}
	public void setUserProfilePic(String blob) {
		this.userProfilePic = blob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int i) {
		this.userProfileId = i;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public String getDependentEmail() {
		return dependentEmail;
	}
	public void setDependentEmail(String dependentEmail) {
		this.dependentEmail = dependentEmail;
	}
	public String getDependentRelation() {
		return dependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		this.dependentRelation = dependentRelation;
	}
	public String getDependentContact() {
		return dependentContact;
	}
	public void setDependentContact(String dependentContact) {
		this.dependentContact = dependentContact;
	}
	public String getDependentBloodGroup() {
		return dependentBloodGroup;
	}
	public void setDependentBloodGroup(String dependentBloodGroup) {
		this.dependentBloodGroup = dependentBloodGroup;
	}
	public Date getDependentDateOfBirth() {
		return dependentDateOfBirth;
	}
	public void setDependentDateOfBirth(Date dependentDateOfBirth) {
		this.dependentDateOfBirth = dependentDateOfBirth;
	}
	public float getDependentWeight() {
		return dependentWeight;
	}
	public void setDependentWeight(float dependentWeight) {
		this.dependentWeight = dependentWeight;
	}
	public float getDependentHeight() {
		return dependentHeight;
	}
	public void setDependentHeight(float dependentHeight) {
		this.dependentHeight = dependentHeight;
	}
	public ArrayList<String> getRelationsList() {
		return relationsList;
	}
	public void setRelationsList(ArrayList<String> relationsList) {
		this.relationsList = relationsList;
	}
	public String getOldDependentEmail() {
		return oldDependentEmail;
	}
	public void setOldDependentEmail(String oldDependentEmail) {
		this.oldDependentEmail = oldDependentEmail;
	}
	
	
	
	
	
	
	
	
}
