package la.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", "会員");
		request.setAttribute("action", "member");
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String inputId = request.getParameter("id");
			String inputPasswd = request.getParameter("passwd");

			InputStream in = getClass().getResourceAsStream("/login.properties");
			Properties prop = new Properties();
			prop.load(in);
			String id = prop.getProperty("ID");
			String passwd = prop.getProperty("PASSWORD");

			if(id.equals(inputId) && passwd.equals(inputPasswd)) {
				request.getSession().setAttribute("memberLogin", 2);
				request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			} else {
				request.setAttribute("title", "ログインエラー");
				request.setAttribute("body", "IDかパスワードが間違っています");
				request.getRequestDispatcher("Error").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "ログインエラー");
			request.setAttribute("body", "IDかパスワードが間違っています");
			request.getRequestDispatcher("Error").forward(request, response);
		}

		request.setAttribute("mode", "会員");
		request.setAttribute("action", "member");
	}
}
