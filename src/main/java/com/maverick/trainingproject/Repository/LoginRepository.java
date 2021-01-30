package com.maverick.trainingproject.Repository;

import java.sql.*;



import com.maverick.trainingproject.Model.UserLoginModel;

import com.maverick.trainingproject.Model.UserRegistrationInformationModel;


public class LoginRepository{
	
    private Statement statement = null;
    private ResultSet rs = null;
    

	
	public boolean userLoginCredentialCheckInDB(UserLoginModel login) {
		try {
			DataBaseConnection dbObject= new DataBaseConnection() ;
			Connection connect=dbObject.databaseConnection() ;
			
			statement = connect.createStatement();
<<<<<<< HEAD
			rs = statement.executeQuery("select userID from user_info where email ='"+login.getUserEmail()+"' and password = '"+login.getUserPassword()+"'");
            if(rs.next()) {
            
=======
			rs = statement.executeQuery("select userID from user_info where userEmail ='"+login.getUserEmail()+"' and userPassword = '"+login.getUserPassword()+"'");
            if(rs.next()) {
            	login.setUserId(rs.getInt("userId"));
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
            return true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public int UpdatePasswordInDB(String userEmail,String userNewPassword ,String secretQuestion,String secretAnswer) throws SQLException {
		DataBaseConnection dbObject= new DataBaseConnection() ;
		
		Connection connect=dbObject.databaseConnection() ;
		
		// check user is a valid user using user Email
		String query = "select userId,userPassword from user_info where userEmail ='"+userEmail+"' and secreteQuestion='"+secretQuestion+"' and secreteAnswer='"+secretAnswer+"' ";
		statement = connect.createStatement();
		rs = statement.executeQuery(query);
		boolean isValidUser = rs.next();
		
		if(isValidUser) {
			int userId= rs.getInt("userId");
			String userOldPassword= rs.getString("userPassword");
			
			if(userOldPassword.equals(userNewPassword)) {
				return 2  ;
			}
			else {
				String query1 = "update user_info set userPassword = '"+ userNewPassword +"' where userId = '"+ userId +"'";
				statement = connect.createStatement();
				statement.executeUpdate(query1);
				return 1 ;
			}
		}
		else {
			return 0 ;
		}
		
		
		
	}
	
	public boolean insertUserInformationToDB(UserRegistrationInformationModel userObj) {
		DataBaseConnection dbObject= new DataBaseConnection() ;
		try {
			Connection connect=dbObject.databaseConnection() ;
			String insertUserDataQuery= "insert into user_info(userName,userEmail,userContact,userPassword,userCountry,userDateOfBirth,secreteQuestion,secreteAnswer) values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = connect.prepareStatement(insertUserDataQuery,
                    Statement.RETURN_GENERATED_KEYS);
			
			//set Parameters for Statement 
			pstmt.setString(1, userObj.getUserName());
			pstmt.setString(2, userObj.getUserEmail());
			pstmt.setString(3, userObj.getUserContact());
			pstmt.setString(4, userObj.getUserPassword());
			pstmt.setString(5, userObj.getUserCountry());
			pstmt.setDate(6, userObj.getUserDateofBirth());
			pstmt.setString(7, userObj.getSecretQuestion());
			pstmt.setString(8, userObj.getSecretAnswer());
			
			
			int status = pstmt.executeUpdate();
			
			if(status==1) {
				return true  ;
			}
			else {
				return false; 
			}
		}catch(Exception e) {
			System.out.println("Error"+e );
			return false  ;
		}
		
	}
	
<<<<<<< HEAD
=======
	public String getsecretpassword(UserLoginModel login) {
		try {
			DataBaseConnection dbObject= new DataBaseConnection() ;
			Connection connect=dbObject.databaseConnection() ;
			
			statement = connect.createStatement();
			rs = statement.executeQuery("select secreteAnswer from user_info where userEmail ='"+login.getUserEmail()+"'");
            if(rs.next()) {
            	return rs.getString("secreteAnswer");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "false";
	}
	
	public boolean checkTokenEmailValid(String userEmail) {
		try {
			DataBaseConnection dbObject= new DataBaseConnection() ;
			Connection connect=dbObject.databaseConnection() ;
			
			statement = connect.createStatement();
			rs = statement.executeQuery("select userId from user_info where userEmail ='"+userEmail+"'");
            if(rs.next()) {
            	return true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c

}
