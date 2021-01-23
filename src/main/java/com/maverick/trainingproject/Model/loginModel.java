package com.maverick.trainingproject.Model;

import org.springframework.stereotype.Controller;

@Controller
public class loginModel {
	private String email;
	private String password;
	
	public loginModel() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
