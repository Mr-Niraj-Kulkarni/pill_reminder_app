package com.maverick.trainingproject.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	public Connection databaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=root&password=26091998");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=akki&password=akki");
			
			return connect ;
			
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
			return null ;
		}
	}

}
