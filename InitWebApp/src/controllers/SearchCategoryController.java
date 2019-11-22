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

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/SearchCategoryController")
public class SearchCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 String dbuser="sa";
	 String dbpassword="1";
	 String url = "jdbc:sqlserver://localhost;databaseName=GlobalToyz";
    public SearchCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
		
			//table
			str+="<table class='category-table'>";
			str+="<thead>";
			str+="<tr><th>CategoryId</th><th>CategoryName</th><th>Description</th></tr>";
			str+="</thead>";
			str+="<tbody>";
			
			Statement st2 = con.createStatement();
			String sql2 = "SELECT * FROM Category WHERE cCategoryId='"+request.getParameter("ddl_categories")+"'";
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while (rs2.next()) {
				String cCategory = rs2.getString("cCategory");
				String cCategoryId = rs2.getString("cCategoryId");
				String vDescription = rs2.getString("vDescription");
				
				str+="<tr><td>"+cCategoryId+"</td><td>"+cCategory+"</td><td>"+vDescription+"</td></tr> <br>";
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

}
