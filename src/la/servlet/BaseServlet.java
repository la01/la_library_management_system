package la.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean loginCheck(HttpServletRequest request) {
		try {
			Object obj = request.getSession().getAttribute("login"); 
			if(obj != null) {
				boolean login = (boolean) obj;
				return login;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
