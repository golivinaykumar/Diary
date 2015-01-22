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
 * Servlet implementation class AddDiary
 */
@WebServlet("/AddDiary")
public class DiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String desc = request.getParameter("aboutDiary");
		String ope = request.getParameter("feeling");
		Post insertPost = new Post();
		insertPost.setTitle(title);
		insertPost.setDescription(desc);
		insertPost.setFeelings(ope);
		PostManager postmgr = new PostManager();
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		
			request.setAttribute("message", postmgr.insertDiaryManager(insertPost,username  ));
		
		
		request.getSession().setAttribute("username", username);
		DiaryManager listpost = new DiaryManager();
		  List<Post> diaryList =null;
		  diaryList =  listpost.fetchPost(username);
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
