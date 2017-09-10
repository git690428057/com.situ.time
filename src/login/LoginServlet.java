package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String checkCode = req.getParameter("checkCode");
		String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");
		if (checkCode == null|| checkCode.equals("")) {
			resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
			return;
		}
		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
			return;
		}
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		if ("z".equals(userName) && "1".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			resp.sendRedirect(req.getContextPath()+"/student?method=pageList");
		} else {
			resp.sendRedirect(req.getContextPath()+"/html/fail_login.html");
		}
	}

}
