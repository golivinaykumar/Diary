package com.ebase.calc.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebase.calc.manager.DiaryManager;
import com.ebase.calc.manager.UserManager;
import com.ebase.pojo.Post;
import com.ebase.pojo.User;
@Controller
public class UserController {
	
	@RequestMapping(value="/home")
	public ModelAndView login(@ModelAttribute() User userdetails,HttpServletRequest request){
		UserManager loginManager = new UserManager();
	
		if(loginManager.loginManager(userdetails.getUsername(), userdetails.getPassword())){
			
			User details=loginManager.getUserDetailsManager(userdetails.getUsername());
			request.getSession().setAttribute("username", userdetails.getUsername());
			request.getSession().setAttribute("firstName", details.getFirstName());
			request.getSession().setAttribute("lastName", details.getLastName());
			request.getSession().setAttribute("email", details.getEmail());
			DiaryManager listpost = new DiaryManager();
		
			List<Post> diaryList =null;
			  diaryList =  listpost.fetchPost(userdetails.getUsername());
			 
	
		ModelAndView index = new ModelAndView("signup");
		index.addObject("diaryList", diaryList);
		return index;
		
	}else{
		ModelAndView index = new ModelAndView("login");
		return index;
		
	}

	}
	}
