package com.maverick.trainingproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maverick.trainingproject.Model.UserRegistrationInformation;
import com.maverick.trainingproject.Service.ForgotService;
import com.maverick.trainingproject.Service.PasswordEncryption;

@Controller
public class ForgotController {

	@Autowired
	private ForgotService forgotService;
	
	
	
	@RequestMapping(value = "/forgotpage")
	public String forgitPage() {
		return "forgotPage.html";
	}
	
	@GetMapping(value = "/savechange")
	@ResponseBody
	public String checkUser() {
		
		UserRegistrationInformation regObj = new UserRegistrationInformation();
		regObj.setUserEmail("abc@gmail.com");
		regObj.setSecretAnswer("black");
		
//		String useremail = "abc@gmail.com";
//		String secretAns = "black";
		String msg = "";
		
		Boolean userCheck = forgotService.getCheck(regObj.getUserEmail(), regObj.getSecretAnswer());
		if (userCheck) {
			System.out.println("enter data");
			
			PasswordEncryption encryption = new PasswordEncryption();
			String password = encryption.encryptPassword("passwordisabc");
			String confirmPassword = encryption.encryptPassword("passwordisabc");
				
			if (password.equals(confirmPassword)) {
				regObj.setUserPassword(password);
				msg = forgotService.updateChange(regObj.getUserEmail(), regObj.getSecretAnswer(), regObj.getUserPassword());
			}else {
				msg = "New password and Confirm password does not match";
			}
			
		}else {
			System.out.println("banda exist nhi karta db me");
			msg = "User does not exist";
		}
		return msg;
		
	}
	
	@RequestMapping(value = "/cancelchange")
	public String cancelForgot() {
		return "login.html";
	}
	
	
}
