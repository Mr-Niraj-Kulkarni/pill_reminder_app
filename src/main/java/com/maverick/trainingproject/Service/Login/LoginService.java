package com.maverick.trainingproject.Service.Login;
import org.springframework.stereotype.Service;

//import com.maverick.trainingproject.Model.UserLoginModel;
import com.maverick.trainingproject.Model.UserRegistrationInformationModel;
import com.maverick.trainingproject.Repository.LoginRepository;

@Service
public class LoginService {
	
	public boolean loginValidation(UserRegistrationInformationModel login) {
		return true;
		
	}
	
	public boolean login(UserRegistrationInformationModel login) {
		LoginRepository loginRepo= new LoginRepository();
		PasswordEncryption encryptionObj= new PasswordEncryption() ;
		String encryptedPassword = encryptionObj.encryptPassword(login.getUserPassword());
		login.setUserPassword(encryptedPassword);
		boolean intcheck1 = loginValidation(login);
		if(intcheck1) {
			boolean intcheck2 = loginRepo.userLoginCredentialCheckInDB(login);
			if(intcheck2) {
				return true;
			}
		}
			return false;
		
		
	}
}
