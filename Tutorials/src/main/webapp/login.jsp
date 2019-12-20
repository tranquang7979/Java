<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	
	<html:form action="loginProcess.do">
		<div>UserName</div>
		<div>
			<html:text property="userName"/>
		</div>
		<div>Password</div>
		<div>
			<html:password property="password"/>
		</div>
		<div>
			<html:submit>Login</html:submit>
		</div>
	</html:form>
	
</body>
</html>