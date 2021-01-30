package com.maverick.trainingproject.Controller;
import com.maverick.trainingproject.Model.UserForgotPasswordModel;
import com.maverick.trainingproject.Model.UserLoginModel;

import com.maverick.trainingproject.Model.UserRegistrationInformationModel;

import com.maverick.trainingproject.Service.ForgotPasswordService;
import com.maverick.trainingproject.Service.LoginService;
import com.maverick.trainingproject.Service.PasswordEncryption;
import com.maverick.trainingproject.Service.UserRegistrationService;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

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
	Scanner sc;
	private String afterLoginMenu;
	
	
	@CrossOrigin
	@RequestMapping(value = "/" , method= {RequestMethod.GET})
	public String index() {
		return "login.html";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/login" , method= {RequestMethod.POST})
	@ResponseBody
	public String login(@RequestBody UserLoginModel login) throws FileNotFoundException {
		loginRequestFromUser = new LoginService();
	
		//System.out.println(flag.containsKey("flag"));
		File mainMenu = new File("E:\\Pill_Reminder_app\\trainingproject\\target\\classes\\static\\txt\\mainmenu.txt");
		sc = new Scanner(mainMenu);
		while(sc.hasNextLine()) {
			afterLoginMenu = sc.nextLine();
			
		}
		System.out.println(login.getUserEmail());
		
		boolean check = loginRequestFromUser.login(login);
		if(check) {
			
			return afterLoginMenu;
		}
		
		return "false";
	}
	

	@CrossOrigin
	@RequestMapping(value = "/register",method= {RequestMethod.POST})
	@ResponseBody
	public String RegisterUser(@RequestBody UserRegistrationInformationModel userObj) {
		UserRegistrationService  userRegistrationServiceObject= new UserRegistrationService() ;
		System.out.println(userObj.getUserCountry());
		System.out.println(userObj.getUserContact());
		System.out.println("NIraj");
		boolean status=userRegistrationServiceObject.registerUser(userObj) ;
		if(status) {
			return "home" ;
		}
		return "Error at the server side" ;
	}
	
	
	@CrossOrigin
	@PostMapping(value = "/passwordUpdate")
	@ResponseBody
	public String checkUser(@RequestBody UserForgotPasswordModel  userForgotPasswordModelObj ) throws SQLException {
		
		
		PasswordEncryption encryption = new PasswordEncryption();
		 String encryptedPassword=encryption.encryptPassword(userForgotPasswordModelObj.getUserPassword());
		 userForgotPasswordModelObj.setUserPassword(encryptedPassword);
		 
		 ForgotPasswordService forgotPasswordServiceObj = new ForgotPasswordService() ;
		 String message =forgotPasswordServiceObj.updateNewPassword(userForgotPasswordModelObj);
		 
		 return message ;
		
		
		
	}
	
	
	
}

