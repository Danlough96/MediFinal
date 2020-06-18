package com.example.medical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**

 * This is the connection to the database and methods to pass relevant SQL statements 
 * for SELECT, UPDATE, CREATE AND DELETE
 *
 */
public class DBConnect {

	public static Connection getDBConn() throws Exception {
		/*This contains the data needed to connect to the database
		* It may contain details of more than one database for testing
		* but only have one uncommented
		* In the production version of this we should be using a web service
		* but this will be ok for testing
		* */
		try {
			/*String driver = "org.mariadb.jdbc.Driver"; //driver - this is mariadb NOT MYSQL
			String url= "jdbc:mariadb://ubuntulamp:3306/testdb";  //path to mysql server and database
			String username = "jv";  //mysql user
			String password = "mypass";  //mysql password
			Class.forName(driver);
			*/
	
			final String driver = "com.mysql.jdbc.Driver"; //driver - this mySQL NOT mariadb
			final String url= "jdbc:mysql://remotemysql.com:3306/53WNcTU5Dt?useSSL=false";  //path to mysql server and database
			final String username = "53WNcTU5Dt";  //mysql user
			final String password = "Xa50GzrhGs";  //mysql password
			Class.forName(driver);
	
			
			Connection conn = DriverManager.getConnection(url, username,password);
			//System.out.println("Connected");
			return conn;
		}catch(Exception e) {
			//System.out.println(e);
			//return null;
			throw e;
		}
		
		
	}
	
	static ResultSet runSelectQuery(String query) throws Exception {
		//returns a recordset from a SELECT query
        try {
            Connection dbconn = DBConnect.getDBConn();
            if(dbconn != null) {
                Statement st = dbconn.createStatement();
                ResultSet rs = st.executeQuery(query);
                return rs;
                //st.close();
                //rs.close();
                //dbconn.close();
            }else{
                return null;
            }
            
        }catch (SQLException ex) {
        	//System.out.println(ex.toString());
        	//return null;
        	throw ex;
        	}
        catch(Exception e) {
           	//System.out.println(e.toString());
        	//return null;
        	throw e;
        	}
		
	}
	
	static boolean runUpdateQuery(String query) throws Exception{
		//which may be an INSERT, UPDATE, or DELETE 
        try {
            Connection dbconn = DBConnect.getDBConn();
            if(dbconn != null) {
                Statement st = dbconn.createStatement();
                int rs = st.executeUpdate(query);
                //Returns:either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
                if (rs >=0 ) {
                	return true;
                }else {
                	return false;
                }
            }else{
                return false;
            }
            
        }catch (SQLException ex) {
        	//System.out.println(ex.toString());
        	//return false;
        	throw ex;
        	}
        catch(Exception e) {
           	//System.out.println(e.toString());
        	//return false;
        	throw e;
        	}
	}
	
	static String getStringValue(String query, String columnName) throws Exception{
		//return one string (which could be an integer etc as string)
		//you will need to know the database column name
		//clue: the variable names are often the same as the column names
        try {
            Connection dbconn = DBConnect.getDBConn();
            String s = "";
            //there should only be one row with one value returned
            if(dbconn != null) {
                Statement st = dbconn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String retString = rs.getString(columnName);
                    // print the results
                    s = String.format("%s", retString);
                }
                st.close();
                rs.close();
                dbconn.close();
            }else{
                s="cannot connect to db";
            }
            return s;
        }catch (SQLException ex) {
        	throw ex;
        	//return ex.toString();
        }catch(Exception e) {
        	throw e;
        	//return "\n\n\n" + e.toString();
        	}
	}

		
}
