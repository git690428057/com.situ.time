package extra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.IStudentServers;
import BLL.StudentServerImpl;
import POJO.Student;

public class findAllStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		IStudentServers studentServers = new StudentServerImpl();
		List<Student> list = studentServers.selectAll();
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='http://localhost:8081/q/html/add_Student.html' style='text-decoration: none; color: cornflowerblue;'>添加学生</a>");
		printWriter.println("<a href='http://localhost:8081/q/html/delete_Student.html' style='text-decoration: none;'>删除学生</a>");
		printWriter.println("<a href='http://localhost:8081/q/html/update_Student.html' style='text-decoration: none;'>修改学生信息</a>");
		printWriter.println("<table border='1' cellspacing='0'>");
		printWriter.println("    <tr>");
		printWriter.println("         <td>编号</td>");
		printWriter.println("         <td>姓名</td>");
		printWriter.println("         <td>年龄</td>");
		printWriter.println("         <td>性别</td>");
		printWriter.println("         <td>地址</td>");
		printWriter.println("         <td>生日</td>");
		printWriter.println("    </tr>");
		for (Student student : list) {
			printWriter.println("<tr>");
			printWriter.println("    <td>" + student.getId() + "</td>");
			printWriter.println("    <td>" + student.getName() + "</td>");
			printWriter.println("    <td>" + student.getAge() + "</td>");
			printWriter.println("    <td>" + student.getGender() + "</td>");
			printWriter.println("    <td>" + student.getAddress() + "</td>");
			printWriter.println("    <td>" + student.getBirthday() + "</td>");
			printWriter.println("</tr>");
		}
		printWriter.println("</table>");
		printWriter.close();

	}
}
