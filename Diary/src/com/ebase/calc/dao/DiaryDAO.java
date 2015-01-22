package com.ebase.calc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ebase.pojo.Post;



public class DiaryDAO {
	
	
	ConnectionDAO cd = new ConnectionDAO();
	Connection con =cd.ConnectionD();
	public List<Post> retrivelPost(String username){
		List<Post> retrivelList = new ArrayList<Post>();
	
		String query = "select * from post where username = '"+username+"' ORDER BY presentdate DESC";
		Statement retrivelPostst=null;
		try {
			retrivelPostst = con.createStatement();
			ResultSet retrivelPostRs = retrivelPostst.executeQuery(query);
			while(retrivelPostRs.next()){
				Post retrivelObj = new Post();
				retrivelObj.setTitle(retrivelPostRs.getString("title"));
				retrivelObj.setDescription(retrivelPostRs.getString("description"));
				retrivelObj.setFeelings(retrivelPostRs.getString("feelings"));
				retrivelObj.setPostedDate(retrivelPostRs.getTimestamp("presentdate"));
				retrivelObj.setCountId(retrivelPostRs.getInt("autocountid"));
				retrivelList.add(retrivelObj);
				
			}
			return retrivelList;
		} catch (SQLException e) {
			return retrivelList;
		}
		
		
	}

}
