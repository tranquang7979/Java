package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
//@WebServlet("/BrandController")
public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbuser="sa";
	String dbpassword="1";
	String url="jdbc:sqlserver://localhost;databaseName=GlobalToyz";
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		
		PrintWriter out =response.getWriter();
		out.print(" This is BrandController ");
		
		
//		//lay du lieu tu client gui 
//		
//		String cBrandId = request.getParameter("cBrandId");
//		String cBrandName = request.getParameter("cBrandName");
//		
//		
//		
//		try {
//			//1. load driver
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			//2. connection 
//			
//			Connection con =DriverManager.getConnection(url,dbuser, dbpassword);
//			
//			//3.  statement
//			Statement st = con.createStatement();
//			//4. sql
//					
//			String sql="INSERT into ToyBrand VALUES ('"+cBrandId+"','"+cBrandName+"')";
//		
//			System.out.println(sql);
//			
//			//5 execute
//			
//			int result=  st.executeUpdate(sql);
//			if(result> 0)
//				response.getWriter().append("add success!!!");
//			else{
//				response.getWriter().append("add fail!!!");
//			}
//			
//			//close connection
//			con.close();
//			
//		}catch (Exception e) {
//			
//			
//			e.printStackTrace();
//		}
//		
//		
	}

}
