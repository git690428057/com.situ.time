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
		printWriter.println("<a href='http://localhost:8081/q/html/add_Student.html' style='text-decoration: none; color: cornflowerblue;'>���ѧ��</a>");
		printWriter.println("<a href='http://localhost:8081/q/html/delete_Student.html' style='text-decoration: none;'>ɾ��ѧ��</a>");
		printWriter.println("<a href='http://localhost:8081/q/html/update_Student.html' style='text-decoration: none;'>�޸�ѧ����Ϣ</a>");
		printWriter.println("<table border='1' cellspacing='0'>");
		printWriter.println("    <tr>");
		printWriter.println("         <td>���</td>");
		printWriter.println("         <td>����</td>");
		printWriter.println("         <td>����</td>");
		printWriter.println("         <td>�Ա�</td>");
		printWriter.println("         <td>��ַ</td>");
		printWriter.println("         <td>����</td>");
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
