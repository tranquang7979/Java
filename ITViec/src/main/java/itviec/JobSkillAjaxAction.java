package itviec;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class JobSkillAjaxAction extends Action{
	
	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/xml");
		
		String dbuser="root";
		String dbpassword="";
		String url = "jdbc:mysql://localhost:3306/itviec";
		
		try {
			PrintWriter pw = response.getWriter();
			
			//1.load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Tao connection
			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
			
			//3. statement
			Statement st = con.createStatement();
			
			//4.sql
			String sql = "select * from jobskills";
			
			ResultSet rs = st.executeQuery(sql);
				    
		    pw.append("<root>");		    
		    while(rs.next()) {		    	
				int id = rs.getInt("id");
				String name = rs.getString("name");
		    	
		    	pw.append("<jobskills>");
		    	pw.append("<id>"+id+"</id>");
		    	pw.append("<name>"+name+"</name>");
		    	pw.append("</jobskills>");
		    	
		    }
		    pw.append("</root>");
		     
		    rs.close();		    
		    
		    pw.print("");
		    
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return null;
	}
}


