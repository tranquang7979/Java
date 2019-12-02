<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>OUT</h2>
	<%
		out.println("Hello");
	%>
	<br>
	<c:out value="Hello" />



	
	<h2>IF</h2>
	<%
		int x = 5;
		if(x % 2 == 0)
			out.println("So chan");
		else
			out.println("So le");
	%>	
	<br>
	<c:if test="${3 > 2 && 3 > 1}">
		<c:out value="3>2 && 3>1 -> YES" />
	</c:if>
	<br>
	<c:if test="${3 gt 2}">
		<c:out value="3>2 -> YES" />
	</c:if>
	
	
	
	
	<h2>SET</h2>	
	<c:set var="bienX" value="6"></c:set>
	<c:set var="Y" value="6"></c:set>	
	<c:if test="${bienX * Y == 36}">
		<c:out value="${bienX} * ${Y} = 36 -> YES" />
	</c:if>
	
	
	
	<h2>CHOOSE - WHEN - OTHERWISE (switch-case)</h2>
	<c:set var="bienY" value="6"></c:set>
	<c:choose>
		<c:when test="${bienY == 0}">CN</c:when>
		<c:when test="${bienY == 1}"><span>T2</span></c:when>
		<c:when test="${bienY == 2}">T3</c:when>
		<c:when test="${bienY == 6}">T6</c:when>
		<c:otherwise>UNKNOWN</c:otherwise>		
	</c:choose>
	
	
	
	<h2>FOREACH</h2>
	<c:forEach var="i" begin="0" end="9" step="1">
		<c:out value="${i}" />
	</c:forEach>
	<br>
	<%
		String[] items = {"a", "b", "c"};
		for(String s : items){
			out.print(s);
		}
	%>
	<br>
	<c:forEach var="s" items='{"a", "b", "c"}' step="1">
		<c:out value="${s}" />
	</c:forEach>
</body>
</html>