package com.maverick.trainingproject.Service;

import java.util.regex.Pattern;

import com.maverick.trainingproject.Model.UserRegistrationInformation;

public class RegistrationValidation {
	
	
	//checks Strings are not empty 
	public boolean isBlank(String str) {
		System.out.println("is blank");
		if(str.length()>0)
			return false;
		
		return true ;
	}
	
	
	//check Contact Number validity
	public boolean isValidContact(String contact) {
		System.out.println("valid contact");
		String digitRegex = "[0-9]+" ;
		Pattern pat = Pattern.compile(digitRegex); 
		if(contact.length()==10 && (pat.matcher(contact).matches())) {
			return true; 
		}
		return false; 
		
		
	}
	
	//check the email validity 
	public boolean isValidEmail(String email) {
		System.out.println("is valid email");
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email.length()==0) 	
			return false; 
		return pat.matcher(email).matches();
	}
	
	//check the password validity 
	public boolean isValidPassword(String password) {
		System.out.println("is valid password");
		Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
		if(password.length()>=8) {
			
			return textPattern.matcher(password).matches();
		}
		
		return false  ;
	}
	
	//check the date validity 
	public boolean isValidDate() {
		
		// find the validity code for checking the correct date of birth of the User 
		return false ;
	}
	
	
	public boolean validateUserRegistrationData(UserRegistrationInformation userObj) {
		if(isBlank(userObj.getUserName()))
			return false;
		
		if(isBlank(userObj.getUserCountry()))
			return false ;
		
		if(isBlank(userObj.getSecretQuestion()))
			return false;
		if(isBlank(userObj.getSecretAnswer()))
			return false;
		
		
		if(!isBlank(userObj.getUserEmail())) {
			if(isValidEmail(userObj.getUserEmail())) {
				
			}
			else {
				return false ;
			}
		}
		if(!isBlank(userObj.getUserContact())) {
			if(isValidContact(userObj.getUserContact())) {
				
			}
			else {
				return false ;
			}
		}
		
		if(!isBlank(userObj.getUserPassword())) {
			if(isValidPassword(userObj.getUserPassword())) {
				
			}
			else {
				return false ;
			}
		}
		
		return true ;
	}
	
	
	
	
	
	
	
	
	

}
