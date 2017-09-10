package baseServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			return;
		}
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			return;
		}
		req.setCharacterEncoding("utf-8");
		// 1、获得请求的method方法的名字
		String methodName = req.getParameter("method");
		// 2、获取当前被访问的对象的字节码对象
		// StudentMainServlet.class ClassMainServlet.class
		Class clazz = this.getClass();
		// 3、获取当前字节码对象中指定的方法
		try {
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			// 4、调用想要执行的方法
			method.invoke(this, req, resp);
		}
		catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
