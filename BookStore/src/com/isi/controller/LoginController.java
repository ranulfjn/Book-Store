package com.isi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.isi.action.LoginAction;
import com.isi.entity.Users;





/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =  request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if(email!=null && password!=null)
		{
			PrintWriter out = response.getWriter();
			Users user = LoginAction.validateUser(email, password);
			//String admin=user.getLevel();
			//out.println("ThisExpression IsindexAction "+admin);
			if(user==null) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}else {
				
				if(user.getLevel()==null) {
					session.setAttribute("userSession",user);
					request.getRequestDispatcher("BookController").forward(request, response);
					
				}else
				{
					session.setAttribute("userSession",user);
					request.getRequestDispatcher("AdminController").forward(request, response);
					
					//response.sendRedirect("BookController");
				}
				
			}
			
				
				
		}
	}
}
