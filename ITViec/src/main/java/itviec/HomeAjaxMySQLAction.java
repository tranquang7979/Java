package itviec;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HomeAjaxMySQLAction extends Action{

	
	@Override
	public ActionForward execute (ActionMapping maping, ActionForm form, 
			HttpServletRequest request,HttpServletResponse response)   {
		
		response.setContentType("text/xml");
		
		String url="jdbc:mysql://localhost:3306/itviec";
		String dbuser="root";
		String dbpassword="";
		
		try {
			PrintWriter pw = response.getWriter();
			
			//1. load driver
			Class.forName("com.mysql.jdbc.Driver");
			//2. connection 
			
			Connection con =DriverManager.getConnection(url,dbuser, dbpassword);
			
			//3.  statement
			Statement st = con.createStatement();
			//4. sql
		    String sql ="select * from jobs";
		    ResultSet rs = st.executeQuery(sql);
		     
		    
		    pw.append("<root>");		    
		    while(rs.next()) {		    	
		    	int id= rs.getInt("id");
		    	String title = rs.getString("title");
		    	String shortdescription = rs.getString("shortdescription");
		    	String image = rs.getString("image");
		    	
		    	pw.append("<job>");
		    	pw.append("<jobid>"+id+"</jobid>");
		    	pw.append("<jobtitle>"+title+"</jobtitle>");
		    	pw.append("<jobdescription>"+shortdescription+"</jobdescription>");
		    	pw.append("<image>"+image+"</image>");
		    	pw.append("</job>");
		    	
		    }
		    pw.append("</root>");
		     
		    rs.close();		    
		    
		    pw.print("");
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
				
		return null;
	}
}
