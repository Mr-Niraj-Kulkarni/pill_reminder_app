package com.maverick.trainingproject.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryDisplayService {

	public ArrayList<MedicalHistoryModel> displayMedicalHistoryData(String userEmail,String dependentRelation,String dependentName) throws SQLException{
		
		if(userEmail==null) {
			return null  ;
		}
		
		ArrayList<MedicalHistoryModel> medicalHistoryData =new MedicalHistoryRepository().getMedicalHistoryDataFromDB(userEmail,dependentRelation,dependentName); 
		
		return medicalHistoryData ; 
		
		
	}
	
	
}
