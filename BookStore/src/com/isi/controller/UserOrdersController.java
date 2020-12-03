package com.isi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.action.OrderAction;
import com.isi.entity.admin;

/**
 * Servlet implementation class UserOrdersController
 */
@WebServlet("/UserOrdersController")
public class UserOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username= request.getParameter("user");
		//PrintWriter ouWriter=response.getWriter();
		
		//ouWriter.println("User:"+username);
		ArrayList<admin> orderList =OrderAction.getAllOrderSOfUser(username);
		request.setAttribute("OrderList",orderList);
		request.getRequestDispatcher("orders.jsp").forward(request, response);
	}

}
