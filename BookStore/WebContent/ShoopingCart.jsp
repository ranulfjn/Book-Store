<%@page import="com.isi.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.isi.*, java.util.ArrayList" %>
    <%@ page import="java.util.Map,java.util.HashMap,java.util.ArrayList,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="displayPage.css">
<title>Cart</title>
</head>
<body>
<header><h1>Welcome to The DownTown Book Store</h1></header>
<nav>
  <ul>
    <li>
        <a  href="BookController">Home</a>
     </li>
      <li>
      <a href="OrdersController">Proceed to check out</a>
     </li>
     <li>
      <a href=index.html>Logout</a>
     </li>
  </ul>
  </nav>

<h3>Your Cart</h3>
<% HashMap<Integer,Books> BookList = (HashMap<Integer,Books>)session.getAttribute("cartSession") ; 
Iterator start = BookList.entrySet().iterator(); %>
<table id="customers">
<tr><th>Book Name</th><th>Category</th><th>Action</th></tr>	
<%while (start.hasNext()) {  
			 Map.Entry mapElement = (Map.Entry)start.next(); 
			 Books book = (Books)mapElement.getValue(); %>
<tr><td><%=book.getBookName() %></td><td><%=book.getBookCategory() %></td><td><a class ="clr" href="ShoppingCartController?action=remove&id=<%=book.getBookID() %>">Remove</a></td></tr>			
		
<%} %></table><br>




</body>
</html>