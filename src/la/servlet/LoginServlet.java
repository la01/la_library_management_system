package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		if("id".equals(id) && "password".equals(passwd)) {
			request.getSession().setAttribute("login", true);
			request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		} else {
			request.setAttribute("title", "ログインエラー");
			request.setAttribute("body", "IDかパスワードが間違っています");
			request.getRequestDispatcher("Error").forward(request, response);
		}
	}

}
