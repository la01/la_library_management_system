package la.bean;

import javax.servlet.http.HttpServletRequest;

public class LoginCheck {
	
	public boolean check(HttpServletRequest request) {
		try {
			boolean login = (boolean) request.getSession().getAttribute("login");
			return login;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
