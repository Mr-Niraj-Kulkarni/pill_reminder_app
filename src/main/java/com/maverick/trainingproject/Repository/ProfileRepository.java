package com.maverick.trainingproject.Repository;

import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;

public interface ProfileRepository {

	UserProfileModel getUserProfileData(String email);

	public int setProfileData(String userName, String userEmail, String userContact, String userBloodGroup,
			Date userDateOfBirth, float userWeight, float userHeight,
			int userProfileId,String tokenEmail) throws SQLException;
	
	UserProfileModel getDependentProfileData(String userEmail, String dependentRelation, String dependentName);

	public int setDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail);

	public int addDependentProfileData(UserProfileModel model, String tokenEmail);
	
}
