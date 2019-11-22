package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Method get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String title = request.getParameter("title");
//		String email = request.getParameter("email");
//		String message = request.getParameter("message");
//		
//		// tao trang thanks bang servlet
//		PrintWriter pw = response.getWriter();
//		
//		
//		String str ="";
//		str+="<head>";
//		str+="<meta charset='utf-8'>";
//		str+="<title>Untitled Document</title>";
//		str+="<link rel='stylesheet' href='./css/style.css'/>";
//		str+="<link rel='stylesheet' href='./css/all.css'/>";
//		str+="</head>";
//
//		str+="<body>";
//		str+="<div id='top'>";
//		str+="<img class='logo' src='./images/logo.png'/>";
//		str+="<ul id=nav>";
//		str+="<li><a href='#'>Home</a></li>";
//		str+="<li><a href='#'>Service</a></li>";
//		str+="<li><a href='#'>Work</a></li>";
//		str+="<li><a href='#'>Portfolio</a></li>";
//		str+="<li><a href='#'>Cilent</a></li>";
//		str+="<li><a href='#'>Team</a></li>";
//		str+=" <li><a href='#'>Contact</a></li>";
//		str+="</ul>";
//		str+="</div>";
//		
//		
//		str+="<div id='bottom'>";
//		str+="<h1>Thanks for your contact!</h1>";
//		str+="<ul>";
//		str+="<li>"+title+"</li>";
//		str+="<li>"+email+"</li>";
//		str+="<li>"+message+"</li>";
//		str+="</ul>";
//		str+="</div>";
//		
//		str+="</body>";
//		str+="</html>";
//		
//		response.setContentType("text/html");
//		pw.write(str);
		
		String email = request.getParameter("email");
		String str  = "<h1>"+email+"</h1>";
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write(str);
	}

}
