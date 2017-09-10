package BLL;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO.Manager;

public class ManagersServlet extends HttpServlet {
	IStudentServers studentServers = new StudentServerImpl();

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		selectAll_manager(req, resp);
	}

	private void selectAll_manager(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		List<Manager> list = studentServers.selectAll_Manager();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/managers_list.jsp").forward(req, resp);
	}
}
