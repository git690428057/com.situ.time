package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getContextPath());
		System.out.println(req.getServletPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		ServletContext servletContext = getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String url = properties.getProperty("url");
		System.out.println(url);
		
		
		
		
		
//		ÓÐÎÊÌâ,
		String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
//		String b = servletContext.getRealPath("a.txt");
//		String c = servletContext.getRealPath("/c.txt");
//		String d = servletContext.getRealPath("/WEB/d.txt");
		System.err.println(a);
//		System.err.println(c+"¹þ¹þ¹þ"+d);
	}
}
