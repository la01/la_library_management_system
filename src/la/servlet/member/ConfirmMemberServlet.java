package la.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;

@WebServlet("/ConfirmMember")
public class ConfirmMemberServlet extends MemberServlet {
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

			request.setAttribute("memberId", memberId);
			request.setAttribute("familyName", familyName);
			request.setAttribute("name", name);
			request.setAttribute("postal", postal);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("email", email);
			request.setAttribute("birthday", birthday);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);

		} catch (NullPointerException e) {
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
		
		forward(request, response, "WEB-INF/jsp/confirmMember.jsp");
	}
}
