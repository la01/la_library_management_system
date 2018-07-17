package la.servlet.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PasswordGenerator;
import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;
import la.exception.DataAccessException;


@WebServlet("/InsertMember")
public class InsertMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			String action = request.getParameter("action");
			String mode = request.getParameter("mode");

			//Memberに値をつめる
			String strMemberId = request.getParameter("memberId");
			String familyName = request.getParameter("familyName");
			String name = request.getParameter("name");
			String postal = request.getParameter("postal");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String strBirthday = request.getParameter("birthday");
			Date birthday = Date.valueOf(strBirthday);

			Member member = new Member();
			member.setFamilyName(familyName);
			member.setName(name);
			member.setPostal(postal);
			member.setAddress(address);
			member.setTel(tel);
			member.setEmail(email);
			member.setBirthday(birthday);

			//RandomStringGeneratorで生成したパスワードを取得
			//取得したパスワードをuser_passwordに格納
			String password = PasswordGenerator.randomPasswordGenerator();
			member.setPassword(password);

			PostgreSQLMemberDao dao = new PostgreSQLMemberDao();
			int retId = dao.insert(member);
			member.setId(retId);
			request.setAttribute("member", member);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			forward(request, response, "WEB-INF/jsp/doneMember.jsp");

	}catch (DataAccessException e) {
		e.printStackTrace();
		request.setAttribute("title", "内部エラーが発生しました");
		request.setAttribute("body", e);
		gotoPage(request, response, "Error");
	}

	}
}
