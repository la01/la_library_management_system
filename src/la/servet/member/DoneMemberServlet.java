package la.servet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoneMember")
public class DoneMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/doneMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			request.setAttribute("title", "不正な操作が実行されました");
			forward(request, response, "Error");
			return;
		}

		switch (action) {
		case "insert":
			forward(request, response, "InsertMember");
			break;
		case "update":
			forward(request, response, "UpdateMember");
			break;
		case "delete":
			forward(request, response, "DeleteMember");
			break;
		default:
			return;
		}
	}
}
