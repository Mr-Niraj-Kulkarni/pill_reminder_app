package com.maverick.trainingproject.Service;

import java.sql.SQLException;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryUpdateService {
	
	public boolean updateMedicalHistory(MedicalHistoryModel userObj,int flag) throws SQLException {
		
		if(new UserDataValidation().validateUpdateMedicalHistoryData(userObj.getMedicalHistoryId(),userObj.getMedicineStartDate(),userObj.getMedicineEndDate(),
																	 userObj.getDosageAmount(),userObj.getDosageFrequency(),userObj.getDoageBreakfastTime(),
												                     userObj.getDoageLunchTime(),userObj.getDoageDinnerTime())) {
			
			
			return new MedicalHistoryRepository().updateMedicalDataToDB(userObj.getMedicalHistoryId(),userObj.getMedicineStartDate(),userObj.getMedicineEndDate(),
					 													userObj.getDosageAmount(),userObj.getDosageFrequency(),userObj.getDoageBreakfastTime(),
					 													userObj.getDoageLunchTime(),userObj.getDoageDinnerTime(),flag);
			
			
		}
		
		return false  ;
	}
	
	
}
