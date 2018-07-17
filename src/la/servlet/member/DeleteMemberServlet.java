package la.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;

@WebServlet("/DeleteMember")
public class DeleteMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");

		try {

			String strMemberId = request.getParameter("memberId");
			String familyName = request.getParameter("familyName");
			String name = request.getParameter("name");

			int memberId = Integer.parseInt(strMemberId);

			Member member = new Member();
			member.setId(memberId);
			member.setFamilyName(familyName);
			member.setName(name);

			PostgreSQLMemberDao dao = new PostgreSQLMemberDao();
			dao.delete(memberId);

			request.setAttribute("member", member);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			forward(request, response, "WEB-INF/jsp/doneMember.jsp");

		} catch (Exception e) {
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}
	}

}
