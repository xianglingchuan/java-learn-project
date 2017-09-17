package com.myspringmvc.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String username = request.getParameter("username");
		 request.setCharacterEncoding("UTF-8");
		 //System.out.println("******username*****:"+new String(username.getBytes("ISO-8859-1"),"UTF-8"));
			
		 
		 String password = request.getParameter("password");
		 System.out.println("username:"+username+",password:"+password);
		 if(username.equals("admin") && password.equals("admin")){
			 HttpSession session = request.getSession();
			 session.setAttribute("username", username);
			 response.sendRedirect(request.getContextPath()+"/filter/loginSuccess.jsp"); 			 
		 }else{
			 response.sendRedirect(request.getContextPath()+"/filter/loginFail.jsp"); 
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
