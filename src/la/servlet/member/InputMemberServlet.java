package la.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;

@WebServlet("/InputMember")
public class InputMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.check(request)) {
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}
		
		request.setAttribute("mode", "登録");
		request.setAttribute("action", "insert");
		forward(request, response, "WEB-INF/jsp/inputMember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.check(request)) {
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}

		String memberId = request.getParameter("memberId");
		String familyName = request.getParameter("familyName");
		String name = request.getParameter("name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		request.setAttribute("memberId", memberId);
		request.setAttribute("familyName", familyName);
		request.setAttribute("name", name);
		request.setAttribute("postal", postal);
		request.setAttribute("address", address);
		request.setAttribute("tel", tel);
		request.setAttribute("email", email);
		request.setAttribute("birthday", birthday);
		request.setAttribute("mode", "変更");
		request.setAttribute("action", "update");
		
		forward(request, response, "WEB-INF/jsp/inputMember.jsp");
	}
}
