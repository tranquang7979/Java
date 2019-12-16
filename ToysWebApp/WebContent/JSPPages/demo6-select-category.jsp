<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
      
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table {
  border-collapse: collapse;
}

table, th, td {
  border: 1px solid black;
  padding:5px;
}
table tr>td:nth-child(1){text-align:center;}
</style>
</head>
<body>

<sql:setDataSource var="ds" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
			url="jdbc:sqlserver://localhost;databaseName=GlobalToyz" user="sa" password="1"/>
			


<c:set var="id" value="${param.CategoryId}"></c:set>
<c:set var="name" value="${param.CategoryName}"></c:set>
<c:set var="desc" value="${param.Description}"></c:set>

<%-- <sql:update var="result" dataSource="${ds}"> --%>
<!-- 	insert Category values (?,?,?) -->
<%-- 	<sql:param value="${id}"/> --%>
<%-- 	<sql:param value="${name}"/> --%>
<%-- 	<sql:param value="${desc}"/> --%>
<%-- </sql:update> --%>

<sql:update var="result" dataSource="${ds}">
	update Category set cCategory=?,vDescription=? where cCategoryId=?
	<sql:param value="${name}"/>
	<sql:param value="${desc}"/>
	<sql:param value="${id}"/>
</sql:update>

			
			
<sql:query var="result" dataSource="${ds}">
	select * from Category
</sql:query>

<table>
	<thead>
		<tr>
			<th>CategoryId</th>
			<th>CategoryName</th>
			<th>Description</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="item" items="${result.rows}">
			<tr>
				<td >${item.cCategoryId}</td>
				<td>${item.cCategory}</td>
				<td>${item.vDescription}</td>
			</tr>	
		</c:forEach>
	</tbody>
</table>

</body>
</html>