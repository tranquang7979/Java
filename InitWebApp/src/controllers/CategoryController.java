package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 String dbuser="sa";
	 String dbpassword="1";
	 String url = "jdbc:sqlserver://localhost;databaseName=GlobalToyz";
    public CategoryController() {
        super(); 
    }

	public void init(ServletConfig config) throws ServletException {
	}
	
	private void viewCategories(HttpServletRequest request, HttpServletResponse response) {

		try {
			//1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. Tao connection
			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
			
			//3. statement
			Statement st = con.createStatement();
			
			//4.sql
			String sql = "SELECT * FROM Category";
			
			//5. execute
			ResultSet rs = st.executeQuery(sql);
			System.out.print("ok con de");
			
			// tao tranfg tra ve
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8"); //tao trang co tieng viet
			
			PrintWriter pw = response.getWriter();
			String str = "";
			
			
			str+="<html>";
			str+="<head>";
			str+="<meta charset='utf-8'>";
			str+="<title>Untitled Document</title>";
			str+="<link rel='stylesheet' href='./css/style.css'/>";
			str+="<link rel='stylesheet' href='./css/all.css'/>";
			str+="</head>";
			
			str+="<body>";
			str+="<div id='top'>";
			str+="<img class='logo' src='./images/logo.png'/>";
			str+="<ul id=nav>";
			str+="<li><a href='#'>Home</a></li>";
			str+=" <li><a href='#'>Service</a></li>";
			str+="<li><a href='#'>Work</a></li>";
			str+="<li><a href='#'>Portfolio</a></li>";
			str+="<li><a href='#'>Cilent</a></li>";
			str+="<li><a href='#'>Team</a></li>";
			str+="<li><a href='#'>Contact</a></li>";
			str+="</ul>";
			
			str+="</div>";
			str+="<div id='bottom'>";
			str+="<h1>Category</h1>";
		
			//dropdownlist
			str+="<form action='./SearchCategoryController' method ='get'>";
			str+="<select name='ddl_categories'>";
			while (rs.next()) {
				String cCategory = rs.getString("cCategory");
				String cCategoryId = rs.getString("cCategoryId");
				str+="<option value='"+cCategoryId+"' >"+cCategory+"</option>";
			}
			str+="</select>";
			str+="<button type='submit'>Search </button> </form>";
			
			
			//table
			str+="<table class='category-table'>";
			str+="<thead>";
			str+="<tr><th>CategoryId</th><th>CategoryName</th><th>Description</th><th>Action</th></tr>";
			str+="</thead>";
			str+="<tbody>";
			
			Statement st2 = con.createStatement();
			String sql2 = "SELECT * FROM Category";
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while (rs2.next()) {
				String cCategory = rs2.getString("cCategory");
				String cCategoryId = rs2.getString("cCategoryId");
				String vDescription = rs2.getString("vDescription");
				
				str+="<tr><td>"+cCategoryId+"</td><td>"+cCategory+"</td><td>"+vDescription+"</td>"
						+ "<td><a href='./CategoryController?action=edit&&cId="+cCategoryId+"'>Edit</a> | "
						+"<a href='./CategoryController?action=delete&&cId="+cCategoryId+"'>Delete</a></td></tr>";
			}
			
			str+="</tbody>";
			str+="</table>";
			
			str+="</div>";
			str+="</body>";
			str+="</html>";
	
			pw.print(str);
	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteCategory (HttpServletRequest request, HttpServletResponse response) {

		try {
			//1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. Tao connection
			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
			
			//3. statement
			Statement st = con.createStatement();
			
			//4.sql
			String sql = "DELETE Category WHERE cCategoryId='"+request.getParameter("cId")+"'";
			
			int i = st.executeUpdate(sql);
			if (i>0) {
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void updateCategory (HttpServletRequest request, HttpServletResponse response) {

		try {
			//1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. Tao connection
			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
			
			//3. statement
			Statement st = con.createStatement();
			
			//4.sql
			String sql = "UPDATE Category SET cCategory='"+request.getParameter("cCategory")+"',"
					+"vDescription='"+request.getParameter("vDescription")
					+"' where cCategoryId='"+request.getParameter("cId")+"'";
			
			int i = st.executeUpdate(sql);
			if (i>0) {
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void editCategory (HttpServletRequest request, HttpServletResponse response) { 
		String cCategoryId = request.getParameter("cId");
		
		try {
			//1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. Tao connection
			Connection con = DriverManager.getConnection(url,dbuser,dbpassword);
			
			//3. statement
			Statement st = con.createStatement();
			
			//4.sql
			String sql = "SELECT * FROM Category WHERE cCategoryId='"+cCategoryId+"'";
			ResultSet rs = st.executeQuery(sql);
			
			//5 display html page with form
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8"); //tao trang co tieng viet
			
			PrintWriter pw = response.getWriter();
			String str = "";
			
			
			str+="<html>";
			str+="<head>";
			str+="<meta charset='utf-8'>";
			str+="<title>Untitled Document</title>";
			str+="<link rel='stylesheet' href='./css/style.css'/>";
			str+="<link rel='stylesheet' href='./css/all.css'/>";
			str+="</head>";
			
			str+="<body>";
			str+="<div id='top'>";
			str+="<img class='logo' src='./images/logo.png'/>";
			str+="<ul id=nav>";
			str+="<li><a href='#'>Home</a></li>";
			str+=" <li><a href='#'>Service</a></li>";
			str+="<li><a href='#'>Work</a></li>";
			str+="<li><a href='#'>Portfolio</a></li>";
			str+="<li><a href='#'>Cilent</a></li>";
			str+="<li><a href='#'>Team</a></li>";
			str+="<li><a href='#'>Contact</a></li>";
			str+="</ul>";
			
			str+="</div>";
			str+="<div id='bottom'>";
			str+="<h1>Edit Category</h1>";
			
			if (rs.next()) {
				str+="<form action='./CategoryController?action=update&&cId="+rs.getString("cCategoryId")+"' method='post'>";
				str+="<div>CategoryId</div>";
				str+="<div>"+rs.getString("cCategoryId")+"</div>";
				
				str+="<div>CategoryName</div>";
				str+="<input type='text' name='cCategory' value='"+rs.getString("cCategory")+"'/>";
				
				str+="<div>Description</div>";
				str+="<textarea name='vDescription' cols= '50' rows='5' >"+rs.getString("vDescription")+"</textarea>";
				
				str+="<div><button type='submit' id='update'>Update</button></div>";
				str+="</form>";
			}
			
			
			str+="</div>";
			str+="</body>";
			str+="</html>";
	
			pw.print(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			viewCategories(request, response);
		} else {
			if (action.equals("delete")) {
				deleteCategory(request, response);
				viewCategories(request, response);
			} else if (action.equals("edit")) {
				editCategory(request, response);
			} else if (action.equals("update")) {
				updateCategory(request, response);
				viewCategories(request, response);
			}
			
		}	
	}
}
