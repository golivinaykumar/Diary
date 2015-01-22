package com.ebase.calc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class ConnectionDAO {
	Connection conn = null;
	public Connection ConnectionD(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	try {
	    conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diary" , "vinay","vinay1");
	   
	   

	  
	} catch (SQLException ex) {
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
	
	return conn;
	
	}
	public void ConnectionClose(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

	
