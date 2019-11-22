package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// duong cau hinh
//@WebServlet("/FirstServlet")

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String str = "";
   
    public FirstServlet() {
        super();
        str+="FirstServlet() -->";
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		str+="init() -->"+config.getInitParameter("connectionstring");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		str+="Service() -->";
		
		PrintWriter pw = response.getWriter();
		pw.write(str);
	}

}
