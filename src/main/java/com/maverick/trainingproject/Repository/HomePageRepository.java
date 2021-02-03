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
				+ "INNER JOIN user_profile p on i.userId =p.userId where i.userId=?";
				     
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
		return userObj;
	}
	
	
	public ArrayList<HomePageModel> getPillInfoFromDB(String userEmail) throws SQLException {
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
	}


	public boolean setPillStatusInDB(Map<String, Integer> pillObj) throws SQLException {
		DataBaseConnection dbObj = new DataBaseConnection();
		Connection connect = dbObj.databaseConnection();
		
		String query = "update pill_reminder_card set checkbox = ? where pillTableId = ?";
				     
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, pillObj.get("checkbox").intValue());
		pstmt.setInt(2, pillObj.get("pillTableId").intValue());
		int status = pstmt.executeUpdate();
		if(status == 1) {
			return true;
		}
		
		return false;
	}
}
