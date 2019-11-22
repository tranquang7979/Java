<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.html" %>
<%!
	String name = "ABC";
	int a = 1;
	int b = 5;
%>
<div>result a + b = <%= a + b%></div>

	<h1>Test JPS</h1>
	<h1>Tiếng Việt nha</h1>
	<%
		for(int i = 0; i < 10; i++)
		{
			out.print("Hello <br/>");
		}
	%>
	
	<div>
		<% Date current = new Date(); %>
		Today is <b><%= current.toString() %></b>
	</div>

</body>
</html>