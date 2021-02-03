package com.maverick.trainingproject.Model;

import java.sql.Date;

public class UserRegistrationInformationModel {
	protected int userID ;
	protected String  userName ;
	protected String userEmail ;
	protected String userContact ;
	protected String userCountry  ;
	protected Date userDateofBirth ;
	protected String userPassword ;
	protected String secretQuestion ;
	protected String secretAnswer ;
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
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
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public Date getUserDateofBirth() {
		return userDateofBirth;
	}
	public void setUserDateofBirth(Date userDateofBirth) {
		this.userDateofBirth = userDateofBirth;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public UserRegistrationInformationModel(String userEmail, String userPassword) {
		setUserEmail(userEmail);
		setUserPassword(userPassword);
	}
}
