<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import="com.isi.controller.*, java.sql.* ,com.isi.entity.*" %> 
    <%@ page  import="java.util.ArrayList " %>
    <%ResultSet resultset =null;%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to DownTown Book store</title>
<link rel="stylesheet" href="displayPage.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<% Users user = (Users)session.getAttribute("userSession");  %>

<header><h1>Welcome to The DownTown Book Store</h1></header>

	<nav>
  <ul>
    <li>
        <a href="#">Home</a>
     </li>
     <li>
       <a href="BookController?action=listAll">List all Books</a>
     </li>
     <li>
       <a href="#">Welcome back, <%=user.getUserName() %></a>
     </li>
      <li>
      <a href="ShoppingCartController?action=cart">Go to Cart</a>
     </li>
      <li>
      <a href="UserOrdersController?user=<%=user.getUserName() %>">Orders</a>
     </li>
      <li>
      <a href=index.html>Logout</a>
     </li>
  </ul>
  </nav>

<form action="BookController" method="get">
<br>
<fieldset>
<legend>Get Books by Category</legend>
<select name="category" class="form-control" >
<option value="Mystery Thriller">Mystery Thriller</option>
<option value="Novel">Novel</option>
<option value="fantasy">Fantasy</option>
<option value="Fiction">Fiction</option>
<option value="Drama">Drama</option>
</select>
<input type="submit"  value="Search">
</fieldset>
</form>

<table id="customers">
<tr><th>Book Name</th><th>Category</th><th>Action</th></tr>
<%
ArrayList<Books> list = (ArrayList<Books>) request.getAttribute("Booklist");
%>
<% if(list != null && list.size() > 0){ %>
<% for (Books s : list){ %>
<tr><td> <%=s.getBookName() %></td><td><%= s.getBookCategory() %></td><td>   <a class="clr" href="ShoppingCartController?action=add&id=<%= s.getBookID() %>">Add to Cart</a></td></tr>
<%} } else { %>
   <h2>No Data found for this request</h2>
<%} %>
</table>

</body>
</html>