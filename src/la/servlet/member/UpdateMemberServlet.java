package la.servlet.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMember")
public class UpdateMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");

		try {

			String strMemberId = request.getParameter("memberId");
			String familyName = request.getParameter("familyName");
			String name = request.getParameter("name");
			String postal = request.getParameter("postal");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");

			int memberId = Integer.parseInt(strMemberId);

			Date birthday = Date.valueOf(year + "-" + month + "-" + date);

			Member member = new Member(memberId, familyName, name, postal, address, tel, email, birthday);

			PostgreSQLMemberDao dao = new PostgreSQLMemberDao();
			dao.update(member);

			request.setAttribute("member", member);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			forward(request, response, "WEB-INF/jsp/doneMember.jsp");
		} catch (NumberFormatException e) {
			request.setAttribute("title", "予期せぬエラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch (Exception e) {
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}
	}

}
