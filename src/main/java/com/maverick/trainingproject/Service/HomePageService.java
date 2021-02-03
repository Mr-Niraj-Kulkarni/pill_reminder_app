package com.maverick.trainingproject.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.maverick.trainingproject.Model.HomePageModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Repository.HomePageRepository;

public class HomePageService {
	
	public UserProfileModel getUserInformation(String userEmail) throws SQLException {
		return new HomePageRepository().getUserDataFromDB(userEmail);
	}
	
	public ArrayList<HomePageModel> getPillInfo(String userEmail) throws SQLException {
		return new HomePageRepository().getPillInfoFromDB(userEmail);
	}
	
	public boolean setPillStatus(Map<String, Integer> pillObj) throws SQLException {
		return new HomePageRepository().setPillStatusInDB(pillObj);
	}

}
