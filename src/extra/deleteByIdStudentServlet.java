package extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.IStudentServers;
import BLL.StudentServerImpl;

public class deleteByIdStudentServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	IStudentServers studentServers = new StudentServerImpl();
	String id = req.getParameter("id");
	studentServers.deleteById(Integer.parseInt(id));
	resp.sendRedirect("/q/findall");
}
}
