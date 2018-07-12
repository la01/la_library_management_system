package la.servet.member;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String familyName = request.getParameter("familyName");
		String name = request.getParameter("name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = sdf.parse(birthday);

		request.setAttribute("memberId", memberId);
		request.setAttribute("familyName", familyName);
		request.setAttribute("name", name);
		request.setAttribute("postal", postal);
		request.setAttribute("address", address);
		request.setAttribute("tel", tel);
		request.setAttribute("email", email);
		request.setAttribute("mode", "変更");
		request.setAttribute("action", "update");
		request.getRequestDispatcher("WEB-INF/jsp/inputMember.jsp").forward(request, response);
	}

}
