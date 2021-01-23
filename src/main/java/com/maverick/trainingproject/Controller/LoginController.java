package com.maverick.trainingproject.Controller;
import com.maverick.trainingproject.Model.UserRegistrationInformation;
import com.maverick.trainingproject.Model.loginModel;

import com.maverick.trainingproject.Service.LoginService;
import com.maverick.trainingproject.Service.UserRegistrationService;

import java.util.*;
import java.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public String login(@RequestBody loginModel login) throws FileNotFoundException {
		loginRequestFromUser = new LoginService();
		
		File mainMenu = new File("E:\\Pill_Reminder_app\\trainingproject\\target\\classes\\static\\txt\\mainmenu.txt");
		sc = new Scanner(mainMenu);
		while(sc.hasNextLine()) {
			afterLoginMenu = sc.nextLine();
			//System.out.println(mainmenu);
		}
		System.out.println(login.getEmail());
		
		boolean check = loginRequestFromUser.login(login);
		if(check) {
			//System.out.println("true returned");
			return afterLoginMenu;
		}
		//System.out.println("false returend");
		return "false";
	}
	

	@CrossOrigin
	@RequestMapping(value = "/register",method= {RequestMethod.POST})
	@ResponseBody
	public String RegisterUser(@RequestBody UserRegistrationInformation userObj) {
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
	
	
	
}

