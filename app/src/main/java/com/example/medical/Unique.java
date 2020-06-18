package com.example.medical;

import java.sql.ResultSet;

public class Unique {
	/*
	 * Jeff Vincent
	 * Methods to check that that chosen UserName and Email
	 * are unique before submitting create/update to database
	 * for it to then bounce
	 * false = OK, you can use the chosen userName or Email
	 * true = The user Name or Email already exists, get them to choose again
	 */

	public static boolean userName(String userName) throws Exception {
		
		String str = "SELECT userName FROM tblusers WHERE userName = '" + userName + "';";
		try {
			ResultSet rs = DBConnect.runSelectQuery(str);
			//rs.last();
			if(rs.last()) {
				return true;
				//the userName is already in use
			}else {
				return false;
				//the userName is NOT being used
			}

		}catch(Exception e) {
			//there was an error connecting to the database
			//return false;
			throw e;
		}
		
	}
	
	public static boolean userEmail(String userEmail) throws Exception {
		
		String str = "SELECT userEmail FROM tblusers WHERE userEmail = '" + userEmail + "';";
		try {
			ResultSet rs = DBConnect.runSelectQuery(str);
			//rs.last();
			if(rs.last()) {
				return true;
				//the userEmail is already in use
			}else {
				return false;
				//the userEmail is NOT being used
			}
			
		}catch(Exception e) {
			//there was an error connecting to the database
			//return false;
			throw e;
		}
	}
	
}
