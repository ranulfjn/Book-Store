package com.isi.entity;

public class Order {
	
	public Order () {
		super();
		
	}
	private int orderID;
	private int bookID;
	private int quantity;
	private int userID;
	
	public Order(int orderID, int bookID, int quantity, int userID) {
		this.orderID = orderID;
		this.bookID = bookID;
		this.quantity = quantity;
		this.userID = userID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

}
