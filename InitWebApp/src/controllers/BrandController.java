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
 * Servlet implementation class BrandController
 */
@WebServlet("/BrandController")
public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 String dbuser="sa";
	 String dbpassword="1";
	 String url = "jdbc:sqlserver://localhost;databaseName=GlobalToyz";
    public BrandController() {
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
			String sql = "SELECT * FROM ToyBrand";
			
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
			str+="<h1>Brands</h1>";
			
			
			while (rs.next()) {
				String cBrandName = rs.getString("cBrandName");
				str+="<div id='box'>\r\n" + 
						"    	<span class='circle blue1'><i class='fas fa-user'></i></span>\r\n" + 
						"    	<h3>"+cBrandName+"</h3>\r\n" + 
						"        <p>Description</p>\r\n" + 
						"    </div>";
			}
			
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
