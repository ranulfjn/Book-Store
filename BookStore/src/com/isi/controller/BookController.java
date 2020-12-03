package com.isi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.action.BooksAction;
import com.isi.entity.Books;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Books> booksList=null;
		String category =request.getParameter("category");
		String action =request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		
		
		if(category==null || action!=null)
		{
			booksList = BooksAction.getAllBooks();
			request.setAttribute("Booklist",booksList);
			request.getRequestDispatcher("display.jsp").forward(request, response);
			
				
		}
		else
		{
			
			booksList = BooksAction.getAllByCategory(category);
			request.setAttribute("Booklist",booksList);
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}
	}
}	


