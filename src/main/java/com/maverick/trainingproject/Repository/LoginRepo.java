package com.maverick.trainingproject.Repository;

import java.sql.*;

import org.springframework.stereotype.Controller;

import com.maverick.trainingproject.Model.UserRegistrationInformation;
import com.maverick.trainingproject.Model.loginModel;

@Controller
public class LoginRepo{
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    

	
	public boolean logincheck(loginModel login) {
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("select userID from user_info where email ='"+login.getEmail()+"' and password = '"+login.getPassword()+"'");
            if(rs.next()) {
            
            return true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public boolean getEmailCheck(String useremail, String secretAns) {
		// TODO Auto-generated method stub
		try {
			String query = "select * from email where email ='"+useremail+"' and secreateAnswer = '"+ secretAns +"'";
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			boolean ans = rs.next();
			return ans;
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
		
	}

	public int getUserId(String useremail, String secretAns) {
		// TODO Auto-generated method stub
		try {
			String query = "select userId from email where email ='"+useremail+"' and secreateAnswer = '"+ secretAns +"'";
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			int userId = 0;
			while(rs.next()){
				userId = rs.getInt("userId");
				System.out.println("your user id is : " +userId);
				break;
			}
			return userId;
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public void updateChange(int id, String password) {
		// TODO Auto-generated method stub
		try {
			String query = "update email set password = '"+ password +"' where userId = '"+ id +"'";
			statement = connect.createStatement();
			statement.executeUpdate(query);
			System.out.println("DB updated successfully");			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	

	public boolean checkOldPass(int id, String passWord) {
		// TODO Auto-generated method stub
		
		try {
			String query = "select * from email where userId ='"+id+"' and password = '"+ passWord +"'";
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			boolean ans = rs.next();
			return ans;
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	public boolean insertUserInformationToDB(UserRegistrationInformation userObj) {
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
	

}
