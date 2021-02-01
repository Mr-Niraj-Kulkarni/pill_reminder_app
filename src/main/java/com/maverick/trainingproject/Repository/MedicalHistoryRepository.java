package com.maverick.trainingproject.Repository;

import java.sql.*;
import java.util.ArrayList;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;


public class MedicalHistoryRepository {
	
	public int getUserId(String userEmail,Connection connect) throws SQLException {
		
		 
	    String query="select userId from user_info where userEmail='"+userEmail+"'";
	    
	    ResultSet rs= connect.createStatement().executeQuery(query);
		if(rs.next()) {
			return rs.getInt("userId");
		}
		return 0 ;
	}
	
	
	public int getDependentId(int userId,String dependentRelation,String dependentName,Connection connect) throws SQLException {
		
		 System.out.println(dependentRelation);
		 System.out.println(dependentName);
	    String query="select dependentId from user_dependents where userId=? and dependentRelation=? and dependentName=?";
	    
	    PreparedStatement pstmt = connect.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
	    pstmt.setInt(1, userId);
	    pstmt.setString(2,dependentRelation);
	    pstmt.setString(3,dependentName);
	    ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("this dependent"+rs.getInt("dependentId"));
			return rs.getInt("dependentId");
		}
		return 0 ;
	}
	
	public boolean InsertUserMedicalDataToDB(MedicalHistoryModel userMedicalHistoryModelObj,String userEmail) throws SQLException {
		DataBaseConnection  dbObj= new DataBaseConnection() ;
		
	    Connection connect = dbObj.databaseConnection() ;
	    int userId=getUserId(userEmail,connect);
	    
	    //insert query inserting user Medical History 
	    String query= "insert into user_medical_history (userId_M,userIlliness,userDoctorDetails,userMedicine,"
	    												+"userMedicineStartDate,userMedicineEndDate,userDosageAmount,userDosageFrequency,"
	    												+ "userDosageBreakfastTime,userDosageLunchTime,userDosageDinnerTime,emailNotification)"
	    												+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    PreparedStatement pstmt = connect.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
	    
	    
	    //set Statement 
	    pstmt.setInt(1,userId);
	    pstmt.setString(2, userMedicalHistoryModelObj.getIlliness());
	    pstmt.setString(3, userMedicalHistoryModelObj.getDoctorDetails());
	    pstmt.setString(4, userMedicalHistoryModelObj.getMedicine());
	    pstmt.setDate(5, userMedicalHistoryModelObj.getMedicineStartDate());
	    pstmt.setDate(6, userMedicalHistoryModelObj.getMedicineEndDate());
	    pstmt.setInt(7, userMedicalHistoryModelObj.getDosageAmount());
	    pstmt.setString(8, userMedicalHistoryModelObj.getDosageFrequency());
	    pstmt.setTime(9, userMedicalHistoryModelObj.getDosageBreakfastTime());
	    pstmt.setTime(10, userMedicalHistoryModelObj.getDosageLunchTime());
	    pstmt.setTime(11, userMedicalHistoryModelObj.getDosageDinnerTime());
	    pstmt.setInt(12, userMedicalHistoryModelObj.getEmailNotification());
		
	    int status = pstmt.executeUpdate();
		connect.close();
		if(status==1) {
			return true  ;
		}
		else {
			return false; 
		}
	}
	
	public boolean InsertDependentMedicalDataToDB(DependentMedicalHistoryModel dependentMedicalHistoryModelObj,String userEmail) throws SQLException {
		DataBaseConnection  dbObj= new DataBaseConnection() ;
		
	    Connection connect = dbObj.databaseConnection() ;
	    
	    int userId=getUserId(userEmail,connect);
	    
	    System.out.println(userId);
	    
	    int dependentId=getDependentId(userId,dependentMedicalHistoryModelObj.getDependentRelation(),
	    								dependentMedicalHistoryModelObj.getDependentName(),connect);
	    System.out.println(dependentId);
	    
	    
	    String query= "insert into dependent_medical_history (dependentId,dependentUser,dependentIlliness,dependentDoctorDetails,dependentMedicine,"
	    												+"dependentMedicineStartDate,dependentMedicineEndDate,dependentDosageAmount,dependentDosageFrequency,"
	    												+ "dependentDosageBreakfastTime,dependentDosageLunchTime,dependentDosageDinnerTime,emailNotification)"
	    												+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    PreparedStatement pstmt = connect.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
	    
	    
	    //set Statement
	    pstmt.setInt(1,dependentId);
	    pstmt.setInt(2,userId);
	    pstmt.setString(3, dependentMedicalHistoryModelObj.getIlliness());
	    pstmt.setString(4, dependentMedicalHistoryModelObj.getDoctorDetails());
	    pstmt.setString(5, dependentMedicalHistoryModelObj.getMedicine());
	    pstmt.setDate(6, dependentMedicalHistoryModelObj.getMedicineStartDate());
	    pstmt.setDate(7, dependentMedicalHistoryModelObj.getMedicineEndDate());
	    pstmt.setInt(8, dependentMedicalHistoryModelObj.getDosageAmount());
	    pstmt.setString(9, dependentMedicalHistoryModelObj.getDosageFrequency());
	    pstmt.setTime(10, dependentMedicalHistoryModelObj.getDosageBreakfastTime());
	    pstmt.setTime(11, dependentMedicalHistoryModelObj.getDosageLunchTime());
	    pstmt.setTime(12, dependentMedicalHistoryModelObj.getDosageDinnerTime());
	    pstmt.setInt(13, dependentMedicalHistoryModelObj.getEmailNotification());
		
	    int status = pstmt.executeUpdate();
		connect.close();
		if(status==1) {
			return true  ;
		}
		else {
			return false; 
		}
	}
	
	
	public boolean deleteMedicalHistoryDataEntryFromDB(int medicalHistoryId,int flag ) throws SQLException {
		DataBaseConnection  dbObj= new DataBaseConnection() ;
		
	    Connection connect = dbObj.databaseConnection() ;
	    String query="";
	    if(flag==1) {
	    	query ="DELETE from user_medical_history where userMedicalHistoryId=?";
	    }else {
	    	query ="DELETE from dependent_medical_history where dependentMedicalHistoryId=?";
	    }
	     
	    PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	    
	    pstmt.setInt(1, medicalHistoryId);
	    
	    int status = pstmt.executeUpdate();
		connect.close();
		if(status==1) {
			return true  ;
		}
		else {
			return false; 
		}
		
	}
	
	
	
	public boolean updateMedicalDataToDB(int medicalHistoryId,Date medicineStartDate,Date medicineEndDate,int dosageAmount,String dosageFrequency,
										Time doageBreakfastTime,Time doageLunchTime,Time doageDinnerTime,int flag) throws SQLException {
		DataBaseConnection  dbObj= new DataBaseConnection() ;
		
	    Connection connect = dbObj.databaseConnection() ;
	    String query="";
	     System.out.println("1");
	     
	    if(flag==1) { 
	     query= "UPDATE dependent_medical_history SET dependentMedicineStartDate=?,dependentMedicineEndDate=? ,dependentDosageAmount=?,dependentDosageFrequency=?"
	    		    + ",dependentDosageBreakfastTime=? ,dependentDosageLunchTime=?,dependentDosageDinnerTime=? where dependentMedicalHistoryId=?";
	    }else {
	    	query= "UPDATE user_medical_history SET userMedicineStartDate=?,userMedicineEndDate=? ,userDosageAmount=?,userDosageFrequency=?"
	    		    + ",userDosageBreakfastTime=? ,userDosageLunchTime=?,userDosageDinnerTime=? where userMedicalHistoryId=?";
		}
	    System.out.println("2");
	    PreparedStatement pstmt = connect.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
	    
	    System.out.println("3");
	    //set Statement
	    pstmt.setDate(1, medicineStartDate);
	    pstmt.setDate(2, medicineEndDate);
	    pstmt.setInt(3, dosageAmount);
	    pstmt.setString(4, dosageFrequency);
	    pstmt.setTime(5, doageBreakfastTime);
	    pstmt.setTime(6, doageLunchTime);
	    pstmt.setTime(7, doageDinnerTime);
	    pstmt.setInt(8,medicalHistoryId);
	    System.out.println("4");
	    int status = pstmt.executeUpdate();
	    System.out.println("5");
		connect.close();
		System.out.println(status);
		if(status==1) {
			return true  ;
		}
		else {
			return false; 
		}
	}
	
	
	public ArrayList<MedicalHistoryModel>  getMedicalHistoryDataFromDB(String userEmail,String dependentRelation,String dependentName) throws SQLException{
		
			DataBaseConnection  dbObj= new DataBaseConnection() ;
			
		    Connection connect = dbObj.databaseConnection() ;
		    
		    int userId=getUserId(userEmail,connect);
		    String query="" ;
		    PreparedStatement pstmt ;
		    System.out.println(userId);
		    if(dependentRelation!=null && dependentName!=null) {
		    	int dependentId=getDependentId(userId,dependentRelation,dependentName,connect);
		    	query="Select * from dependent_medical_history where dependentUser=? and dependentId=?";
		    	pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		    	pstmt.setInt(1,userId );
		    	pstmt.setInt(2, dependentId);
		    	
		    	ResultSet rs=pstmt.executeQuery();
 			   
			    ArrayList<MedicalHistoryModel> arrlist= new ArrayList<MedicalHistoryModel>();
			    
			    MedicalHistoryModel dataObj;
			
			
			
			while(rs.next()) {
		    	dataObj= new MedicalHistoryModel() ;
		    	
		    	dataObj.setMedicalHistoryId(rs.getInt("dependentMedicalHistoryId"));
		    	System.out.println(rs.getInt("dependentMedicalHistoryId"));
		    	dataObj.setIlliness(rs.getString("dependentIlliness"));
		    	dataObj.setDoctorDetails(rs.getString("dependentDoctorDetails"));
		    	dataObj.setMedicine(rs.getString("dependentMedicine"));
		    	dataObj.setMedicineStartDate(rs.getDate("dependentMedicineStartDate"));
		    	dataObj.setMedicineEndDate(rs.getDate("dependentMedicineEndDate"));
		    	dataObj.setDosageAmount(rs.getInt("dependentDosageAmount"));
		    	dataObj.setDosageFrequency(rs.getString("dependentDosageFrequency"));
		    	
		    	if(rs.getTime("dependentDosageBreakfastTime") != null)
		    		dataObj.setDosageBreakfastTime(rs.getTime("dependentDosageBreakfastTime"));
		    		
		    	if(rs.getTime("dependentDosageLunchTime") != null) {
		    		dataObj.setDosageLunchTime(rs.getTime("dependentDosageLunchTime"));
		    		System.out.println(dataObj);
		    	}
		    	if(rs.getTime("dependentDosageDinnerTime") != null)
		    		dataObj.setDosageDinnerTime(rs.getTime("dependentDosageDinnerTime"));
		    	
		    	dataObj.setEmailNotification(rs.getInt("emailNotification"));
		    	
		    	arrlist.add(dataObj) ;
		    	
		    	
		    	
		    }
			return arrlist;
		    
		    }
		    else {
		    	
		    			query="Select * from user_medical_history where userId_M=?";
		    			pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		    			pstmt.setInt(1, userId);
		    			
		    			 ResultSet rs=pstmt.executeQuery();
		    			   
		    			    ArrayList<MedicalHistoryModel> arrlist= new ArrayList<MedicalHistoryModel>();
		    			    
		    			    MedicalHistoryModel dataObj;
		    			
		    			
		    			
		    			while(rs.next()) {
		    		    	dataObj= new MedicalHistoryModel() ;
		    		    	
		    		    	dataObj.setMedicalHistoryId(rs.getInt("userMedicalHistoryId"));
		    		    	System.out.println(rs.getInt("userMedicalHistoryId"));
		    		    	dataObj.setIlliness(rs.getString("userIlliness"));
		    		    	dataObj.setDoctorDetails(rs.getString("userDoctorDetails"));
		    		    	dataObj.setMedicine(rs.getString("userMedicine"));
		    		    	dataObj.setMedicineStartDate(rs.getDate("userMedicineStartDate"));
		    		    	dataObj.setMedicineEndDate(rs.getDate("userMedicineEndDate"));
		    		    	dataObj.setDosageAmount(rs.getInt("userDosageAmount"));
		    		    	dataObj.setDosageFrequency(rs.getString("userDosageFrequency"));
		    		    	
		    		    	if(rs.getTime("userDosageBreakfastTime") != null)
		    		    		dataObj.setDosageBreakfastTime(rs.getTime("userDosageBreakfastTime"));
		    		    		
		    		    	if(rs.getTime("userDosageLunchTime") != null) {
		    		    		dataObj.setDosageLunchTime(rs.getTime("userDosageLunchTime"));
		    		    		System.out.println(dataObj);
		    		    	}
		    		    	if(rs.getTime("userDosageDinnerTime") != null)
		    		    		dataObj.setDosageDinnerTime(rs.getTime("userDosageDinnerTime"));
		    		    	
		    		    	dataObj.setEmailNotification(rs.getInt("emailNotification"));
		    		    	
		    		    	arrlist.add(dataObj) ;
		    		    	
		    		    	
		    		    	
		    		    }
		    			return arrlist;
		    }
		    
		    
		   
		    
		    
		    
		    
		    
		
		
		
		
	}

}
