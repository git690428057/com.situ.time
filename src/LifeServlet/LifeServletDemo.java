package LifeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServletDemo extends HttpServlet {
	public LifeServletDemo() {
		System.out.println("LifeServletDemo.LifeServletDemo()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeServletDemo.init()");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("LifeServletDemo.service()");
	}

	@Override
	public void destroy() {
		System.out.println("LifeServletDemo.destroy()");
	}
}
