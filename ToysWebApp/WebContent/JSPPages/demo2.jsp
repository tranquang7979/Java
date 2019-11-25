<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="helloBean" class="beans.HelloBean"></jsp:useBean>

<jsp:setProperty property="*" name="helloBean"/>

Welcome <jsp:getProperty property="name" name="helloBean"/>! <br>
Message:  
<jsp:getProperty property="message" name="helloBean"/>

</body>
</html>