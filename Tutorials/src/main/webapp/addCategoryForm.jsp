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
	<h1>CATEGORY - ADD NEW</h1>
	
	<h3><bean:write name="categoryForm" property="message" /></h3>
	
	<html:form action="categoryProcess.do">
		<div>ID</div>
		<div>
			<html:text property="id"/>
		</div>
		<div>Name</div>
		<div>
			<html:text property="name"/>
		</div>
		<div>Description</div>
		<div>
			<html:text property="description"/>
		</div>
		<div>
			<html:submit>SAVE</html:submit>
		</div>
	</html:form>
	
</body>
</html>