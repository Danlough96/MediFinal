package com.example.medical;

public class UserRegister{
	/*
	
	 * user when registering user for first time, 
	 * to get user details or to update use User Class
	 * or for password change also use User class.
	 */
	
	/*	
	 * Don't let the user go mad and put in zero or 255 length strings.
	 * Add some extra checks on the front end!
	 * 	userName; //255 characters - Must be unique on the database (ideally needs another class to check - do that later)
	 *  userFirstName; //255 characters
	 *  userLastName; //255 characters
	 *  userEmail; //255 characters - Must be unique on the database (ideally needs another class to check - do that later)
	 *  userPhoneNo; //11 characters - Phone numbers aren't more than 11 characters
	 *  userPassword; //password should be encrypted with CryptWithMd5 by the method running this class
	 */
	

	public UserRegister(String userFirstName, String userLastName, String userEmail, String userPhoneNo, String userName, String userPassword) throws Exception { 
		//super(userName, userPassword);
		// add new user to database
		try {
		String str = "INSERT INTO tblusers (userName,userPassword, userFirstName, userLastName, userEmail, userPhoneNo, userDateJoined)" + 
				"VALUES ('" + userName  + "', '" + userPassword  + "', '" +  userFirstName + "', '" + userLastName  + "'," + 
				" '" + userEmail  + "', '" + userPhoneNo  + "', NOW() );";
		DBConnect.runUpdateQuery(str);
		}catch(Exception e) {
			throw e;
			//System.out.println(e.toString());
		}

	}

}
