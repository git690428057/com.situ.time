package BLL;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DIYexception.NameRepeatE;
import POJO.ClassRoom;
import POJO.Course;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public class StudentServlet extends baseServlet.BaseServlet {
	IStudentServers studentServers = new StudentServerImpl();

	// 多条件搜索
	private void selectByCondition(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String startBirthday = req.getParameter("startBirthday");
		String endBirthday = req.getParameter("endBirthday");
		String className = req.getParameter("className");
		selectCondition searchCondition = new selectCondition(id, name, age, gender, address,startBirthday,endBirthday,className);
		List<Student> list = studentServers.searchByCondition(searchCondition);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/JSP/student_list.jsp").forward(req, resp);
	}

	// 查询指定出生日期区间学生信息
	private void toselectByBirthday(HttpServletRequest req, HttpServletResponse resp)
			throws ParseException, ServletException, IOException {
		String startbirthday1 = req.getParameter("startbirthday");
		String endbirthday1 = req.getParameter("endbirthday");
		if (startbirthday1 == "" || endbirthday1 == "") {
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startbirthday = sdf.parse(startbirthday1);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date endbirthday = sdf1.parse(endbirthday1);
		List<Student> list = studentServers.selectByBirthday(startbirthday, endbirthday);
		if (!list.isEmpty()) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("/jsp/student_selectByBirthday.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/qw/html/no_nameStudent.html");
		}
	}

	// 查询指定Name学生信息
	private void toselectByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name1");
		List<Student> list = studentServers.selectByName(name);
		if (!list.isEmpty()) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("/jsp/student_selectByName.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/qw/html/no_nameStudent.html");
		}
	}

	// 查询指定地址学生信息
	private void toselectByAddress(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String address = req.getParameter("address");
		List<Student> list = studentServers.selectByAddress(address);
		if (!list.isEmpty()) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("/jsp/student_selectByAddress.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/qw/html/no_nameStudent.html");
		}
	}

	// 展示学生信息修改页面
	private void toUpdateStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		List<Student> list = studentServers.selectById(Integer.parseInt(id));
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/student_update.jsp").forward(req, resp);
	}

	// 修改学生信息
	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String className = req.getParameter("className");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(name, Integer.parseInt(age), gender, address, date, className,
				Integer.parseInt(id));
		studentServers.update(student);
		resp.sendRedirect("/qw/student?method=pageList");
	}

	// 删除学生信息
	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		studentServers.deleteById(Integer.parseInt(id));
		resp.sendRedirect("/qw/student?method=pageList");
	}

	// 添加学生信息
	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String className = req.getParameter("className");
		int classId = 0;
		if (className.equals("JAVA")) {
			classId = 1;
		}else if (className.equals("HTML")) {
			classId = 2;
		}else if (className.equals("UI")) {
			classId = 3;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		Student student = new Student(name, Integer.parseInt(age), gender, address, date,classId,className);
		try {
			studentServers.add(student);
		} catch (NameRepeatE e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/qw/student?method=pageList");
	}

	// 分页封装结果集
	private void pageList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String PageIndexStr = req.getParameter("pageIndex");
		String PageSizeStr = req.getParameter("pageSize");
		int PageIndex = 1;
		if (PageIndexStr != null && !PageIndexStr.equals("")) {
			PageIndex = Integer.parseInt(PageIndexStr);
		}
		int PageSize = 3;
		if (PageSizeStr != null && !PageSizeStr.equals("")) {
			PageSize = Integer.parseInt(PageSizeStr);
		}
		PageBean pageBean = studentServers.getPageBean(PageIndex, PageSize);
		List<Student> list = pageBean.getList();
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/JSP/student_list.jsp").forward(req, resp);
	}

	// 批量删除
	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String[] ids = req.getParameterValues("selectIds");
		studentServers.deleteAll(ids);
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
	}

	private void getAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/JSP/student_add.jsp").forward(req, resp);
	}

	private void getSercherPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/student_sercher.jsp").forward(req, resp);
	}


	// 展示班级列表方法
	private void getClassInformation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		list = studentServers.getClassInformation();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/JSP/classInformation.jsp").forward(req, resp);
	}
	// 展示班级_课程列表方法
	private void getClass_CourseInformation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Course> list = new ArrayList<Course>();
		list = studentServers.getClass_CourseInformation();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/JSP/class_courseInformation.jsp").forward(req, resp);
	}
	// 跳转教务管理页面
		private void getAdministration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher("/WEB-INF/JSP/administration.jsp").forward(req, resp);
		}

}
