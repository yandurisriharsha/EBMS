<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>    
<%@page import="java.util.List"  %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>EBMS</title>
<style>
.form-group
{
width:350px;
}
.container
{
font:white;
}
</style>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Electrical Bill Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="empolyee.html">Home</a></li>
      <li><a href="#">About us</a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
				<li><a href="EmpLogoutServlet"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
  </div>
 </nav>
  <div class="container">
  <h2>Bill</h2>
  <form action="BillServlet" method="get">
  <div class="left">
   <!--  <div class="form-group">
      <label for="bid">Bill Id:</label>
      <input type="text" class="form-control" name="bid">
    </div> -->
   <div class="form-group">
      <label for="date">Date:</label>
      <% DateFormat df = new SimpleDateFormat("yy/MM/dd");%>
	<% String formattedDate = df.format(new Date());%>	
      
      <input type="text" class="form-control"  name="date"  value="<%=formattedDate %>" />
    </div> 
    
    <div class="form-group">
      <label for="csid">Customer Service id:</label>
      <input type="text" class="form-control" placeholder="Enter Customer service id" name="csid" required/>
    </div>
    
    <div class="form-group">
      <label for="units">Units:</label>
      <input type="number" class="form-control" placeholder="Enter units" name="units" required/>
    </div>
    <!-- <div class="form-group">
      <label for="totbill">Total Bill:</label>
      <input type="text" class="form-control"  name="totbill" required/>
    </div> -->
 
    <button type="submit" class="btn btn-default">Save</button>
    
     
</body>
</html>
 <%-- <% 
  List<Integer> viewrecords=(List<Integer>) application.getAttribute("sid");
   for(Integer id : viewrecords)
   
   {  
   %>
	   
    <div class="form-group">
      <label for="csid">Customer Service id:</label>
      <select><option  class="form-control" name="csid" value="<%=id %>"></option>
        <%} %>
      </select>
    </div> --%>