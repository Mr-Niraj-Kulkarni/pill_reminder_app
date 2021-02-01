package com.maverick.trainingproject.Service;


import java.sql.SQLException;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;

import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryAddService {
	
	public boolean addUserMedicalHistory(MedicalHistoryModel userMedicalHistoryModelObj,String userEmail) throws SQLException {
		if(new UserDataValidation().isValidEmail(userEmail)) {
		if(new UserDataValidation().validateUserMedicalHistory(userMedicalHistoryModelObj))
			return new MedicalHistoryRepository().InsertUserMedicalDataToDB(userMedicalHistoryModelObj,userEmail); 
		}
		return false ; 
	}
	
	public boolean addDependentMedicalHistory(DependentMedicalHistoryModel dependentMedicalHistoryModelObj,String userEmail) throws SQLException {
		if(new UserDataValidation().validateDependentMedicalHistory(dependentMedicalHistoryModelObj)) {
			System.out.println("here in fucnton");
			return new MedicalHistoryRepository().InsertDependentMedicalDataToDB(dependentMedicalHistoryModelObj,userEmail); 
		}
		return false;
	}

}
