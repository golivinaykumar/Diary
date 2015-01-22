package com.ebase.calc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebase.calc.manager.DiaryManager;
import com.ebase.calc.manager.UserManager;
import com.ebase.pojo.Post;
import com.ebase.pojo.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginServlet")
public class login extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 5170127231933645990L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		UserManager loginManager  =new UserManager();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(loginManager.loginManager(username, password)){
			
			User details=loginManager.getUserDetailsManager(username);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("firstName", details.getFirstName());
			request.getSession().setAttribute("lastName", details.getLastName());
			request.getSession().setAttribute("email", details.getEmail());
			DiaryManager listpost = new DiaryManager();
			  List<Post> diaryList =null;
			  diaryList =  listpost.fetchPost(username);
			  request.setAttribute("diaryList", diaryList);
			  RequestDispatcher disp;
				disp = getServletContext().getRequestDispatcher("/home.jsp");
				disp.forward(request, response);
			
		}
	}

}
