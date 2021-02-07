package com.maverick.trainingproject.Controller;
//import com.maverick.trainingproject.Model.UserForgotPasswordModel;
//import com.maverick.trainingproject.Model.UserLoginModel;

import com.maverick.trainingproject.Model.UserRegistrationInformationModel;

import com.maverick.trainingproject.Service.Authorization.JwtResponse;
import com.maverick.trainingproject.Service.Authorization.JwtTokenUtil;
import com.maverick.trainingproject.Service.Login.ForgotPasswordService;
import com.maverick.trainingproject.Service.Login.LoginService;
import com.maverick.trainingproject.Service.Login.PasswordEncryption;
import com.maverick.trainingproject.Service.Login.UserRegistrationService;
import com.maverick.trainingproject.Service.MedicalHistory.SendEmailService;

import java.util.*;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class LoginController {
	
	LoginService loginRequestFromUser;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private SendEmailService sendEmailOnReg;
	
	
	@CrossOrigin
	@RequestMapping(value = "/" , method= {RequestMethod.GET})
	public String index() {
		return "login.html";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/login" , method= {RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody UserRegistrationInformationModel login){
		loginRequestFromUser = new LoginService();
		System.out.println(login.getUserEmail());
		
		boolean check = loginRequestFromUser.login(login);
		if(check) {
			final UserDetails userDetails = new User(login.getUserEmail(),login.getUserPassword(),
					new ArrayList<>());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		}
		return ResponseEntity.ok(new JwtResponse(null));
	}
	

	@CrossOrigin
	@RequestMapping(value = "/register",method= {RequestMethod.POST})
	@ResponseBody
	public boolean RegisterUser(@RequestBody UserRegistrationInformationModel userObj) throws InterruptedException {
		UserRegistrationService  userRegistrationServiceObject= new UserRegistrationService() ;
		System.out.println(userObj.getUserCountry());
		System.out.println(userObj.getUserContact());
		System.out.println("NIraj");
		boolean status=userRegistrationServiceObject.registerUser(userObj) ;
		if(status) {
			sendEmailOnReg.sendEmailOnReg(userObj.getUserName(), userObj.getUserEmail());
			return true ;
		}
		return false ;
	}
	
	
	@CrossOrigin
	@PostMapping(value = "/passwordUpdate")
	@ResponseBody
	public int checkUser(@RequestBody UserRegistrationInformationModel  userForgotPasswordModelObj ) throws SQLException {
		
		
		 PasswordEncryption encryption = new PasswordEncryption();
		 String encryptedPassword = encryption.encryptPassword(userForgotPasswordModelObj.getUserPassword());
		 System.out.println(encryptedPassword);
		 System.out.println(userForgotPasswordModelObj.getSecretAnswer());
		 System.out.println(userForgotPasswordModelObj.getSecretQuestion());
		 System.out.println(userForgotPasswordModelObj.getUserEmail());
		 userForgotPasswordModelObj.setUserPassword(encryptedPassword);
		 
		 ForgotPasswordService forgotPasswordServiceObj = new ForgotPasswordService() ;
		 int status = forgotPasswordServiceObj.updateNewPassword(userForgotPasswordModelObj);
		 
		 return status ;
	}

	@CrossOrigin
	@RequestMapping(value = "/home" , method= {RequestMethod.GET})
	@ResponseBody
	public String showHomePage() {
		
		 
		 return "message" ;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/authenticateUser" , method= {RequestMethod.GET})
	@ResponseBody
	public void authenticateUser() {}
}

