<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type='text/css' href="./css/style.css" />
</head>
<body>


<div id="header">
	<tiles:insert attribute="header" />
</div>
<div id="main">
	 <tiles:insert attribute="main" />
</div>

<div id="footer">

	<tiles:insert attribute="footer" />  

</div>


</body>
</html>