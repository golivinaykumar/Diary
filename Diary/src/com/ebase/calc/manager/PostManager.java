package com.ebase.calc.manager;

import java.text.SimpleDateFormat;
import java.sql.Date;

import com.ebase.calc.dao.PostDAO;
import com.ebase.pojo.Post;

public class PostManager {
	PostDAO postDAOManager = null;
	Post postPOJOManager  = null;
	ValidationPostManager validatePost = null;
	public boolean insertDiaryManager(Post insertDiary,String username){
		validatePost = new ValidationPostManager();
		postDAOManager = new PostDAO();
		insertDiary.setPostedDate(validatePost.addDate());
		if(validatePost.checkIsEmpty(insertDiary) && !username.isEmpty()){
			return postDAOManager.insertDiaryDao(insertDiary, username);
		}
		return false;
	}
	public boolean updatePostManager(Post updatePost,String username,int countid){
		validatePost = new ValidationPostManager();
		postDAOManager = new PostDAO();
		if(validatePost.checkIsEmpty(updatePost) && !username.isEmpty()){
			return postDAOManager.updatePost(updatePost, username,countid);
		}
		return false;
		
		
	}
	public boolean deletePostManager(int countId,String username){
		
		postDAOManager = new PostDAO();
		if(countId != 0 && !username.isEmpty()){
			return postDAOManager.deletePost(countId, username);
		}
		return false;
	}
	public Post retrivelManager(int countid,String username){
	
		PostDAO retrivelDao = new PostDAO();
		return retrivelDao.retrievalPost(countid, username);
		
	}
	
}
