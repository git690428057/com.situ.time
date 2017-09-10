package tests;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet{
//@Override
//protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	ServletConfig servletConfig = getServletConfig();
//	String MaxOnline = servletConfig.getInitParameter("MaxOnline");
//	System.out.println(MaxOnline);
//	
//}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String MaxOnline = config.getInitParameter("MaxOnline");
		System.out.println(MaxOnline);
		System.out.println(config.getServletName());
		ServletContext servletContext = config.getServletContext();
		
	}
}
