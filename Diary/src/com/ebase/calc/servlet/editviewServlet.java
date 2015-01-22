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
 * Servlet implementation class editviewServlet
 */
@WebServlet("/editviewServlet")
public class editviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostManager editDelete = new PostManager();
		String edit = request.getParameter("edit");
		String delete = null;
		try{
		delete = request.getParameter("delete");
		
		if(delete.equals(null)){
			System.out.println("null");
		}
		 if(delete.equals("delete")&& !delete.equals(null)){
			editDelete.deletePostManager(Integer.parseInt(request.getParameter("postdate")), (String)request.getSession().getAttribute("username"));
			DiaryManager listpost = new DiaryManager();
			  List<Post> diaryList =null;
			  diaryList =  listpost.fetchPost((String)request.getSession().getAttribute("username"));
			  request.setAttribute("diaryList", diaryList);
			  RequestDispatcher disp;
				disp = getServletContext().getRequestDispatcher("/home.jsp");
				disp.forward(request, response);
		}}catch(NullPointerException ex){
			delete=null;
		}
		try{
		 if(edit.equals("edit")){
			
			Post retrivedit = editDelete.retrivelManager(Integer.parseInt(request.getParameter("postdate")), (String)request.getSession().getAttribute("username"));
			request.setAttribute("title", retrivedit.getTitle());
			request.setAttribute("description", retrivedit.getDescription());
			request.setAttribute("feelings", retrivedit.getFeelings());
			request.setAttribute("posteddate", retrivedit.getPostedDate());
			request.setAttribute("countid", retrivedit.getCountId());
			RequestDispatcher disp;
			disp = getServletContext().getRequestDispatcher("/editpost.jsp");
			disp.forward(request, response);
			
		}}catch(NullPointerException ex){
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
