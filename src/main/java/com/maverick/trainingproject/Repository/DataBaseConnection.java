package com.maverick.trainingproject.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	public Connection databaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
			
//			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=root&password=26091998");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=akki&password=akki");
=======
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=root&password=qwert12");
>>>>>>> cff86cabed5a6066cf6f9767f57845481a6f3c6c
			
			return connect ;
			
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
			return null ;
		}
	}

}
