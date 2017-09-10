package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOut extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session!=null) {
			session.removeAttribute("userName");
		}else {
			System.out.println("session已经过期");
		}
		resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
	}
	

}
