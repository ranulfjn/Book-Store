package com.isi.action;

import java.util.ArrayList;

import com.isi.entity.Books;
import com.isi.manager.BookManager;

public class BooksAction {
	
	
	public static  Books getBookById(int id)
	{
		return BookManager.getBookById(id);
		
	}
	public static ArrayList<Books>getAllBooks()
	{
		return BookManager.getAllBooks();
	}
	
	public static  ArrayList<Books>getAllByCategory(String category)
	{
		return BookManager.getBooksByCategory(category);
		
	}
}
