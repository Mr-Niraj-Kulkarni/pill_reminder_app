package com.maverick.trainingproject.Controller;
//import com.maverick.trainingproject.Model.UserForgotPasswordModel;
//import com.maverick.trainingproject.Model.UserLoginModel;

import com.maverick.trainingproject.Model.UserRegistrationInformationModel;
//<<<<<<< HEAD
//
//import com.maverick.trainingproject.Service.ForgotPasswordService;
//=======
import com.maverick.trainingproject.Repository.LoginRepository;
import com.maverick.trainingproject.Service.ForgotPasswordService;
import com.maverick.trainingproject.Service.JwtResponse;
import com.maverick.trainingproject.Service.JwtTokenUtil;
//>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
import com.maverick.trainingproject.Service.LoginService;
import com.maverick.trainingproject.Service.PasswordEncryption;
import com.maverick.trainingproject.Service.UserRegistrationService;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

//<<<<<<< HEAD
//=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@CrossOrigin
	@RequestMapping(value = "/" , method= {RequestMethod.GET})
	public String index() {
		return "login.html";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/login" , method= {RequestMethod.POST})
	@ResponseBody
//<<<<<<< HEAD
//	public String login(@RequestBody UserLoginModel login) throws FileNotFoundException {
//		loginRequestFromUser = new LoginService();
//	
//		//System.out.println(flag.containsKey("flag"));
//		File mainMenu = new File("E:\\Pill_Reminder_app\\trainingproject\\target\\classes\\static\\txt\\mainmenu.txt");
//		sc = new Scanner(mainMenu);
//		while(sc.hasNextLine()) {
//			afterLoginMenu = sc.nextLine();
//			
//		}
//=======
	public ResponseEntity<?> login(@RequestBody UserRegistrationInformationModel login){
		loginRequestFromUser = new LoginService();
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		System.out.println(login.getUserEmail());
		
		boolean check = loginRequestFromUser.login(login);
		if(check) {
//<<<<<<< HEAD
//			
//			return afterLoginMenu;
//		}
//		
//		return "false";
//=======
			final UserDetails userDetails = new User(login.getUserEmail(),login.getUserPassword(),
					new ArrayList<>());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
			//return login.getUserId();
		}
		
		return ResponseEntity.ok(new JwtResponse(null));
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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
	public String checkUser(@RequestBody UserRegistrationInformationModel  userForgotPasswordModelObj ) throws SQLException {
		
		
		 PasswordEncryption encryption = new PasswordEncryption();
		 String encryptedPassword = encryption.encryptPassword(userForgotPasswordModelObj.getUserPassword());
		 userForgotPasswordModelObj.setUserPassword(encryptedPassword);
		 
		 ForgotPasswordService forgotPasswordServiceObj = new ForgotPasswordService() ;
		 String message = forgotPasswordServiceObj.updateNewPassword(userForgotPasswordModelObj);
		 
		 return message ;
		
		
		
	}
	
	
//<<<<<<< HEAD
//=======
	@CrossOrigin
	@RequestMapping(value = "/home" , method= {RequestMethod.GET})
	@ResponseBody
	public String showHomePage() {
		
		 
		 return "message" ;
		
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSecretAns" , method= {RequestMethod.POST})
	@ResponseBody
	public String showSecretAns(@RequestBody UserRegistrationInformationModel login) {
		LoginRepository lr1 = new LoginRepository();
		String ans = lr1.getsecretpassword(login);
		 
		 return ans ;
		
		
		
	}
	
	
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
	
}

