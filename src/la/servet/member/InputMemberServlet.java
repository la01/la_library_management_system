package la.servet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputMember")
public class InputMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", "登録");
		request.setAttribute("action", "insert");
		request.getRequestDispatcher("WEB-INF/jsp/inputMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", "変更");
		request.setAttribute("action", "update");
		request.getRequestDispatcher("WEB-INF/jsp/inputMember.jsp").forward(request, response);
	}

}
