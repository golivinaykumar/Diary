package com.ebase.calc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebase.calc.manager.UserManager;
import com.ebase.pojo.User;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 7826880362333249785L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User signup = new User();
		signup.setUsername(request.getParameter("username"));
		signup.setPassword(request.getParameter("password1"));
		signup.setEmail(request.getParameter("email"));
		signup.setFirstName(request.getParameter("firstname"));
		signup.setLastName(request.getParameter("lastname"));
		UserManager signupmgr =new UserManager();
		System.out.println(signupmgr.signUp(signup));
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/login.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

}
