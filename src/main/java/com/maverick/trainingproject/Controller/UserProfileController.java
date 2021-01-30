package com.maverick.trainingproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Service.UserProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileService profileService;
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/getProfileData", method = {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel getProfileData() {
		String email = ("akk@gmail.com").trim();
		UserProfileModel model = new UserProfileModel();
		model = profileService.getUserProfileData(email);
		return model;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setProfileData", method = {RequestMethod.POST})
	@ResponseBody
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
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/getDependentProfileData", method = {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel getDependentProfileData() {
		String userEmail = ("akk@gmail.com").trim();
		String dependentRelation = "Mother";
		String dependentName = "Saroj";
		UserProfileModel dependentProfileModel = new UserProfileModel();
		dependentProfileModel = profileService.getDependentProfileData(userEmail, dependentRelation, dependentName);
		return dependentProfileModel;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
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
		
	}
	
}
