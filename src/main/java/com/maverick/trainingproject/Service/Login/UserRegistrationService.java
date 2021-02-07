package com.maverick.trainingproject.Service.Login;


import com.maverick.trainingproject.Model.UserRegistrationInformationModel;
import com.maverick.trainingproject.Repository.LoginRepository;


public class UserRegistrationService {

	public boolean registerUser(UserRegistrationInformationModel userObj) {
		// TODO Auto-generated method stub
		UserDataValidation registrationValidationObject = new UserDataValidation() ;
		
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
			
			LoginRepository loginRepoObject= new  LoginRepository() ;
			 
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
