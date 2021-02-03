package com.maverick.trainingproject.Service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Service;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Model.userImageModel;
import com.maverick.trainingproject.Repository.ProfileRepositoryImplementation;

@Service
public class UserProfileService {

	public UserProfileModel getUserProfileData(String email) {
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		return repo.getUserProfileData(email);
	}


	public String setProfileData(UserProfileModel model, String tokenEmail)
	{
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		int status = repo.setProfileData(model.getUserName(), model.getUserEmail(), model.getUserContact(),
				model.getUserBloodGroup(), model.getUserDateOfBirth(), model.getUserWeight(),
				model.getUserHeight(), model.getUserProfilePic(), model.getUserId(), model.getUserProfileId(), tokenEmail);

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


	public String setDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail) {
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		int status = repo.setDependentProfileData(dependentProfileModel, tokenEmail);

		if (status == 0) {
			return "Error whle updating data, try again.";
		}else if (status == 1) {
			return "Dependent Data Updated Successfully.";
		}else{//status == 2
			return "Error occurs in connection, Logout and Try again.";
		}
		
	}


	public String addDependentProfileData(UserProfileModel model, String tokenEmail) {
		
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
		int status = repo.addDependentProfileData(model, tokenEmail);

		//msg correct
		if (status == 0) {
			return "Error occurs in connection, Logout and Try again.";
		}else if (status == 1) {
			return "New Dependent Data Insert Successfully.";
		}else {// status == 2
			return "Error whle inserting data, try again.";
		}
		
	}
	
	public boolean setPic(userImageModel Obj, String tokenEmail) throws SQLException {
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
	     return repo.setPicToDB(Obj, tokenEmail);
	}
	public Blob getImage(String tokenEmail) throws SQLException, IOException {
		ProfileRepositoryImplementation repo = new ProfileRepositoryImplementation();
	     return repo.getImageFromDB(tokenEmail);
	}

}
