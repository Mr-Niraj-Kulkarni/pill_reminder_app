package com.maverick.trainingproject.Service;

import java.io.Serializable;

public class JwtRequest implements Serializable {
private static final long serialVersionUID = 5926468583005150707L;

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


}