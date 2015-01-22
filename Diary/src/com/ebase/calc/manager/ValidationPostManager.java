package com.ebase.calc.manager;

import java.util.Calendar;
import java.sql.Date;
import java.sql.Timestamp;

import com.ebase.pojo.Post;

public class ValidationPostManager {
	public boolean checkIsEmpty(Post insertDiary){
		if(!insertDiary.getTitle().isEmpty() && !insertDiary.getDescription().isEmpty() && !insertDiary.getFeelings().isEmpty()){
		return true;	
		}
		return false;
	}
	public Timestamp addDate(){
		Timestamp timeNow = new Timestamp(System.currentTimeMillis());
		
		return timeNow;
		
	}
}
