<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="Model.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap-3.1.1-dist/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap-3.1.1-dist/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>

<link href="css/style.css" rel="stylesheet">
</head>
<body>
	
	<div class="wrapper">
		
		<div class="header">
			<div class="menu">
				<img src="https://itviec.com/assets/logo-itviec-65afac80e92140efa459545bc1c042ff4275f8f197535f147ed7614c2000ab0f.png" width="108" height="42"/>
				<ul>
					<li><a href="#">All Jobs</a></li>
					<li><a href="#">IT Companies</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Sign In</a></li>
					<li><a href="#">Employers</a></li>
					<li><a href="#">All Jobs</a></li>
				</ul>
			</div>
			
			<div class="criterias">
				<h1>1,146 IT Jobs For Chất Developers</h1>
				
				<div class="form-search">
					<div class="form-group">
					    <input type="text" id="text-search" class="form-control" placeholder="Keyword skill (Java, iOS...), Job Title, Company...">
					</div>
					
					<div class="dropdown">
					  <select>
							<c:forEach var="item" items="${requestScope.cities}">					
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					
					<button type="button" id="btn-search" class="btn btn-danger">Search</button>
				</div>
				
				<ul class="skill-list">
					<c:forEach var="item" items="${requestScope.skills}">
						<li><a href="#${item.id}">${item.name}</a></li>
					</c:forEach>				
				</ul>
			</div>
			
		</div>
		
		<div class="body">
			<div class="job-list">
			
				<c:forEach var="item" items="${requestScope.companies}">
					<a href="#${item.id}">
						<div><img src="https://cdn.itviec.com/employers/home-credit-vietnam/logo/w170/dFAsZ8oiQpLPyUr8Yi5jUWdj/home-credit-vietnam-ppf-logo.png"/></div>
						<h1>${item.name}</h1>
						<h3>${item.name}</h3>
					</a>
				</c:forEach>	
				
			</div>
		</div>
		
	</div>	
		
</body>
</html>