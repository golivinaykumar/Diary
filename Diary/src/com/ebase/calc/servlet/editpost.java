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
import com.ebase.calc.manager.PostManager;
import com.ebase.pojo.Post;

/**
 * Servlet implementation class editpost
 */
@WebServlet("/editpost")
public class editpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Post editpost = new Post();
		PostManager editManager = new PostManager();
		editpost.setTitle(request.getParameter("title"));
		editpost.setDescription(request.getParameter("description"));
		editpost.setFeelings(request.getParameter("feelings"));
		editpost.setCountId(Integer.parseInt(request.getParameter("countid")));
		editManager.updatePostManager(editpost,(String) request.getSession().getAttribute("username"), Integer.parseInt(request.getParameter("countid")));
		DiaryManager listpost = new DiaryManager();
		  List<Post> diaryList =null;
		  diaryList =  listpost.fetchPost((String) request.getSession().getAttribute("username"));
		  request.setAttribute("diaryList", diaryList);
		  RequestDispatcher disp;
			disp = getServletContext().getRequestDispatcher("/home.jsp");
			disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
