<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>  
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>  
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>  
    
<h1>Top Employers</h1>

<div id="box-items">
 <logic:iterate id="item" name="jobs" >
     <bean:define id="hinhanh" name="item" property="image"/>
     <img src="./images/<%=hinhanh%>" width='100px' height="100px" />
 </logic:iterate>
</div>