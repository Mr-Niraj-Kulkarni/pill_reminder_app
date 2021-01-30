package com.maverick.trainingproject.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;

import com.maverick.trainingproject.Service.MedicalHistoryAddService;
import com.maverick.trainingproject.Service.MedicalHistoryDeleteService;
import com.maverick.trainingproject.Service.MedicalHistoryDisplayService;
import com.maverick.trainingproject.Service.MedicalHistoryUpdateService;

@Controller
public class MedicalHistoryController {

	@CrossOrigin
	@RequestMapping(value = "/AddUserMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String addUserMedicalHistory(@RequestBody MedicalHistoryModel usermedicalHistoryModelObj) throws SQLException {
		MedicalHistoryAddService medicalHistoryAddServiceObj= new MedicalHistoryAddService();
		
		boolean status=medicalHistoryAddServiceObj.addUserMedicalHistory(usermedicalHistoryModelObj);
		
		return  ""+status ;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/AddDependentMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String addDependentMedicalHistory(@RequestBody DependentMedicalHistoryModel dependentMedicalHistoryModelObj) throws SQLException {
		MedicalHistoryAddService medicalHistoryAddServiceObj= new MedicalHistoryAddService();
		
		boolean status=medicalHistoryAddServiceObj.addDependentMedicalHistory(dependentMedicalHistoryModelObj);
		
		return  ""+status ;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/updateUserMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String updateUserMedicalHistory(@RequestBody MedicalHistoryModel medicalHistoryModelObj) throws SQLException {
		
		int flag=0 ;
		boolean status=new MedicalHistoryUpdateService().updateMedicalHistory(medicalHistoryModelObj,flag);
		
		return  ""+status ;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/updateDependentMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String updateDependentMedicalHistory(@RequestBody MedicalHistoryModel dependentmedicalHistoryModelObj) throws SQLException {
		
		int flag=1 ;
		boolean status=new MedicalHistoryUpdateService().updateMedicalHistory(dependentmedicalHistoryModelObj,flag);
		
		return  ""+status ;
	}
	
	
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/displayMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public ArrayList<MedicalHistoryModel> displayMedicalHistory(@RequestBody Map<String,String> medicalHistoryObj) throws SQLException {
		 
			
		return new MedicalHistoryDisplayService().displayMedicalHistoryData(medicalHistoryObj.get("userEmail"),
																			medicalHistoryObj.get("dependentRelation") , 
																			medicalHistoryObj.get("dependentName"));
		
	}
	
	
	
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/deleteSingleMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String deleteSingleUserMedicalHistory(@RequestBody Map<String,Integer> obj) throws SQLException {
		
		
		boolean status=new MedicalHistoryDeleteService().DeleteUserMedicalHistory(obj.get("medicalHistoryId"), obj.get("flag")) ;
		
		return  ""+status ;
	}
	
	
	
}
