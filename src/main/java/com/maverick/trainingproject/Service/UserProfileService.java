package com.maverick.trainingproject.Service;

import java.sql.Blob;
import java.sql.Date;

import org.springframework.stereotype.Service;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Repository.ProfileRepositoryImplementation;

@Service
public class UserProfileService {

	public UserProfileModel getUserProfileData(String email) {
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		return repo.getUserProfileData(email);
	}

//	public String setProfileData(String userName, String userEmail, String userContact, String userBloodGroup,
//			Date date, float userWeight, float userHeight, Blob userProfilePic, int userId,
//			int userProfileId) 
//	
	public String setProfileData(UserProfileModel model)
	{
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		int status = repo.setProfileData(model.getUserName(), model.getUserEmail(), model.getUserContact(),
				model.getUserBloodGroup(), model.getUserDateOfBirth(), model.getUserWeight(),
				model.getUserHeight(), model.getUserProfilePic(), model.getUserId(), model.getUserProfileId());
		if (status == 0) {
			return "New Email Id aldredy exist in database with other user, Try with Another Email Id.";
		}else if (status == 1) {
			return "Profile Data Updated Successfully.";
		}else if (status == 2) {
			return "Error occur, Logout and try again.";
		}else{ //status == 3
			return "Error occur while updating, Check the Fields and Try again.";
		}
	}

	public UserProfileModel getDependentProfileData(String userEmail, String dependentRelation, String dependentName) {
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		return repo.getDependentProfileData(userEmail, dependentRelation, dependentName);
	}

	public String setDependentProfileData(UserProfileModel dependentProfileModel) {
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		int status = repo.setDependentProfileData(dependentProfileModel);
		if (status == 0) {
			return "This Email Id exist in Database with other user, try with another Email Id.";
		}else if (status == 1) {
			return "Dependent Data Updated Successfully.";
		}else if (status == 3) {
			return "New Dependent Data Insert Successfully.";
		}
		else{//status == 2
			return "Error occurs in connection, Logout and Try again.";
		}
		
	}

}
