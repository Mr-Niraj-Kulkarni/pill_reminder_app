package com.maverick.trainingproject.Service;
import org.springframework.stereotype.Service;
import com.maverick.trainingproject.Model.loginModel;
import com.maverick.trainingproject.Repository.LoginRepo;

@Service
public class LoginService {
	LoginRepo databaseRequestForLogin;
	PasswordEncryption doMd5 = new PasswordEncryption();
	String hashedPassword;
	
	public boolean loginValidation(loginModel login) {
		return true;
		
	}
	
	public boolean login(loginModel login) {
		databaseRequestForLogin = new LoginRepo();
		hashedPassword = doMd5.encryptPassword(login.getPassword());
		login.setPassword(hashedPassword);
		boolean intcheck1 = loginValidation(login);
		if(intcheck1) {
			boolean intcheck2 = databaseRequestForLogin.logincheck(login);
			if(intcheck2) {
				return true;
			}
		}
			return false;
		
		
	}
}
