package com.isi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.action.BooksAction;
import com.isi.entity.Books;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Map<Integer,Books> cartOfBooks = new HashMap<Integer,Books>();  
    public ShoppingCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = (String) request.getParameter("action");
		switch(action) {
		case "add":
			int id= Integer.parseInt(request.getParameter("id"));
			Books book = BooksAction.getBookById(id);
			cartOfBooks.put(id, book);
			session.setAttribute("cartSession",cartOfBooks);
			request.getRequestDispatcher("ShoopingCart.jsp").forward(request, response);
			break;
		case "remove":
			String idToRemove=request.getParameter("id");
			cartOfBooks.remove(Integer.parseInt(idToRemove));
			response.sendRedirect("BookController");
			break;
		case "cart":
			session.setAttribute("cartSession",cartOfBooks);
			request.getRequestDispatcher("ShoopingCart.jsp").forward(request, response);
			break;
		default:
			session.setAttribute("cartSession",cartOfBooks);
			request.getRequestDispatcher("ShoopingCart.jsp").forward(request, response);
			break;
		}
	}

}
