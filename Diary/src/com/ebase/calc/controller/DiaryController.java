package com.ebase.calc.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ebase.calc.manager.DiaryManager;
import com.ebase.calc.manager.PostManager;
import com.ebase.pojo.Post;

@Controller
public class DiaryController  {
	@RequestMapping("/default")
	public ModelAndView PassListPost(){
		ModelAndView index = new ModelAndView("login");
		return index;
		
	}
}
