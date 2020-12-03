package com.isi.entity;

public class admin {
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private String userName;
	private String bookName;
	private int orderID;
	//private int quantity;
	
	
	public admin(String userName, String bookName, int orderID) {
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.orderID = orderID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookID(String bookName) {
		this.bookName = bookName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	/*public int getQuantity() {
		return quantity;
	}*/


}
