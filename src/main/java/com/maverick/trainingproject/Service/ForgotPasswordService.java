package com.maverick.trainingproject.Service;



import java.sql.SQLException;

import org.springframework.stereotype.Service;

//import com.maverick.trainingproject.Model.UserForgotPasswordModel;
import com.maverick.trainingproject.Model.UserRegistrationInformationModel;
import com.maverick.trainingproject.Repository.LoginRepository;

@Service
public class ForgotPasswordService {

		
	public int updateNewPassword(UserRegistrationInformationModel  userForgotPasswordModelObj) throws SQLException {
		LoginRepository loginRepoObj = new LoginRepository() ;
		int status = loginRepoObj.UpdatePasswordInDB(userForgotPasswordModelObj.getUserEmail(), userForgotPasswordModelObj.getUserPassword(),
										userForgotPasswordModelObj.getSecretQuestion(),userForgotPasswordModelObj.getSecretAnswer()) ;
		
		if(status == 0) {
			return 0;
		}
		else if(status == 1) {
			return 1;
		}
		else {
			return 2;
		}
	}

	
}
