package com.maverick.trainingproject.Repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
<<<<<<< HEAD
=======
import java.sql.PreparedStatement;
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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
		// TODO Auto-generated method stub
		
		try {
			DataBaseConnection dbObject= new DataBaseConnection() ;
			Connection connect = dbObject.databaseConnection() ;
			ArrayList<String> arr = new ArrayList<>();
			
			String query = "select i.userName, i.userEmail, i.userContact, p.userBloodGroup, i.userDateOfBirth, " 
					+ "p.userWeight, p.userHeight, p.userProfilePic, p.userId, p.userProfileId " 
					+ "from user_info i inner join user_profile p " 
					+ "on i.userId = p.userId where i.userEmail = '"+email+"'";
<<<<<<< HEAD
=======
			/*String query = "select i.userName, i.userEmail, i.userContact, p.userBloodGroup, i.userDateOfBirth, " 
					+ "p.userWeight, p.userHeight, p.userId, p.userProfileId " 
					+ "from user_info i inner join user_profile p " 
					+ "on i.userId = p.userId where i.userEmail = '"+email+"'";*/
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
			
			
			statement = connect.createStatement();
			
//			get user profile data
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
<<<<<<< HEAD
				Blob blob = rs.getBlob(8);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String text = new String(bdata);
				System.out.println(List.getUserProfilePic());
=======
				/*Blob blob = rs.getBlob(8);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				String text = new String(bdata);
				System.out.println(List.getUserProfilePic());*/
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
				
				List.setUserId(rs.getInt(9));
				List.setUserProfileId(rs.getInt(9));
				
				
				
//				get user dependent no of relations present in Database
<<<<<<< HEAD
				String query1 = "select distinct(dependentRelation) from user_dependent where userId = '"+List.getUserId()+"'";
				rs = statement.executeQuery(query1);
				if (rs.next()) {
					while (rs.next()) {
=======
				System.out.println(List.getUserId());
				String query1 = "select distinct(dependentRelation) from user_dependent where userId = '"+List.getUserId()+"'";
				rs = statement.executeQuery(query1);
				System.out.println(List.getUserId());
				//if (rs.next()) {
					while (rs.next()) {
						System.out.println(rs.getString("dependentRelation"));
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
						arr.add(rs.getString("dependentRelation")); 
												
					}
					List.setRelationsList(arr);
<<<<<<< HEAD
				}
=======
				/*}
				else {
					System.out.println("dsadsa");
				}*/
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
				
				return List;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}



	
	@Override
	public int setProfileData(String userName, String userEmail, String userContact, String userBloodGroup,
			Date date, float userWeight, float userHeight, Blob userProfilePic, int userId,
<<<<<<< HEAD
			int userProfileId) {
=======
			int userProfileId, String tokenEmail) {
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		// TODO Auto-generated method stub
		
		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
<<<<<<< HEAD
		int id = 0;
		String query = "select userId from user_info where userName = '"+userName+"' and userEmail = '"+userEmail+"'";
		String query1 = "select * from user_info where userId != '"+id+"' and userEmail = '"+userEmail+"'";
		String query2 = "update user_info as i, user_profile as p "
				+ "set i.userName = '"+userName+"', i.userContact = '"+userContact+"', i.userDateOfBirth = '"+date+"', "
				+ "p.userBloodGroup = '"+userBloodGroup+"', p.userWeight = '"+userWeight+"', p.userHeight = '"+userHeight+"', "
				+ "p.userProfilePic = '"+userProfilePic+"', i.userEmail = '"+userEmail+"' "
				+ "where i.userId = p.userId and i.userId = '"+id+"' ";
		try {
=======
		
		int id = 0;
		System.out.println(userName+""+userEmail);
		String query = "select userId from user_info where userEmail = '"+tokenEmail+"'";
		String query1 = "select * from user_info where userId != '"+id+"' and userEmail = '"+userEmail+"'";
		/*String query2 = "update user_info as i, user_profile as p "
				+ "set i.userName = '"+userName+"', i.userContact = '"+userContact+"', i.userDateOfBirth = '"+date+"', "
				+ "p.userBloodGroup = '"+userBloodGroup+"', p.userWeight = '"+userWeight+"', p.userHeight = '"+userHeight+"', "
				+ "p.userProfilePic = '"+userProfilePic+"', i.userEmail = '"+userEmail+"' "
				+ "where i.userId = p.userId and i.userId = '"+id+"' ";*/
		String query2 = "update user_info as i, user_profile as p "
				+ "set i.userName = ?, i.userContact = ?, i.userDateOfBirth = ?, "
				+ "p.userBloodGroup =? , p.userWeight = ?, p.userHeight = ?, "
				+ "i.userEmail = ?"
				+ "where i.userId = p.userId and i.userId =  ?";
		try {
			statement = connect.createStatement();
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
//				get userid
				rs = statement.executeQuery(query);
				if (rs.next()) {
					id = rs.getInt("userId");
<<<<<<< HEAD
					
//					check for other user having same email id
					rs = statement.executeQuery(query1);
=======
					System.out.println(id);
					
//					check for other user having same email id
					/*rs = statement.executeQuery(query1);
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
					boolean check = rs.next();
					if (check) {
						return 0;
					}
<<<<<<< HEAD
					else {
//						update Profile Data
						statement.executeUpdate(query2);
						return 1;
					}
		
				}
=======
					else {*/
//						update Profile Data
					PreparedStatement pstmt = connect.prepareStatement(query2,
		                    Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, userName);
					pstmt.setString(2, userContact);
					pstmt.setDate(3, date);
					pstmt.setString(4, userBloodGroup);
					pstmt.setFloat(5, userWeight);
					pstmt.setFloat(6, userHeight);
					pstmt.setString(7, userEmail);
					pstmt.setInt(8, id);
						int status = pstmt.executeUpdate();
						System.out.println(status+"sasad");
						if(status !=0) {
							return 1;
						}
						return 0;
					}
		
		//}
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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
		// TODO Auto-generated method stub
		UserProfileModel dependentProfileModel = new UserProfileModel();
		DataBaseConnection dbObject= new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		String query = "select i.userId, d.dependentEmail, d.dependentContact, "
				+ "d.dependentBloodGroup, d.dependentDateOfBirth, d.dependentWeight, d.dependentHeight "
				+ "from user_info as i inner join user_dependent as d on i.userId = d.userId "
				+ "where i.userEmail = '"+userEmail+"' and d.dependentRelation = '"+dependentRelation+"' and d.dependentName = '"+dependentName+"'";
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
<<<<<<< HEAD
=======
				dependentProfileModel.setDependentName(dependentName);
				dependentProfileModel.setDependentRelation(dependentRelation);
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
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

<<<<<<< HEAD


	@Override
	public int setDependentProfileData(UserProfileModel dependentProfileModel) {
		// TODO Auto-generated method stub
		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		int id = 0;
		String query = "select * from user_dependent as d, user_dependent as s "
				+ "where d.dependentId != s.dependentId and d.dependentEmail = '"+dependentProfileModel.getDependentEmail()+"' ";
=======
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
	    String query="select dependentId from user_dependents where dependentuserId='"+userId+"' and dependentRelation='"+dependentRelation+"'"
	    		     + "and dependentName='"+dependentName+"'";
	    
	    ResultSet rs= connect.createStatement().executeQuery(query);
	    if(rs.next()) {
			return rs.getInt("dependentId");
		}
		return 0 ;
	}

	@Override
	public int setDependentProfileData(UserProfileModel dependentProfileModel, String tokenEmail) {
		// TODO Auto-generated method stub
		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
	
		//String query = "select * from user_dependent as d, user_dependent as s "
			//	+ "where d.dependentId != s.dependentId and d.dependentEmail = '"+dependentProfileModel.getDependentEmail()+"' ";
		
		int id = 0;
		try {
			id = getUserId(tokenEmail, connect);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int dependentId = 0;
		//dependentId = getDependentId(id, dependentProfileModel.getDependentRelation(), dependentProfileModel.getDependentName(), connect)
		//################################################################################################//
		//																								  //
		//                                        WE STOPPED HERE										  //
		//																								  //
		//################################################################################################//
		
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		String query1 = "update user_dependent as d, user_info as i "
				+ "set d.dependentRelation = '"+dependentProfileModel.getDependentRelation()+"', "
				+ "d.dependentName = '"+dependentProfileModel.getDependentName()+"', d.dependentEmail = '"+dependentProfileModel.getDependentEmail()+"', "
				+ "d.dependentContact = '"+dependentProfileModel.getDependentContact()+"', d.dependentBloodGroup = '"+dependentProfileModel.getDependentBloodGroup()+"', "
				+ "d.dependentDateOfBirth = '"+dependentProfileModel.getDependentDateOfBirth()+"', d.dependentWeight = '"+dependentProfileModel.getDependentWeight()+"', "
				+ "d.dependentHeight = '"+dependentProfileModel.getDependentHeight()+"' "
				+ "where i.userId = d.userId and i.userEmail = '"+dependentProfileModel.getUserEmail()+"' "
				+ "and d.userId = '"+id+"' ";
<<<<<<< HEAD
		String query2 = "select userId from user_dependent where dependentEmail = '"+dependentProfileModel.getDependentEmail()+"'";
=======
		
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
		String query3 = "insert into user_dependent(userId, dependentName, dependentEmail, dependentRelation, "
				+ "dependentContact, dependentBloodGroup, dependentWeight, dependentHeight, dependentDateOfBirth) "
				+ "values('"+id+"', '"+dependentProfileModel.getDependentName()+"', '"+dependentProfileModel.getDependentEmail()+"', "
				+ "'"+dependentProfileModel.getDependentRelation()+"', '"+dependentProfileModel.getDependentContact()+"', "
				+ "'"+dependentProfileModel.getDependentBloodGroup()+"', '"+dependentProfileModel.getDependentWeight()+"', "
				+ "'"+dependentProfileModel.getDependentHeight()+"', '"+dependentProfileModel.getDependentDateOfBirth()+"')";
		
		try {
<<<<<<< HEAD
//			dependent email exist with another user or not
			rs = statement.executeQuery(query);
			if (rs.next()) {
				return 0;
			}
			else {
//				email Id exist with current user
				rs = statement.executeQuery(query2);
				if (rs.next()) {
					id = rs.getInt("userId");
//					update dependent data
					statement.executeUpdate(query1);
					return 1;
				}
				else {
//					insert dependent data
					statement.executeUpdate(query3);
					return 3;
				}

=======
			statement = connect.createStatement();
			int status = statement.executeUpdate(query1);
			if(status!=0) {
				return 1;
			}
			else {
				return 0;
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
<<<<<<< HEAD
		return 2;
	}


	

=======
		return 0;
	}
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
}
