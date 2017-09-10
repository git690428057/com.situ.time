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
		// 1����������method����������
		String methodName = req.getParameter("method");
		// 2����ȡ��ǰ�����ʵĶ�����ֽ������
		// StudentMainServlet.class ClassMainServlet.class
		Class clazz = this.getClass();
		// 3����ȡ��ǰ�ֽ��������ָ���ķ���
		try {
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			// 4��������Ҫִ�еķ���
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
