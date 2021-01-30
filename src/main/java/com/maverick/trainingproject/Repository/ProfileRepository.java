package com.maverick.trainingproject.Repository;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;

public interface ProfileRepository {

	UserProfileModel getUserProfileData(String email);

	public int setProfileData(String userName, String userEmail, String userContact, String userBloodGroup,
			Date userDateOfBirth, float userWeight, float userHeight, Blob userProfilePic, int userId,
<<<<<<< HEAD
			int userProfileId);
	
	UserProfileModel getDependentProfileData(String userEmail, String dependentRelation, String dependentName);

	public int setDependentProfileData(UserProfileModel dependentProfileModel);
=======
			int userProfileId,String tokenEmail);
	
	UserProfileModel getDependentProfileData(String userEmail, String dependentRelation, String dependentName);

	public int setDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail);
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
	
}
