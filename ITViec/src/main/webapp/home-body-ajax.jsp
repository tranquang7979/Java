<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<script src="./js/jquery.js"></script>

<script>

function getJobs(){
	
	var xHttp = new XMLHttpRequest();
	//dang ky ham callback
	xHttp.onreadystatechange = function(){
		
		if(this.status == 200 && this.readyState == 4 )
		
		{ 
			callback(this);
		
		}
		
	} 
	xHttp.open('GET','./GetJobs.jsp', true);
	xHttp.send(null);
	
	
}

function callback(result){
	
	alert(result.responseXML);
	var xmlDoc= result.responseXML;
	
	var jobs = xmlDoc.getElementsByTagName("job");
	for(var i=0;i<jobs.length;i++){
		
		var title = jobs[i].getElementsByTagName("jobtitle")[0].childNodes[0].nodeValue;
		alert(title);
		
	}
	
}

function getJobsJQuery(url){
	$.ajax({
		url:url,
		dataType: 'xml',
		success: function(result) {
			
			var s = "";
			$(result).find('job').each(function(){
				var title = $(this).find('jobtitle').text();
				var jobdescription = $(this).find('jobdescription').text();
				var image = $(this).find('image').text(); 
				
				s += "<div id='itembox'>";
				s += "<img src='./images/"+image+"' width='100px' height='100px'/>";
				s += "<h2>"+title+"</h2>";
				s += "<p>"+title+"</p>";
				s += "</div>";
			});
			
			$("#employers").html(s);
		}
	});
}

$(document).ready(function(){
	
	$("#but1").on("click", function(){
		alert("click here");
		getJobs();		
	});
	
	$("#but2").on("click", function(){
		getJobsJQuery('./GetJobs.jsp');		
	});
	
	$("#but3").on("click", function(){
		getJobsJQuery('.//homeajaxmysql.do');		
	});
})
	
</script>
    
<h1>Top Employers</h1>
<button id='but1'>Ajax -xml 1</button>
<button id='but2'>Ajax -xml 2</button>
<button id='but3'>Ajax -action</button>

<div id="employers"></div>