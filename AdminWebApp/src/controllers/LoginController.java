package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String root = request.getServletContext().getContextPath();
		
		if(userName == null || userPassword == null)
		{
			response.sendRedirect(root + "/html/login.html");
		}
		
		if(userName.equals("admin") && userPassword.equals("admin")) {
			HttpSession session = request.getSession();
			System.out.println("SessionID: " + session.getId());
			
			//save to session
			session.setAttribute("islogin", true);
			
			response.sendRedirect(root + "/html/index.html");
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("Wrong username or password. Please try again!");
		}
	}

}
