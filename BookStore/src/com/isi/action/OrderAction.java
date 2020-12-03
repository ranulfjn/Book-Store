package com.isi.action;

import java.util.ArrayList;

import com.isi.entity.Order;
import com.isi.entity.admin;
import com.isi.manager.OrderManager;

public class OrderAction {
	
	public static  ArrayList<admin>  getAllListOfOrder()
	{
		  return OrderManager.getAllBookOrders();
	}
	public static  void insertOrder(int  bookID,int userID,int quantity)
	{
		   OrderManager.addOrder(bookID,userID,quantity);
	}
	
	
	public static  ArrayList<admin>  getAllOrderSOfUser(String username)
	{
		  return OrderManager.getAllOrders(username);
	}
	
	
	
}
