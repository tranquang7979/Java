package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String dbuser="sa";
    String dbpassword="1";
    String url = "jdbc:sqlserver://localhost;databaseName=GlobalToyz";
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
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
			
			String cShopperId = request.getParameter("cShopperId");
			String cPassword = request.getParameter("cPassword");
			String vFirstName = request.getParameter("vFirstName");
			String vLastName = request.getParameter("vLastName");
			String vEmailId = request.getParameter("vEmailId");
			String vAddress = request.getParameter("vAddress");
			String cCity = request.getParameter("cCity");
			String cState = request.getParameter("cState");
			String cCountryId = request.getParameter("cCountryId");
			String cZipCode = request.getParameter("cZipCode");
			String cPhone = request.getParameter("cPhone");
			String cCreditCardNo = request.getParameter("cCreditCardNo");
			String vCreditCardType = request.getParameter("vCreditCardType");
			String dExpiryDate = request.getParameter("dExpiryDate");
			
			String sql = "INSERT into Shopper VALUES('"+cShopperId+"','"+cPassword+"','"+vFirstName+"','"+vLastName
					+"','"+vEmailId+"','"+vAddress+"','"+cCity+"','"+cState+"','"+cCountryId+"','"+cZipCode+"','"+cPhone
					+"','"+cCreditCardNo+"','"+vCreditCardType+"','"+dExpiryDate+"')";
			System.out.print(sql);
			//5. execute
			
			int result = st.executeUpdate(sql);
			if (result>0) {
				//response.getWriter().append("register successful");
				RequestDispatcher dis = request.getRequestDispatcher("./login.html");
				dis.forward(request, response);
			} else {
				response.getWriter().append("register fail");
			}
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
