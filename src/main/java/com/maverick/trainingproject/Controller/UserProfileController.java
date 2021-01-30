package com.maverick.trainingproject.Controller;


<<<<<<< HEAD
=======
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;
<<<<<<< HEAD
=======
import com.maverick.trainingproject.Service.JwtRequest;
import com.maverick.trainingproject.Service.JwtTokenUtil;
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
import com.maverick.trainingproject.Service.UserProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileService profileService;
	
<<<<<<< HEAD
	
=======
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
	
	@CrossOrigin
	@RequestMapping(value = "/getProfileData", method = {RequestMethod.GET})
	@ResponseBody
<<<<<<< HEAD
	public UserProfileModel getProfileData() {
		String email = ("akk@gmail.com").trim();
		UserProfileModel model = new UserProfileModel();
		model = profileService.getUserProfileData(email);
=======
	public UserProfileModel getProfileData(HttpServletRequest request) {
		//JwtRequest getEmailForRequest = new JwtRequest();
		//String email = ("akk@gmail.com").trim();
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		System.out.println(userEmail+"asasa");
		UserProfileModel model = new UserProfileModel();
		model = profileService.getUserProfileData(userEmail);
		
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		return model;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setProfileData", method = {RequestMethod.POST})
	@ResponseBody
<<<<<<< HEAD
	public String setProfileData() {
		UserProfileModel model = new UserProfileModel();
		model.setUserName("AKKI");
		model.setUserEmail(("akki@gmail.com").trim());
		model.setUserContact("1234567890");
		model.setUserBloodGroup("C+");
		
//		date dalna h
//		model.setUserDateOfBirth("1998/01/01");
		
		model.setUserWeight(48);
		model.setUserHeight(159);
//		model.setUserProfilePic(null);
//		model.setUserId(1);
//		model.setUserProfileId(1);

		
		return profileService.setProfileData(model);
=======
	public String setProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.setProfileData(model,tokenEmail);
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
	}
	
	
	
	@CrossOrigin
<<<<<<< HEAD
	@RequestMapping(value = "/getDependentProfileData", method = {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel getDependentProfileData() {
		String userEmail = ("akk@gmail.com").trim();
		String dependentRelation = "Mother";
		String dependentName = "Saroj";
		UserProfileModel dependentProfileModel = new UserProfileModel();
		dependentProfileModel = profileService.getDependentProfileData(userEmail, dependentRelation, dependentName);
=======
	@RequestMapping(value = "/getDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public UserProfileModel getDependentProfileData(HttpServletRequest request, @RequestBody Map<String,String> dependentObj) {
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		UserProfileModel dependentProfileModel;
		dependentProfileModel = profileService.getDependentProfileData(userEmail, dependentObj.get("dependentRelation"), dependentObj.get("dependentName"));
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		return dependentProfileModel;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
<<<<<<< HEAD
	public String setDependentProfileData() {
		UserProfileModel dependentProfileModel = new UserProfileModel();
		dependentProfileModel.setDependentName("alisha");
		dependentProfileModel.setDependentEmail(("ali@gmail.com").trim());
		dependentProfileModel.setDependentRelation("Sister");
		dependentProfileModel.setDependentContact("9518476230");
		dependentProfileModel.setDependentBloodGroup("B+");
		
//		dependentProfileModel.setDependentDateOfBirth("");
		dependentProfileModel.setDependentWeight(24);
		dependentProfileModel.setDependentHeight(198);
		dependentProfileModel.setUserEmail(("akk@gmail.com").trim());
		
		return profileService.setDependentProfileData(dependentProfileModel);
=======
	public String setDependentProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.setDependentProfileData(model,tokenEmail);
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		
	}
	
}
