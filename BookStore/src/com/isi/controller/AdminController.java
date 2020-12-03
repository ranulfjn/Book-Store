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
import com.isi.entity.Order;
import com.isi.entity.admin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter outPrintWriter = response.getWriter();
		
		ArrayList<admin> orderList = OrderAction.getAllListOfOrder();
		/*for (admin s : orderList){ 
			
			outPrintWriter.println("BID:"+s.getBookID());
			outPrintWriter.println("OID:"+s.getOrderID());
			outPrintWriter.println("UID:"+s.getUserID());
			
		}*/
		
		request.setAttribute("OrderList",orderList);
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	

}
