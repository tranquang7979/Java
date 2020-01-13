<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<ul id="nav">
 <li><html:link  href=""> <bean:message key="mnu_alljob"/> </html:link></li>
 <li><html:link  href=""> <bean:message key="mnu_itcompanies"/> </html:link></li>
 <li><html:link  href=""> <bean:message key="mnu_signin"/> </html:link></li>
 <li><html:link  href=""> <bean:message key="mnu_employers"/> </html:link></li>
</ul>    

<form action="./locale.do" method='get'>
   <button type="submit" name="language" value="en" ><bean:message key="btn_en"/> </button>
   <button type="submit" name="language" value="vi"  ><bean:message key="btn_vi"/> </button>
</form>

<style type="text/css">
	#jobskills{
		list-style: none;
	}
	#jobskills li{
		display:inline-block;
		margin: 0 5px;
		padding: 5px;
	}
	#jobskills li a{
		color:#fff;
		text-decoration: none;
	}
	#jobskills li a:hover{
		text-decoration: underline;
	}
</style>
<ul id="jobskills"></ul>

<script src="./js/jquery.js"></script>

<script>

function getJobSkills(){
	$.ajax({
		url:"./get-job-skills.do",
		dataType: 'xml',
		success: function(result) {
			
			var s = "";
			$(result).find('jobskills').each(function(){
				var name = $(this).find('name').text();
				
				s += '<li><a href="#">'+name+'</a></li>';
			});
			
			$("#jobskills").html(s);
		}
	});
}
getJobSkills();
</script>
    