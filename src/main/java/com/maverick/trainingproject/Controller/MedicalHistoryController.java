package com.maverick.trainingproject.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Service.Authorization.JwtTokenUtil;
import com.maverick.trainingproject.Service.MedicalHistory.MedicalHistoryAddService;
import com.maverick.trainingproject.Service.MedicalHistory.MedicalHistoryDeleteService;
import com.maverick.trainingproject.Service.MedicalHistory.MedicalHistoryDisplayService;
import com.maverick.trainingproject.Service.MedicalHistory.MedicalHistoryUpdateService;

@Controller
public class MedicalHistoryController {
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@CrossOrigin
	@RequestMapping(value = "/addUserMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public boolean addUserMedicalHistory(HttpServletRequest request,@RequestBody MedicalHistoryModel usermedicalHistoryModelObj) throws SQLException {
		MedicalHistoryAddService medicalHistoryAddServiceObj= new MedicalHistoryAddService();
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		System.out.println(usermedicalHistoryModelObj.getDosageLunchTime());
		System.out.println(usermedicalHistoryModelObj.getDosageDinnerTime());
		System.out.println(usermedicalHistoryModelObj.getDosageBreakfastTime());
		
		boolean status=medicalHistoryAddServiceObj.addUserMedicalHistory(usermedicalHistoryModelObj,userEmail);
		
		return  status ;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/addDependentMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public boolean addDependentMedicalHistory(HttpServletRequest request,@RequestBody DependentMedicalHistoryModel dependentMedicalHistoryModelObj) throws SQLException {
		MedicalHistoryAddService medicalHistoryAddServiceObj= new MedicalHistoryAddService();
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		boolean status=medicalHistoryAddServiceObj.addDependentMedicalHistory(dependentMedicalHistoryModelObj,userEmail);
		
		return  status ;
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
	public ArrayList<MedicalHistoryModel> displayMedicalHistory(HttpServletRequest request,@RequestBody Map<String,String> medicalHistoryObj) throws SQLException {
		 System.out.println(medicalHistoryObj.get("dependentRelation"));
		 System.out.println(medicalHistoryObj.get("dependentName"));
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		ArrayList<MedicalHistoryModel> arrlist =new MedicalHistoryDisplayService().displayMedicalHistoryData(userEmail,
				medicalHistoryObj.get("dependentRelation") , 
				medicalHistoryObj.get("dependentName"));

		//System.out.println(arrlist.size());
		return  arrlist ;
	}
	
	
	
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/deleteSingleMedicalHistory",method= {RequestMethod.POST})
	@ResponseBody
	public boolean deleteSingleUserMedicalHistory(@RequestBody Map<String,Integer> obj) throws SQLException {
		
		
		boolean status=new MedicalHistoryDeleteService().DeleteUserMedicalHistory(obj.get("medicalHistoryId"), obj.get("flag")) ;
		
		return  status ;
	}
	
	
	
}
