package com.maverick.trainingproject.Service;



import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.maverick.trainingproject.Model.UserForgotPasswordModel;

import com.maverick.trainingproject.Repository.LoginRepository;

@Service
public class ForgotPasswordService {

		
	public String updateNewPassword(UserForgotPasswordModel  userForgotPasswordModelObj) throws SQLException {
		LoginRepository loginRepoObj = new LoginRepository() ;
		int status = loginRepoObj.UpdatePasswordInDB(userForgotPasswordModelObj.getUserEmail(), userForgotPasswordModelObj.getUserPassword(),
										userForgotPasswordModelObj.getUserQuestion(),userForgotPasswordModelObj.getUserAnswer()) ;
		
		if(status == 0) {
			return "User does not exist";
		}
		else if(status == 1) {
			return "password updated successfully";
		}
		else {
			return "You can not enter old password again, Try with another password";
		}
	}

	
}
