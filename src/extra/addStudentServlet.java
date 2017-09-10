package extra;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.IStudentServers;
import BLL.StudentServerImpl;
import DIYexception.NameRepeatE;
import POJO.Student;

public class addStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentServers studentServers = new StudentServerImpl();
		// 1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
//		获得请求行
		System.out.println("请求方式:"+req.getMethod());
		System.out.println("uri:"+req.getServletPath());
		System.out.println("http版本:"+req.getProtocol());
//		获得请求头
		Enumeration<String> enumeration = req.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String key = enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println(key+":"+value);
		}
		// 处理业务
		Student student = new Student(name, Integer.parseInt(age), gender, address, date);
//		boolean result =false;
		try {
			studentServers.add(student);
		} catch (NameRepeatE e) {
			e.printStackTrace();
		}
//		PrintWriter printWriter = resp.getWriter();
//		if(result){
//			printWriter.println("haha");
//			
//		}else{
//			printWriter.println("xixi");
//		}

		// 重定向
		resp.sendRedirect("/q/findall.do");
	}
}
