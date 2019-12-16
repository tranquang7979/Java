<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
      
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add Category</h1>

<form action="./demo6-select-category.jsp" method="post">
	<div>
		<label>Category Id</label>
		<div><input name="CategoryId" /></div>
	</div>
	<br>
	<div>
		<label>Category Name</label>
		<div><input name="CategoryName" /></div>
	</div>
	<br>
	<div>
		<label>Description</label>
		<div><input name="Description" /></div>
	</div>
	<br>
	<button type="submit">Save</button> &nbsp;&nbsp;&nbsp;
	<button type="update">Update</button>
</form>

</body>
</html>