package com.maverick.trainingproject.Service;

import java.sql.SQLException;


import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryUpdateService {
	
	public boolean updateMedicalHistory(MedicalHistoryModel userObj,int flag) throws SQLException {
		
		if(new UserDataValidation().validateUpdateMedicalHistoryData(userObj.getMedicalHistoryId(),userObj.getMedicineStartDate(),userObj.getMedicineEndDate(),
																	 userObj.getDosageAmount(),userObj.getDosageFrequency(),userObj.getDosageBreakfastTime(),
												                     userObj.getDosageLunchTime(),userObj.getDosageDinnerTime(),userObj.getEmailNotification())){
			
			
			return new MedicalHistoryRepository().updateMedicalDataToDB(userObj.getMedicalHistoryId(),userObj.getMedicineStartDate(),userObj.getMedicineEndDate(),
					 													userObj.getDosageAmount(),userObj.getDosageFrequency(),userObj.getDosageBreakfastTime(),
					 													userObj.getDosageLunchTime(),userObj.getDosageDinnerTime(),userObj.getEmailNotification(),flag);
			
			
		}
		
		return false  ;
	}
	
	
}
