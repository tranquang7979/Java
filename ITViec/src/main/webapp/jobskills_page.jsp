<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<tiles:insert definition="layout" page="/layout.jsp"  >
 
 
 <tiles:put name="main" value="/index.jsp"/>

 
</tiles:insert>
</body>
</html>