package com.maverick.trainingproject.Repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
//<<<<<<< HEAD
//=======
import java.sql.PreparedStatement;
//>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.maverick.trainingproject.Model.UserDependentProfileModel;
import com.maverick.trainingproject.Model.UserProfileModel;


public class ProfileRepositoryImplementation implements ProfileRepository {

	private Statement statement = null;
    private ResultSet rs = null;
    
	
	
	@Override
	public UserProfileModel getUserProfileData(String email) {
		
		try {
			DataBaseConnection dbObject= new DataBaseConnection() ;
			Connection connect = dbObject.databaseConnection() ;
			ArrayList<String> arr = new ArrayList<>();
			
			String query = "select i.userName, i.userEmail, i.userContact, p.userBloodGroup, i.userDateOfBirth, " 
					+ "p.userWeight, p.userHeight, p.userProfilePic, p.userId, p.userProfileId " 
					+ "from user_info i inner join user_profile p " 
					+ "on i.userId = p.userId where i.userEmail = '"+email+"' ";

//			get user profile data
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			if(rs.next()) {
				UserProfileModel List = new UserProfileModel();
				System.out.println(rs.getString(1));
				List.setUserName(rs.getString(1));
				List.setUserEmail(rs.getString(2));
				List.setUserContact(rs.getString(3));
				List.setUserBloodGroup(rs.getString(4));
				List.setUserDateOfBirth(rs.getDate(5));
				System.out.println(List.getUserDateOfBirth());
				List.setUserWeight(rs.getFloat(6));
				System.out.println(List.getUserWeight());
				List.setUserHeight(rs.getFloat(7));
//
//				Model class me value dalna baki h
//				List.setUserProfilePic(rs.getBlob(8));

//				Blob blob = rs.getBlob(8);
//				byte[] bdata = blob.getBytes(1, (int) blob.length());
//				String text = new String(bdata);
//				System.out.println(List.getUserProfilePic());

				
				List.setUserId(rs.getInt(9));
				List.setUserProfileId(rs.getInt(9));
				
				
				
//				get user dependent no of relations present in Database
				System.out.println(List.getUserId());
				String query1 = "select distinct(dependentRelation) from user_dependents where userId = '"+List.getUserId()+"'";
				statement = connect.createStatement();
				rs = statement.executeQuery(query1);
				while (rs.next()) {
						System.out.println(rs.getString("dependentRelation"));
						arr.add(rs.getString("dependentRelation")); 
												
				}
				List.setRelationsList(arr);
				
				return List;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public int setProfileData(String userName, String userEmail, String userContact, String userBloodGroup,
			Date userDateOfBirth, float userWeight, float userHeight, Blob userProfilePic, int userId,
			int userProfileId, String tokenEmail) {
	

		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		int id = 0;
		System.out.println(userName+" "+userEmail);
		String query = "select userId from user_info where userEmail = '"+tokenEmail+"'";
		String query1 = "select * from user_info where userId != '"+id+"' and userEmail = '"+userEmail+"'";	
		String query2 = "update user_info as i, user_profile as p "
				+ "set i.userName = ?, i.userContact = ?, i.userDateOfBirth = ?, "
				+ "p.userBloodGroup =? , p.userWeight = ?, p.userHeight = ?, "
				+ "i.userEmail = ?"
				+ "where i.userId = p.userId and i.userId =  ?";
		try {
			
//				get userid
				statement = connect.createStatement();
				rs = statement.executeQuery(query);
				if (rs.next()) {
					id = rs.getInt("userId");
					System.out.println(id);
					
//					update Profile Data
					PreparedStatement pstmt = connect.prepareStatement(query2,
		                    Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, userName);
					pstmt.setString(2, userContact);
					pstmt.setDate(3, userDateOfBirth);
					pstmt.setString(4, userBloodGroup);
					pstmt.setFloat(5, userWeight);
					pstmt.setFloat(6, userHeight);
					pstmt.setString(7, userEmail);
					pstmt.setInt(8, id);
					int status = pstmt.executeUpdate();
					System.out.println(status+"sasad");
					if(status != 0) {
						return 1;
					}
					return 0;
				}
				else {
					return 2;
				}
		
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return 3;
	}


	@Override
	public UserProfileModel getDependentProfileData(String userEmail, String dependentRelation, String dependentName) {
		
		UserProfileModel dependentProfileModel = new UserProfileModel();
		DataBaseConnection dbObject= new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		String query = "select i.userId, d.dependentEmail, d.dependentContact, "
				+ "d.dependentBloodGroup, d.dependentDateOfBirth, d.dependentWeight, d.dependentHeight "
				+ "from user_info as i inner join user_dependents as d on i.userId = d.userId "
				+ "where i.userEmail = '"+userEmail+"' and d.dependentRelation = '"+dependentRelation+"' and d.dependentName = '"+dependentName+"'";
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				dependentProfileModel.setDependentName(dependentName);
				dependentProfileModel.setDependentRelation(dependentRelation);
				dependentProfileModel.setDependentEmail(rs.getString(2));
				dependentProfileModel.setDependentContact(rs.getString(3));
				dependentProfileModel.setDependentBloodGroup(rs.getString(4));
				dependentProfileModel.setDependentDateOfBirth(rs.getDate(5));
				dependentProfileModel.setDependentWeight(rs.getFloat(6));
				dependentProfileModel.setDependentHeight(rs.getFloat(7));
				
				return dependentProfileModel;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}


	public int getUserId(String userEmail, Connection connect) throws SQLException {
		
		 
	    String query="select userId from user_info where userEmail='"+userEmail+"'";
	    
	    ResultSet rs = connect.createStatement().executeQuery(query);
		if(rs.next()) {
			return rs.getInt("userId");
		}
		return 0 ;
	}
	
	public int getDependentId(int userId, String dependentEmail, Connection connect) throws SQLException {
		
		 
		 System.out.println(dependentEmail);
	    String query="select dependentId from user_dependents where userId='"+userId+"' "
	    		     + "and dependentEmail = '"+dependentEmail+"' ";
	    
	    ResultSet rs= connect.createStatement().executeQuery(query);
	    if(rs.next()) {
			return rs.getInt("dependentId");
		}
		return 0 ;
	}

	@Override
	public int setDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail) {
		
		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
	
		int id = 0;
		try {
//			get user Id
			id = getUserId(tokenEmail, connect);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int dependentId = 0;
		try {
//			get Dependent Id
			dependentId = getDependentId(id, dependentProfileModel.getOldDependentEmail() ,connect);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		String query1 = "update user_dependents as d "
				+ "set d.dependentRelation = '"+dependentProfileModel.getDependentRelation()+"', d.dependentName = '"+dependentProfileModel.getDependentName()+"', "
				+ "d.dependentEmail = '"+dependentProfileModel.getDependentEmail()+"', d.dependentContact = '"+dependentProfileModel.getDependentContact()+"', "
				+ "d.dependentBloodGroup = '"+dependentProfileModel.getDependentBloodGroup()+"', d.dependentDateOfBirth = '"+dependentProfileModel.getDependentDateOfBirth()+"', "
				+ "d.dependentWeight = '"+dependentProfileModel.getDependentWeight()+"', d.dependentHeight = '"+dependentProfileModel.getDependentHeight()+"' "
				+ "where d.dependentId = '"+dependentId+"' ";
		try {
//			update the dependent data
			statement = connect.createStatement();
			int status = statement.executeUpdate(query1);
			if(status != 0) {
				return 1;
			}
			else {
				return 0;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 2;
	}



	@Override
	public int addDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail) {
		
		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		
		int id = 0;
		try {
//			get user Id
			id = getUserId(tokenEmail, connect);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	

		String query = "insert into user_dependents(userId, dependentName, dependentEmail, dependentRelation, "
				+ "dependentContact, dependentBloodGroup, dependentWeight, dependentHeight, dependentDateOfBirth) "
				+ "values('"+id+"', '"+dependentProfileModel.getDependentName()+"', '"+dependentProfileModel.getDependentEmail()+"', "
				+ "'"+dependentProfileModel.getDependentRelation()+"', '"+dependentProfileModel.getDependentContact()+"', "
				+ "'"+dependentProfileModel.getDependentBloodGroup()+"', '"+dependentProfileModel.getDependentWeight()+"', "
				+ "'"+dependentProfileModel.getDependentHeight()+"', '"+dependentProfileModel.getDependentDateOfBirth()+"')";
//	insert new dependent data
		try {
			statement = connect.createStatement();
			int status = statement.executeUpdate(query);
			if (status != 0) {
				return 1;
			}
			else {
				return 2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}







	
}
