package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CityDAO daoCity = new CityDAO();		
		List<City> cities = daoCity.getAllData();
		request.setAttribute("cities", cities);

		SkillDAO daoSkill = new SkillDAO();		
		List<Skill> skills = daoSkill.getAllData();
		request.setAttribute("skills", skills);		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./homepage.jsp");
		requestDispatcher.forward(request, response);
	}
}
