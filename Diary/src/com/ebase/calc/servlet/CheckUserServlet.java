package com.ebase.calc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebase.calc.manager.PostManager;
import com.ebase.calc.manager.UserManager;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
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
		UserManager checkuser = new UserManager();
		String username=request.getParameter("username");
		
		boolean cond = checkuser.checkUser(username);
		
		if(cond){
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("message", "valid");
			
		}else{
			request.setAttribute("username", "username");
			request.setAttribute("message", "Not valid");
		}
		RequestDispatcher disp;
		disp = getServletContext().getRequestDispatcher("/signup.jsp");
		disp.forward(request, response);
	}

}
