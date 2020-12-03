package com.isi.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.isi.entity.Books;
import com.isi.entity.Order;
import com.isi.entity.admin;
import com.isi.service.DatabaseConnection;

public class OrderManager {
	
	public static void addOrder(int bookID, int userID,int quantity)
	{
		String query ="insert into orders(bookid,userid,quantity) values(?,?,?)";
		PreparedStatement ps = DatabaseConnection.getPreparedStatement(query);
		try {
			ps.setInt(1, bookID);
			ps.setInt(2, userID);
			ps.setInt(3, quantity);
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				

	}
		
	public static  ArrayList<admin> getAllBookOrders()
	{
		String getAllBookOrders="select userlogin.username,books.bookname,orders.orderid from  orders join books on orders.bookid=books.bookid join userlogin on userlogin.userid=orders.userid";
		ArrayList<admin> listOfOrders = new ArrayList<admin>();
		try
		{
			
			Statement statement =DatabaseConnection.getStatementObject();
			ResultSet rs=statement.executeQuery(getAllBookOrders);
			
			
				while(rs.next()) {
					admin orders = new admin(
							rs.getString("username"),
							rs.getString("bookname"),
							rs.getInt("orderid")
							);
					listOfOrders.add(orders);
						
				}
			
			return listOfOrders;
			
		}
		
	 catch (SQLException e){
		e.printStackTrace();
	 }
		return listOfOrders;
	}
	
	public static  ArrayList<admin> getAllOrders(String username)
	{
		String getAllBookOrders="select userLogin.username, books.bookname,orders.orderid from  orders join books on orders.bookid=books.bookid join userlogin on userlogin.userid=orders.userid where userLogin.username=?";
		ArrayList<admin> listOfOrders = new ArrayList<admin>();
		try
		{
			
			PreparedStatement ps = DatabaseConnection.getPreparedStatement(getAllBookOrders);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			
			
				while(rs.next()) {
					admin orders = new admin(
							rs.getString("username"),
							rs.getString("bookname"),
							rs.getInt("orderid")
							);
					listOfOrders.add(orders);
						
				}
			
			return listOfOrders;
			
		}
		
	 catch (SQLException e){
		e.printStackTrace();
	 }
		return listOfOrders;
	}
	
	
	
	
}
