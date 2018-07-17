package la.servlet.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PasswordGenerator;
import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;

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
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			request.setAttribute("title", "不正な操作が実行されました");
			forward(request, response, "Error");
			return;
		}

		try {
			String memberId = request.getParameter("memberId");
			String familyName = request.getParameter("familyName");
			String name = request.getParameter("name");
			String postal = request.getParameter("postal");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String birthday = request.getParameter("birthday");

			PostgreSQLMemberDao dao = new PostgreSQLMemberDao();
			Member member = new Member();

			switch (action) {
			case "insert":
				member.setFamilyName(familyName);
				member.setName(name);
				member.setPostal(postal);
				member.setAddress(address);
				member.setTel(tel);
				member.setEmail(email);
				member.setBirthday(Date.valueOf(birthday));

				// RandomStringGeneratorで生成したパスワードを取得
				// 取得したパスワードをuser_passwordに格納
				String password = PasswordGenerator.randomPasswordGenerator();
				member.setPassword(password);
				int retId = dao.insert(member);
				member.setId(retId);
				break;
			case "update":
				member.setId(Integer.parseInt(memberId));
				member.setFamilyName(familyName);
				member.setName(name);
				member.setPostal(postal);
				member.setAddress(address);
				member.setTel(tel);
				member.setEmail(email);
				member.setBirthday(Date.valueOf(birthday));
				dao.update(member);
				break;
			case "delete":
				member.setId(Integer.parseInt(memberId));
				member.setFamilyName(familyName);
				member.setName(name);
				dao.delete(Integer.parseInt(memberId));
				break;
			default:
				request.setAttribute("title", "不正な操作が実行されました");
				forward(request, response, "Error");
				return;
			}

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
