<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>  
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>  
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Jobs by Skill</h1>

<ul>
   
   <logic:iterate id="sk" name="skills">
        <li><a href="#"><bean:write name="sk" /></a></li>
   </logic:iterate>
</ul>
</body>
</html>