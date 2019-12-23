package strutstutorials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CategoryAction extends Action {
	//tu go @Override
	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		//xu ly trong action/controller
		
		if(form != null) {
			CategoryForm categoryForm = (CategoryForm)form;
			String id = categoryForm.getId();
			String name = categoryForm.getName();
			String description = categoryForm.getDescription();
			
			if(id != null && name != null && description != null) 
			{

				String sql = "INSERT INTO Category VALUES ('" + id + "','" + name + "','" + description + "')";
				String result = execINSERT_UPDATE_DELETE(sql);
				
				if(result == null || result.length() == 0) {
					categoryForm.setMessage("Add new category success");
					return mapping.findForward("success");
				}
			}
		}
		
		return mapping.findForward("error");
		
	}
	
	private String execINSERT_UPDATE_DELETE(String sql) {

		try {
			// 1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// 2. Tao connection
			Connection con = DriverManager.getConnection("jdbc:sqlserver://PC01;databaseName=GlobalToyz", "sa", "1");

			// 3. statement
			Statement st = con.createStatement();
			
			int i = st.executeUpdate(sql);
			if(i <= 0)
				return "Error";

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}

	
}
