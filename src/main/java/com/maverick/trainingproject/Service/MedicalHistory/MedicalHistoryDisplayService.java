package com.maverick.trainingproject.Service.MedicalHistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Repository.MedicalHistoryRepository;

public class MedicalHistoryDisplayService {

public ArrayList<MedicalHistoryModel> displayMedicalHistoryData(String userEmail,String dependentRelation,String dependentName) throws SQLException{
		
		if(userEmail==null) {
			return null  ;
		}
		
		ArrayList<MedicalHistoryModel> medicalHistoryData =new MedicalHistoryRepository().getMedicalHistoryDataFromDB(userEmail,dependentRelation,dependentName); 
		
		Collections.sort(medicalHistoryData,(
				new Comparator<MedicalHistoryModel>() {

					@Override
					public int compare(MedicalHistoryModel o1, MedicalHistoryModel o2) {
						
						
						if (o1.getMedicineEndDate() == null) {
					        if (o2.getMedicineEndDate() == null) {
					        	return  o1.getMedicine().compareTo(o2.getMedicine());	
					        }
					        else {
					        	return -1 ;
					        }
					    }
					    if (o2.getMedicineEndDate() == null) {
					        return 1;
					    }
					    int result=o2.getMedicineEndDate().compareTo(o1.getMedicineEndDate());
					    if(result==0) {
							return o1.getMedicine().compareTo(o2.getMedicine());
						}
					    return result ;
					}
					
				}));		
		
		
		return medicalHistoryData ; 
		
		
	}
	
	
}
