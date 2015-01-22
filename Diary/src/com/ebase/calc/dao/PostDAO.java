package com.ebase.calc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.ebase.pojo.Post;

public class PostDAO {
	static ConnectionDAO cd = new ConnectionDAO();
	static Connection con =cd.ConnectionD();

	
	public  boolean insertDiaryDao(Post insertDiary,String username){
		PreparedStatement ps = null;
		try {
			String query = "insert into post (username,title, description ,feelings, presentdate) "+"values (?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, insertDiary.getTitle());
			ps.setString(3, insertDiary.getDescription());
			ps.setString(4, insertDiary.getFeelings());
			ps.setTimestamp(5,  insertDiary.getPostedDate());
			
			
			
			ps.execute();
			
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
		
		public boolean updatePost(Post updatePost,String username, int countid){
			 PreparedStatement updatePostPreparedSt = null;
			 String updateQuery = "update post set title= ? ,description = ? ,feelings = ?  where autocountid = '"+countid+"' and  username = '"+username+"'";
			 try {
				updatePostPreparedSt = con.prepareStatement(updateQuery);
				updatePostPreparedSt.setString(1, updatePost.getTitle());
				updatePostPreparedSt.setString(2, updatePost.getDescription());
				updatePostPreparedSt.setString(3, updatePost.getFeelings());
				 updatePostPreparedSt.executeUpdate();
				 return true; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				return false;
			}
			
		}
		public Post retrievalPost(int countid,String username){
			Post retrivelObj = new Post();
			String query = "select * from post where username = '"+username+"' ORDER BY presentdate DESC";
			Statement retrivelPostst=null;
			try {
				retrivelPostst = con.createStatement();
				ResultSet retrivelPostRs = retrivelPostst.executeQuery(query);
				while(retrivelPostRs.next()){
					
					retrivelObj.setTitle(retrivelPostRs.getString("title"));
					retrivelObj.setDescription(retrivelPostRs.getString("description"));
					retrivelObj.setFeelings(retrivelPostRs.getString("feelings"));
					retrivelObj.setPostedDate(retrivelPostRs.getTimestamp("presentdate"));
					retrivelObj.setCountId(retrivelPostRs.getInt("autocountid"));
					
					
				}
				return retrivelObj;
			} catch (SQLException e) {
				return retrivelObj;
			}
			
			
			
		}
		
		public boolean deletePost(int countId,String username){
			PreparedStatement deletePostPreparedSt = null;
			 String deleteQuery = "DELETE FROM post WHERE autocountid  = '"+countId+"' and username ='"+username+"'";
			 try {
				deletePostPreparedSt = con.prepareStatement(deleteQuery);
				deletePostPreparedSt.executeUpdate();
				 return true; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		
		
		
	
}
