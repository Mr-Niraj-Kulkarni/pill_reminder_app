package com.maverick.trainingproject.Controller;


import java.io.IOException;

import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maverick.trainingproject.TrainingprojectApplication;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Service.JwtRequest;
import com.maverick.trainingproject.Service.JwtTokenUtil;
import com.maverick.trainingproject.Service.SendEmailService;
import com.maverick.trainingproject.Service.UserProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileService profileService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@CrossOrigin
	@RequestMapping(value = "/getProfileData", method = {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel getProfileData(HttpServletRequest request) {

		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		System.out.println(userEmail+"asasa");
		UserProfileModel model = new UserProfileModel();
		model = profileService.getUserProfileData(userEmail);
		return model;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public String setProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.setProfileData(model, tokenEmail);

	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/getDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public UserProfileModel getDependentProfileData(HttpServletRequest request, 
			@RequestBody Map<String,String> dependentObj) {
		
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		UserProfileModel dependentProfileModel;
		dependentProfileModel = profileService.getDependentProfileData(userEmail, 
				dependentObj.get("dependentRelation"), dependentObj.get("dependentName"));
		
		return dependentProfileModel;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public String setDependentProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		
		return profileService.setDependentProfileData(model, tokenEmail);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/addDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public String addDependentProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.addDependentProfileData(model, tokenEmail);
	}
	
}
