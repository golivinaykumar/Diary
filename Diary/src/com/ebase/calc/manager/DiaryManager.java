package com.ebase.calc.manager;
import com.ebase.pojo.*;

import java.util.List;

import com.ebase.calc.dao.DiaryDAO;

public class DiaryManager {
	DiaryDAO diaryDAOManager = null;

	
	public List<Post> fetchPost(String username){
		diaryDAOManager = new DiaryDAO();
		List<Post> list = null;
		if(!username.isEmpty()){
		return diaryDAOManager.retrivelPost(username);
		} 
		return list;
	}
}
