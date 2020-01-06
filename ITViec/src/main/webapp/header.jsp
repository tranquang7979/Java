<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<ul id="nav">
	<li><html:link href=""><bean:message key="mnu_all_jobs" /></html:link></li>
	<li><html:link href=""><bean:message key="mnu_itcompanies" /></html:link></li>
	<li><html:link href=""><bean:message key="mnu_blog" /></html:link></li>
	<li><html:link href=""><bean:message key="mnu_signin" /></html:link></li>
	<li><html:link href=""><bean:message key="mnu_employers" /></html:link></li>
</ul>

<form action="./locale.do" method="get">
	<button type="submit" name="language" value="en"><bean:message key="btn_en"/></button>
	<button type="submit" name="language" value="vi"><bean:message key="btn_vi"/></button>
</form>