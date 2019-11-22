package MyFilters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
//@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

	
	boolean isLogin =false;
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest req = (HttpServletRequest)request;
		String root = req.getServletContext().getContextPath();
		
		HttpSession session =  req.getSession();
		System.out.println("SessionID after login: " + session.getId());
		System.out.println("islogin attribute: " + session.getAttribute("islogin"));

		isLogin = session.getAttribute("islogin") != null && (boolean)session.getAttribute("islogin");
		
		System.out.println("isLogin: " + isLogin);
		
		if(isLogin==false) {
			
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(root + "/html/login.html");
			
		}else
		{
		   chain.doFilter(request, response);
		
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
