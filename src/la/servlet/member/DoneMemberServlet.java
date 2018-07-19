package la.servlet.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;
import la.bean.PasswordGenerator;
import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;
import la.exception.DataAccessException;

@WebServlet("/DoneMember")
public class DoneMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			LoginCheck loginCheck = new LoginCheck();
			if(!loginCheck.staffCheck(request)) {
				request.setAttribute("title", "ログインが必要なページです");
				request.setAttribute("body", "");
				forward(request, response, "Error");
				return;
			}
			
			// get request parameter
			String mode = request.getParameter("mode");
			String action = request.getParameter("action");
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
			if(action.equals("insert")) {
				member.setFamilyName(familyName);
				member.setName(name);
				member.setPostal(postal);
				member.setAddress(address);
				member.setTel(tel);
				member.setEmail(email);
				member.setBirthday(Date.valueOf(birthday));
				PasswordGenerator passwordGenerator = new PasswordGenerator();
				String password = passwordGenerator.getRandomPassword();
				member.setPassword(password);
				
				int retId = dao.insert(member);
				member.setId(retId);
			} else if(action.equals("update")) {
				member.setId(Integer.parseInt(memberId));
				member.setFamilyName(familyName);
				member.setName(name);
				member.setPostal(postal);
				member.setAddress(address);
				member.setTel(tel);
				member.setEmail(email);
				member.setBirthday(Date.valueOf(birthday));
				
				dao.update(member);
			} else if(action.equals("delete")) {
				member.setId(Integer.parseInt(memberId));
				member.setFamilyName(familyName);
				member.setName(name);
				
				dao.delete(Integer.parseInt(memberId));
			} else {
				request.setAttribute("title", "不正な操作が実行されました");
				forward(request, response, "Error");
				return;
			}

			// set request attribute
			request.setAttribute("member", member);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			
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

		forward(request, response, "WEB-INF/jsp/doneMember.jsp");
	}
}
