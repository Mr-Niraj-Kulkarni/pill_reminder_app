package com.maverick.trainingproject.Service;

import java.sql.SQLException;


import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryDeleteService {

	public boolean DeleteUserMedicalHistory(int medicalHistoryId,int flag) throws SQLException {
		
		return new MedicalHistoryRepository().deleteMedicalHistoryDataEntryFromDB(medicalHistoryId, flag); 
	}
	
	
	
}
