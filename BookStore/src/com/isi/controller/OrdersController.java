package com.isi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.action.OrderAction;
import com.isi.entity.Books;
import com.isi.entity.Users;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/OrdersController")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("userSession");
		int userID =user.getUserID();
		HashMap<Integer,Books> bookSession = (HashMap<Integer,Books>)session.getAttribute("cartSession") ;
		Iterator start = bookSession.entrySet().iterator();
		while (start.hasNext()) {
			Map.Entry mapElement = (Map.Entry)start.next();
			Books book = (Books)mapElement.getValue();
			int bookid = book.getBookID();
			OrderAction.insertOrder(bookid,userID,1);
		}
		PrintWriter out = response.getWriter();
		out.println("<html>"
					+ "<body>"
					+"<h2>Order Succesfully Placed</h2>"
					+"<a href='BookController'>Go to Home</a>"
					+"</body>"
					+ "</html>");
	}

}
