package com.maverick.trainingproject.Repository;

import java.io.IOException;
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
import com.maverick.trainingproject.Model.userImageModel;


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
					+ "from user_info i LEFT JOIN user_profile p " 
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
			Date userDateOfBirth, float userWeight, float userHeight,
			int userProfileId, String tokenEmail) throws SQLException {
	

		DataBaseConnection dbObject = new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		System.out.println(userName+" "+userEmail);
		int userId = new MedicalHistoryRepository().getUserId(userEmail, connect);
		
		String query1 = "update user_info as i, user_profile as p "
				+ "set i.userName = ?, i.userContact = ?, i.userDateOfBirth = ?, "
				+ "p.userBloodGroup =? , p.userWeight = ?, p.userHeight = ?, "
				+ "i.userEmail = ?"
				+ "where i.userId = p.userId and i.userId =  ?";
		try {
			if(userId != 0) {
				String query = "select * from user_profile where userId = ?";
				statement = connect.createStatement();
				PreparedStatement pstmt2 = connect.prepareStatement(query,
	                    Statement.RETURN_GENERATED_KEYS);
				pstmt2.setInt(1, userId);
				rs = pstmt2.executeQuery();
				if(rs.next())
				{
//					update Profile Data
					PreparedStatement pstmt = connect.prepareStatement(query1,
		                    Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, userName);
					pstmt.setString(2, userContact);
					pstmt.setDate(3, userDateOfBirth);
					pstmt.setString(4, userBloodGroup);
					pstmt.setFloat(5, userWeight);
					pstmt.setFloat(6, userHeight);
					pstmt.setString(7, userEmail);
					pstmt.setInt(8, userId);
					int status = pstmt.executeUpdate();
					System.out.println(status+"sasad");
					if(status != 0) {
						return 1;
					}
					else {
						return 0;
					}
				}
				else {
					String query3 = "insert into user_profile (userId, userBloodGroup, userWeight, userHeight)"
							        +"values (?,?,?,?)";
					PreparedStatement pstmt3 = connect.prepareStatement(query3,
		                    Statement.RETURN_GENERATED_KEYS);
					pstmt3.setInt(1, userId);
					pstmt3.setString(2,userBloodGroup);
					pstmt3.setFloat(3,userWeight);
					pstmt3.setFloat(4,userHeight);
					
					int status = pstmt3.executeUpdate();
					
					String query4 = "update user_info set userName ='"+userName+"' ,userContact ='"+userContact+"' ,"
							        +"userDateOfBirth ='"+userDateOfBirth+"' ,userEmail ='"+userEmail+"' where userId ='"+userId+"'";
					pstmt3 = connect.prepareStatement(query3,
		                    Statement.RETURN_GENERATED_KEYS);
					pstmt3.setString(1, userName);
					pstmt3.setString(2, userContact);
					pstmt3.setDate(3, userDateOfBirth);
					pstmt3.setString(4, userEmail);
					pstmt3.setInt(5, userId);
					
					int status2 = pstmt3.executeUpdate();
					
					if(status !=0 && status2 !=0) {
						return 1;
					}
					else {
						return 0;
					}
					
					
				}
	
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
				//System.out.println("dsdasdasdssad");
				return dependentProfileModel;
			
			}
			else {
				System.out.println("dsdasdasdssad");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dependentProfileModel;
		
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




	public boolean setPicToDB(userImageModel obj, String tokenEmail) throws SQLException {
		// TODO Auto-generated method stub
		DataBaseConnection dbObject= new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		
		int userId = new MedicalHistoryRepository().getUserId(tokenEmail, connect);
		System.out.println("userId from photo to db"+userId);
		
		/*String query = "select userProfilePic from user_profile where userId = ?";
		PreparedStatement pstmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1,userId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {*/
			
			String query2 = "update user_profile set userProfilePic=? where userId = ?";
			PreparedStatement pstmt2 = connect.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
			pstmt2.setBlob(1, obj.getImage());
			pstmt2.setInt(2,userId);
			
			int status2 = pstmt2.executeUpdate();
			System.out.println("update####"+status2);
			if(status2!=0) {
				return true  ;
			}
			else {
				return false; 
			}
			
		/*}
		else {
			String query2 = "insert into user_image values (?,?)";
			PreparedStatement pstmt2 = connect.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
			pstmt2.setBlob(1, obj.getImage());
			pstmt2.setInt(2,userId);
			
			int status2 = pstmt2.executeUpdate();
			System.out.println("insert####");
			if(status2==1) {
				return true  ;
			}
			else {
				return false; 
			}
			
		}*/
		
		
		
		
	}




	public Blob getImageFromDB(String tokenEmail) throws SQLException, IOException {
		
		DataBaseConnection dbObject= new DataBaseConnection() ;
		Connection connect = dbObject.databaseConnection() ;
		int userId = new MedicalHistoryRepository().getUserId(tokenEmail, connect);
		System.out.println("userId from db to frontend"+userId);
			
		String query2 = "select userProfilePic from user_profile where userId=?";
		PreparedStatement pstmt = connect.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		Blob blob = null;
		if(rs.next()) {
			if(rs.getBlob("userProfilePic") == null) {
				System.out.println("dsad");
			}
			blob = rs.getBlob("userProfilePic");
			/*File image = new File("C:\\Users\\anup\\Desktop\\aaa.png");
		      FileOutputStream fos = new FileOutputStream(image);
		      //byte[] buffer = new byte[1];
		      byte byteArray[] = blob.getBytes(1,(int)blob.length());
		      FileOutputStream outPutStream = new FileOutputStream(image);
		      outPutStream.write(byteArray);
		      outPutStream.close();*/
		      
		      System.out.println("dasds");
		      return rs.getBlob("userProfilePic");
			
		}
		else {
			System.out.println("dasdsqqqqqqq");
		}
		return null;
		
		
	}
}
