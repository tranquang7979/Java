package itviec;
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

public class HomeAjaxAction extends Action{

	
	@Override
	public ActionForward execute (ActionMapping maping, ActionForm form, 
			HttpServletRequest request,HttpServletResponse response)   {
		
		String url="jdbc:mysql://localhost:3306/itviec";
		String dbuser="root";
		String dbpassword="";
		
		try {
			//1. load driver
			Class.forName("com.mysql.jdbc.Driver");
			//2. connection 
			
			Connection con =DriverManager.getConnection(url,dbuser, dbpassword);
			
			//3.  statement
			Statement st = con.createStatement();
			//4. sql
		    String sql ="select * from jobs";
		    ResultSet rs = st.executeQuery(sql);
		     
		    List<JobForm> jobs = new ArrayList<JobForm>();
		    
		    while(rs.next()) {
		    	
		    	int id= rs.getInt("id");
		    	String title = rs.getString("title");
		    	String shortdescription = rs.getString("shortdescription");
		    	String image = rs.getString("image");
		    	
		    	
		    	JobForm job =new JobForm(id, title, shortdescription, image);
		    	
		    	jobs.add(job);
		    }
		     
		    rs.close();
		    
		    request.setAttribute("jobs", jobs);
		     
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return maping.findForward("success");
	}
}
