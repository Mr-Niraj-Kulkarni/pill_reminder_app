package com.maverick.trainingproject.Service;

import com.maverick.trainingproject.Model.UserRegistrationInformation;
import com.maverick.trainingproject.Repository.LoginRepo;

public class UserRegistrationService {

	public boolean registerUser(UserRegistrationInformation userObj) {
		// TODO Auto-generated method stub
		RegistrationValidation registrationValidationObject = new RegistrationValidation() ;
		
		boolean isValidUserData=registrationValidationObject.validateUserRegistrationData(userObj) ;
		
		if(isValidUserData) {
			System.out.println("it is working till validations");
			PasswordEncryption encryptionObject= new PasswordEncryption() ; 
			String encryptedpassword= encryptionObject.encryptPassword(userObj.getUserPassword());
			if(encryptedpassword!=null) {
				userObj.setUserPassword(encryptedpassword);
			}
			else {
				return false ;
			}
			
			LoginRepo loginRepoObject= new  LoginRepo() ;
			 
			boolean isDataInserted =loginRepoObject.insertUserInformationToDB(userObj);
			if(isDataInserted) {
				return true ;
			}
			else {
				return false; 
			}
		}
		
		
		return false ;
	}
	
	

}
