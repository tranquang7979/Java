package itviec;

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

public class JobSkillsAction extends Action {

	@Override
	public ActionForward execute (ActionMapping maping, ActionForm form, 
			HttpServletRequest request,HttpServletResponse response)   {
		
		// access mysql server 
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
		    String sql ="select * from jobskills";
		    ResultSet rs = st.executeQuery(sql);
		     
		    List<String> skillnames = new ArrayList<String>();
		    
		    while(rs.next()) {
		    	
		    	int id= rs.getInt("id");
		    	String name = rs.getString("name");
		    	
		    	skillnames.add(name);
		    }
		     
		    rs.close();
		    
		    request.setAttribute("skills", skillnames);
		     
		}catch (Exception e) {
			
			
			
		}
		
	
		return maping.findForward("success");
	}
}
