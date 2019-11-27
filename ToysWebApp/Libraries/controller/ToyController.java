package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.ToyDAO;
import model.ToyModel;

/**
 * Servlet implementation class ToyController
 */
@WebServlet("/ToyController")
public class ToyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ToyDAO toyDAO = new ToyDAO();
		
		RequestDispatcher requestDispatcher = null;
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "all":
			//List<ToyModel> toys = toyDAO.getAllToys();
			requestDispatcher = request.getRequestDispatcher("./view/getAllToys.jsp");
			break;
		case "top5":
			requestDispatcher = request.getRequestDispatcher("./view/top5.jsp");
			break;
		}

		if(requestDispatcher != null)
			requestDispatcher.forward(request, response);
	}

}
