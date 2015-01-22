package com.ebase.calc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebase.pojo.User;

public class UserDAO {
	
	ConnectionDAO cd = new ConnectionDAO();
	Connection con =cd.ConnectionD();
	public boolean signUp(User signupDetails){
		
		
		ConnectionDAO cd = new ConnectionDAO();
		Connection con =cd.ConnectionD();
		User signupInsert = signupDetails;
		System.out.println(signupInsert.getUsername());
		
		try {
			String query = "insert into USER (username,password,firstName,lastName,email) "+"values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, signupInsert.getUsername());
			ps.setString(2, signupInsert.getPassword());
			ps.setString(3, signupInsert.getFirstName());
			ps.setString(4, signupInsert.getLastName());
			ps.setString(5, signupInsert.getEmail());
			
			
			ps.execute();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		
		
	}
	
	public boolean login(String username,String password){
		Statement login = null;
	
		 try {
			 String query = "select * from user where username='"+username+"'";
		        login = con.createStatement();
		        ResultSet rs = login.executeQuery(query);
		        
		        if(rs != null&& rs.next()){
		       if(password.equals(rs.getString("password"))){
		    	   return true;
		    	   
		       }
		       else{
		    	   System.out.println("dao");
		    	   return false;
		       }
		        }else{
		        	return false;
		        }
		        
		    } catch (SQLException e ) {
		    	System.out.println(e);
		    	return false;
		    } 
		
	}
	public boolean checkUser(String username){
		Statement checkuser = null;
		 try {
			 	String query = "select * from user where lower(username)=lower('"+username+"')";
			 	checkuser = con.createStatement();
		        ResultSet checkUserResultSet = checkuser.executeQuery(query);
		        int checkUserResultSetSize= 0;
		        if (checkUserResultSet != null)   
		        {  
		        	checkUserResultSet.beforeFirst();  
		        	checkUserResultSet.last();  
		        	checkUserResultSetSize = checkUserResultSet.getRow();  
		        } 
		        if(checkUserResultSetSize == 0){
		        	return true;
		        }
		        else{
		        	return false;
		        }
		      
		    } catch (SQLException e ) {
		    	System.out.println(e);
		    	return false;
		    } 
	}
	public User getUserDetails(String username){
		User getUserPOJO = null;
		Statement getuser = null;
		 try {
			 	String query = "select * from user where username='"+username+"'";
			 	getuser = con.createStatement();
		        ResultSet getUserResultSet = getuser.executeQuery(query);
		        	getUserPOJO = new User();
		        	if(getUserResultSet.next()){
		        	getUserPOJO.setUsername(getUserResultSet.getString("username"));
		        	getUserPOJO.setFirstName(getUserResultSet.getString("firstName"));
		        	getUserPOJO.setEmail(getUserResultSet.getString("email"));
		        	getUserPOJO.setLastName(getUserResultSet.getString("lastName"));
		        	}
		        	
		        	
		        	
		        return getUserPOJO;
		        
		       
		      
		    } catch (SQLException e ) {
		    	return getUserPOJO;
		    } 
		
	}
	public boolean updateUser(User updateDetails){
		 PreparedStatement updateUserPreparedSt = null;
		 String updateQuery = "update`user` set 'firstName'='"+updateDetails.getFirstName()+"','lastName' = '"+updateDetails.getLastName()+"','email' = '"+updateDetails.getEmail()+"'  where 'username' = '"+updateDetails.getUsername()+"'";
		 try {
			updateUserPreparedSt = con.prepareStatement(updateQuery);
			 updateUserPreparedSt.executeUpdate();
			 return true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
	public boolean changePassword(String username,String oldPassword,String newPassword){
		Statement changePassword = null;
		PreparedStatement updateUserPasswordPreparedSt;
		 try {
			 	String query = "select "+username+"from user";
			 	changePassword = con.createStatement();
		        ResultSet checkUserResultSet = changePassword.executeQuery(query);
		        if(oldPassword.equals(checkUserResultSet.getString("password"))){
		        	 String updateQueryPassword = "update`user` set 'password'='"+newPassword+"'  where 'username' = '"+username+"'";
		    		 try {
		    			 updateUserPasswordPreparedSt = con.prepareStatement(updateQueryPassword);
		    			 updateUserPasswordPreparedSt.executeUpdate();
		    			 return true; 
		    		} catch (SQLException e) {
		    			
		    			return false;
		    		}
		        	
		        	
		        }
		        else{
		        	return false;
		        }
		       
		      
		    } catch (SQLException e ) {
		    	return false;
		    } 
		
	}
	
	}


