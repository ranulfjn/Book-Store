package com.isi.entity;

import java.util.ArrayList;

public class ShoppingCart {
	
	
	private  ArrayList<Books> books;

	public ShoppingCart(ArrayList<Books> books) {
		super();
		this.books = books;
	}
	
	public ArrayList<Books> getBooks() {
		return books;
	}

	public  void setBooks(ArrayList<Books> books) {
		this.books = books;
	}

	
	public  ArrayList<Books> addBook(Books book) {
		books.add(book);
		return books;		
	}

}
