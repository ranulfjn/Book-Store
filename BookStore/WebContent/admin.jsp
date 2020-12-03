<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page  import="com.isi.controller.*, java.sql.* ,com.isi.entity.*" %> 
    <%@ page  import="java.util.ArrayList " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="displayPage.css">
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
       <a href="#">Welcome back, <%=user.getUserName() %></a>
     </li>
     <li>
      <a href=index.html>Logout</a>
     </li>
  </ul>
  </nav>



<h1>All Orders Placed By Users</h1>
<table id="customers">
<tr><th>UserName</th><th>BookName</th><th>OrderID</th></tr>
<%
ArrayList<admin> list = (ArrayList<admin>)request.getAttribute("OrderList");
%>
<% if(list != null && list.size() > 0){ %>
<% for (admin s : list){ %>
<tr><td> <%=s.getUserName() %></td><td><%=s.getBookName() %></td></td><td><%= s.getOrderID() %></td></tr>
<%}} else{ %>
   <h2>No Orders found</h2>
<%} %>
</table>
</body>
</html>