package com.maverick.trainingproject.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.maverick.trainingproject.Model.HomePageModel;
import com.maverick.trainingproject.Model.UserProfileModel;

public class HomePageRepository {
	public UserProfileModel getUserDataFromDB(String userEmail) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		int userId = new MedicalHistoryRepository().getUserId(userEmail, connect);
		System.out.println(userId);
		String query = "select i.userName, p.userHeight, p.userWeight, i.userContact from user_info i "
				+ "LEFT JOIN user_profile p on i.userId =p.userId where i.userId=?";
				     
		PreparedStatement pstmt = connect.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		UserProfileModel userObj = new UserProfileModel();
		if(rs.next()) {
			userObj.setUserName(rs.getString(1));
			userObj.setUserHeight(rs.getFloat(2));
			userObj.setUserWeight(rs.getFloat(3));;
			userObj.setUserContact(rs.getString(4));
			userObj.setUserId(userId);
		}
		userObj.setUserEmail(userEmail);
		System.out.println(userObj.getUserName());
		connect.close();
		return userObj;
	}
	
	
	/*public ArrayList<HomePageModel> getPillInfoFromDB(String userEmail) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		int userId = new MedicalHistoryRepository().getUserId(userEmail, connect);
		
		String query = "select * from pill_reminder_card where userId = ?";
				     
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<HomePageModel> homeList = new ArrayList<HomePageModel>();
		while(rs.next()) {
			
			HomePageModel obj = new HomePageModel();
			obj.setDependentId(rs.getInt("dependentId"));
			if(obj.getDependentId()!=null) {
				String query1 = "select dependentRelation, dependentName from user_dependents where dependentId=? ";
				PreparedStatement pstmt1 = connect.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
				
				pstmt1.setInt(1, obj.getDependentId().intValue());
				System.out.println(obj.getDependentId().intValue());
				System.out.println(obj.getDependentId());
				ResultSet rs1 = pstmt1.executeQuery();
				if(rs1.next()) {
					obj.setDependentRelation(rs1.getString("dependentRelation"));
					obj.setDependentName(rs1.getString("dependentName"));
				}
			}
			obj.setPillTableid(rs.getInt("pillTableId"));
			obj.setUserId(userId);
			obj.setPillName(rs.getString("pillName"));
			obj.setDosageAmount(rs.getInt("dosageAmount"));
			obj.setPillTime(rs.getTime("pillTime"));
			obj.setCheckbox(rs.getInt("checkbox"));
			homeList.add(obj);
		}
		
		return homeList;
	}*/
	
	// #################################################### NIRAJ ####################################################
	
	public ArrayList<HomePageModel> getPillInfoFromDB(String userEmail) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		int userId = new MedicalHistoryRepository().getUserId(userEmail, connect);
		
		String query = "select userMedicalHistoryId, userMedicine, userDosageAmount,userDosageBreakfastTime,userDosageLunchTime, "
				+ "userDosageDinnerTime,checkBoxBreakfast,checkBoxLunch,checkBoxDinner from user_medical_history "
				+ "where curdate() >= userMedicineStartDate AND (userMedicineEndDate >= curdate() "
				+ "OR userMedicineEndDate = null) AND  userId_M=?";
		
		String query1="select dependentMedicalHistoryId , dependentId, dependentMedicine, dependentDosageAmount,"
				+ "dependentDosageBreakfastTime,dependentDosageLunchTime, dependentDosageDinnerTime,"
				+ "checkBoxBreakfast,checkBoxLunch,checkBoxDinner from dependent_medical_history "
				+ "where curdate() >= dependentMedicineStartDate AND (dependentMedicineEndDate >= curdate() "
				+ "OR dependentMedicineEndDate = null)  and dependentUser=?" ;
		
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		String[] time= {"Breakfast","Lunch","Dinner"};
		
		
		ArrayList<HomePageModel> homeList = new ArrayList<HomePageModel>();
		while(rs.next()) {
			
			
			for(int i=0 ;i<3;i++) {
				HomePageModel obj = new HomePageModel();
				String str="userDosage"+time[i]+"Time";
				String str1="checkBox"+time[i];
				if(rs.getTime(str)!=null) {
					String s=String.valueOf(rs.getInt("userMedicalHistoryId"))+String.valueOf(i);
					obj.setDependentId(0);
					obj.setPillTableid(Integer.parseInt(s));
					obj.setUserId(userId);
					obj.setPillName(rs.getString("userMedicine"));
					obj.setDosageAmount(rs.getInt("userDosageAmount"));
					obj.setPillTime(rs.getTime(str));
					obj.setCheckbox(rs.getInt(str1));
					homeList.add(obj) ;
					
				}
				
			}
			
		}
		
		
		 pstmt = connect.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
		 pstmt.setInt(1, userId);
		 rs = pstmt.executeQuery();
		while(rs.next()) {
			String q="select dependentRelation, dependentName from user_dependents where dependentId=? ";
					  PreparedStatement pstmt1 =connect.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);
					  int dependentId= rs.getInt("dependentId");
					  System.out.println(dependentId+"this is dependent id");
					  pstmt1.setInt(1,dependentId);
					   ResultSet rs1 =pstmt1.executeQuery();
					   System.out.println(rs1);
					   String dependentRelation = null ; 
					   String dependentName = null;
					   
					   if(rs1.next()) {
						    dependentRelation=rs1.getString("dependentRelation");
						    dependentName=rs1.getString("dependentName");
						   
					   }
					   else {
						   System.out.println("Error");
					   }
					   
					   for(int i=0 ;i<3;i++) {
						   HomePageModel obj = new HomePageModel();
							String str="dependentDosage"+time[i]+"Time";
							String str1="checkBox"+time[i];
							if(rs.getTime(str)!=null) {
								String s=String.valueOf(rs.getInt("dependentMedicalHistoryId"))+String.valueOf(i)
								+String.valueOf(dependentId);
								
								obj.setPillTableid(Integer.parseInt(s));
								obj.setUserId(userId);
								obj.setDependentId(dependentId);
								obj.setPillName(rs.getString("dependentMedicine"));
								obj.setDosageAmount(rs.getInt("dependentDosageAmount"));
								obj.setPillTime(rs.getTime(str));
								obj.setCheckbox(rs.getInt(str1));
								obj.setDependentRelation(dependentRelation);
								obj.setDependentName(dependentName);
								homeList.add(obj) ;
								
							}
					   }
			
			
		}
		connect.close();
		return homeList;
	}
	
	// #################################################### NIRAJ ####################################################


	/*public boolean setPillStatusInDB(Map<String, Integer> pillObj) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		
		String query = "update pill_reminder_card set checkbox = ? where pillTableId = ?";
				     
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, pillObj.get("checkbox").intValue());
		pstmt.setInt(2, pillObj.get("pillTableId").intValue());
		int status = pstmt.executeUpdate();
		if(status == 1) {
			connect.close();
			return true;
		}
		connect.close();
		return false;
	}*/
	
	public boolean setPillStatusInDB(Map<String, Integer> pillObj) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		int checkbox=pillObj.get("checkbox").intValue() ;
		String str=String.valueOf(pillObj.get("pillTableId").intValue());
		String query=null ;
		int medId=0 ;
		int checkboxId=-1 ;
		String[] time= {"Breakfast","Lunch","Dinner"};
		if(str.length()==2) {
			
			medId=Integer.parseInt(String.valueOf(str.charAt(0)));
			checkboxId=Integer.parseInt(String.valueOf(str.charAt(1)));
			
			query="update user_medical_history SET checkBox"+time[checkboxId]+"=? where userMedicalHistoryId=?";
		}else {
			medId=Integer.parseInt(String.valueOf(str.charAt(0)));
			checkboxId=Integer.parseInt(String.valueOf(str.charAt(1)));
			
			query="update dependent_medical_history SET checkBox"+time[checkboxId]+"=? where dependentMedicalHistoryId=?";
		}
		
				     
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, checkbox);
		pstmt.setInt(2, medId);
		int status = pstmt.executeUpdate();
		if(status == 1) {
			return true;
		}
		
		return false;
	}
}
