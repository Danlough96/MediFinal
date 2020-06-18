package com.example.medical;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.*;

public class CryptWithMD5 {
	
	/*
	 * https://stackoverflow.com/questions/10696432/encryption-of-password-in-java-or-mysql
	 * "You cannot decrypt MD5, but you can compare outputs since if you put the same string 
	 * in this method it will return the same crypted output.If you want to decrypt you need 
	 * to use the SHA.You will never use decription for a users password.For that always use MD5.
	 * That exception is pretty redundant.It will never throw it.When you add the password to 
	 * the database, you add what this method returns.To login you compare them."
	 * 
	 * This is as is from the web page: Author Adrian Stamin dated 7 Jan 2013
	 */
	   private static MessageDigest md;

	   public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


	   }
	}
