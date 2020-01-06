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

public class HomeAction extends Action{
	
	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
//		String dbuser="root";
//		String dbpassword="";
//		String url = "jdbc:mysql://localhost:3306/itviec";
//		
//		try {
//			//1.load driver
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			//2. Tao connection
//			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
//			
//			//3. statement
//			Statement st = con.createStatement();
//			
//			//4.sql
//			String sql = "select * from jobs";
//			
//			ResultSet rs = st.executeQuery(sql);
//			
//			List<String> skillName = new ArrayList<String>();
//			
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				
//				skillName.add(name);
//			}
//			rs.close();
//			
//			request.setAttribute("skills", skillName);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
		
		return mapping.findForward("success");
	}
}


