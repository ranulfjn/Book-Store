package com.isi.entity;

public class Books {
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private int bookID;
	private String bookName;
	private String bookCategory;
	private int bookQuantity;
	
	public Books(int bookID, String bookName, String bookCategory, int bookQuantity) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.bookQuantity = bookQuantity;
	
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
}
