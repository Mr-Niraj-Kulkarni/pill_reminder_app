package com.maverick.trainingproject.Service;


import java.sql.SQLException;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;

import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryAddService {
	
	public boolean addUserMedicalHistory(MedicalHistoryModel userMedicalHistoryModelObj) throws SQLException {
		if(new UserDataValidation().validateUserMedicalHistory(userMedicalHistoryModelObj))
			return new MedicalHistoryRepository().InsertUserMedicalDataToDB(userMedicalHistoryModelObj); 
		
		return false ; 
	}
	
	public boolean addDependentMedicalHistory(DependentMedicalHistoryModel dependentMedicalHistoryModelObj) throws SQLException {
		if(new UserDataValidation().validateDependentMedicalHistory(dependentMedicalHistoryModelObj)) {
			System.out.println("here in fucnton");
			return new MedicalHistoryRepository().InsertDependentMedicalDataToDB(dependentMedicalHistoryModelObj); 
		}
		return false;
	}

}
