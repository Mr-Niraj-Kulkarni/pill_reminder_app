package com.maverick.trainingproject.Service;



import org.springframework.stereotype.Service;


import com.maverick.trainingproject.Repository.LoginRepo;

@Service
public class ForgotService {

	
	private LoginRepo loginRepo;
	
	public Boolean getCheck(String useremail, String secretAns) {
		loginRepo = new LoginRepo();
		String userEmail = useremail.trim();
		Boolean arr = loginRepo.getEmailCheck(userEmail, secretAns);
		return arr;
	}

	public String updateChange(String useremail, String secretAns, String password) {
		// TODO Auto-generated method stub
		loginRepo = new LoginRepo();
		String msg = "";
		String userEmail = useremail.trim();
		String passWord = password.trim();
		int id = loginRepo.getUserId(userEmail, secretAns);
		boolean chechPass = loginRepo.checkOldPass(id, passWord);
		if (chechPass) {
			msg = "You can not enter old password again, Try with another password";
		}else {
			loginRepo.updateChange(id, passWord);
			msg = "Successfully Updated";
		}
		return msg;
	}

	
}
