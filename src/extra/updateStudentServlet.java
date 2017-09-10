package extra;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.IStudentServers;
import BLL.StudentServerImpl;
import POJO.Student;

public class updateStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentServers studentServers = new StudentServerImpl();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(name, Integer.parseInt(age), gender, address, date, Integer.parseInt(id));
		studentServers.update(student);
		resp.sendRedirect("/q/findall");
	}
}
