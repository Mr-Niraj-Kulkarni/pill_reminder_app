package com.maverick.trainingproject.Controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maverick.trainingproject.Model.HomePageModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Model.UserRegistrationInformationModel;
import com.maverick.trainingproject.Service.HomePageService;
import com.maverick.trainingproject.Service.JwtTokenUtil;
import com.maverick.trainingproject.Service.UserRegistrationService;

@Controller
public class HomeController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@CrossOrigin
	@RequestMapping(value = "/userInfo",method= {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel GetUserInfo(HttpServletRequest request) throws SQLException {
		
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		UserProfileModel userObj2 = new HomePageService().getUserInformation(userEmail);
		if(userObj2 != null) {
			return userObj2;
		}
		
		return null;
}
	
	@CrossOrigin
	@RequestMapping(value = "/getPillInfo",method= {RequestMethod.GET})
	@ResponseBody
	public ArrayList<HomePageModel> getPillInfo(HttpServletRequest request) throws SQLException {
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		ArrayList<HomePageModel> pillArray = new HomePageService().getPillInfo(userEmail);
		return pillArray;
}
	
	@CrossOrigin
	@RequestMapping(value = "/setPillStatus",method= {RequestMethod.POST})
	@ResponseBody
	public boolean setPillStatus(@RequestBody Map<String, Integer> pillObj) throws SQLException {
		System.out.println(pillObj.get("checkbox"));
		System.out.println(pillObj.get("pillTableId"));
		return new HomePageService().setPillStatus(pillObj);
}
	
	
}
