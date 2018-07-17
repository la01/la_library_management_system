package la.servlet.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;
import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;
import la.exception.DataAccessException;

@WebServlet("/SearchMember")
public class SearchMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.check(request)) {
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}
		
		forward(request, response, "WEB-INF/jsp/searchMember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Member> memberList = new ArrayList<Member>();

		try {
			// get parameter
			String memberId = request.getParameter("memberId");
			String familyName = request.getParameter("familyName");
			String name = request.getParameter("name");
			String postal = request.getParameter("postal");
			String address = request.getParameter("address");
			String tel  = request.getParameter("tel");
			String email = request.getParameter("email");

			// set parameter for input form
			request.setAttribute("memberId", memberId);
			request.setAttribute("familyName", familyName);
			request.setAttribute("name", name);
			request.setAttribute("postal", postal);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("email", email);

			// create member
			Member member = new Member();
			if(memberId != null && memberId.length() != 0) {
				member.setId(Integer.parseInt(memberId));
			}
			member.setFamilyName(familyName);
			member.setName(name);
			member.setPostal(postal);
			member.setAddress(address);
			member.setTel(tel);
			member.setEmail(email);

			// dao
			PostgreSQLMemberDao memberDao = new PostgreSQLMemberDao();
			memberList = memberDao.selectByCondition(member);

		} catch(DataAccessException e) {
			request.setAttribute("title", "検索に失敗しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(NullPointerException e) {
			request.setAttribute("title", "予期せぬエラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(Exception e) {
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}

		// set request scope
		request.setAttribute("result", true);
		request.setAttribute("memberList", memberList);

		forward(request, response, "WEB-INF/jsp/searchMember.jsp");
	}

}
