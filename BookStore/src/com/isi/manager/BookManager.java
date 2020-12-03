package com.isi.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.isi.entity.Books;
import com.isi.service.DatabaseConnection;

public class BookManager {
	
	public static Books getBookById(int id)
	{
		 Books book=null;
		
		try {
			 String getBookById = "select * from  books where bookid =?";
			PreparedStatement ps = DatabaseConnection.getPreparedStatement(getBookById);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				  book = new Books(
						  	rs.getInt("bookid"),
							rs.getString("bookname"),
							rs.getString("bookcategory"),
							rs.getInt("bookquantity"));				
				 return book;
				 }			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return book;
}

	public static ArrayList<Books> getAllBooks()
	{
		ArrayList<Books> listofBooks = new ArrayList<Books>();
		try
		{
			 String getAllBooks="select * from  books"; 
			 
			Statement statement =DatabaseConnection.getStatementObject();
			
			ResultSet rs=statement.executeQuery(getAllBooks);
			
			while(rs.next()) {
				Books book = new Books(
							rs.getInt("bookid"),
							rs.getString("bookname"),
							rs.getString("bookcategory"),
							rs.getInt("bookquantity"));
				
				listofBooks.add(book);
			}
			return listofBooks;
			
		}
		
	 catch (SQLException e){
		e.printStackTrace();
	}
		return listofBooks;
	}
	
	

	
	public static ArrayList<Books> getBooksByCategory(String category)
	{
		 String  query="select * from books where bookcategory=?";
			ArrayList<Books> listofBooks = new ArrayList<Books>();
			try
			{
				PreparedStatement ps = DatabaseConnection.getPreparedStatement(query);
				ps.setString(1,category);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Books farm = new Books(
							rs.getInt("bookid"),
							rs.getString("bookname"),
							rs.getString("bookcategory"),
							rs.getInt("bookquantity"));
					
					listofBooks.add(farm);
				}
				return listofBooks;
				
			}
			
		 catch (SQLException e){
			e.printStackTrace();
		}
			return listofBooks;
	}
}
