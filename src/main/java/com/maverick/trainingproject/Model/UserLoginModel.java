package com.maverick.trainingproject.Model;




public class UserLoginModel {

	private int userId;

	private String userEmail;
	private String userPassword;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserLoginModel(String userEmail, String userPassword) {
		setUserEmail(userEmail);
		setUserPassword(userPassword);
	}
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		
	

}
