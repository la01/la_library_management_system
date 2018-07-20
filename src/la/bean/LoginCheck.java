package la.bean;

import javax.servlet.http.HttpServletRequest;

public class LoginCheck {

	// 職員
	public boolean staffCheck(HttpServletRequest request) {
		try {
			int login = (int) request.getSession().getAttribute("login");
			return  login == 1 ? true : false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 会員
	public boolean memberCheck(HttpServletRequest request) {
		try {
			int login = (int) request.getSession().getAttribute("memberLogin");
			return  login == 2 ? true : false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
