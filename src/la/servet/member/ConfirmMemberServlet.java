package la.servet.member;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ValidationErrors;
import la.bean.member.InputMemberForm;

@WebServlet("/ConfirmMember")
public class ConfirmMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/confirmMember.jsp").forward(request, response);
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
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");



			if (!(action.equals("delete"))) {
				InputMemberForm memberForm = new InputMemberForm(memberId, familyName, name, postal, address, tel,
						email, year, month, date);
				ValidationErrors errors = memberForm.validate();

				if (errors.getSize() != 0) {
					request.setAttribute("title", "入力フォームエラー");
					request.setAttribute("body", errors);
					forward(request, response, "Error");
				}
			} else {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date formatDate = sdf.parse(birthday);

					SimpleDateFormat ysdf = new SimpleDateFormat("yyyy");
					year = ysdf.format(formatDate);
					SimpleDateFormat msdf = new SimpleDateFormat("MM");
					month = msdf.format(formatDate);
					SimpleDateFormat dsdf = new SimpleDateFormat("dd");
					date = dsdf.format(formatDate);
				} catch (ParseException e) {
					e.printStackTrace();
					return;
				}
			}

			request.setAttribute("memberId", memberId);
			request.setAttribute("familyName", familyName);
			request.setAttribute("name", name);
			request.setAttribute("postal", postal);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("email", email);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("birthday", birthday);
			request.setAttribute("date", date);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);

			forward(request, response, "WEB-INF/jsp/confirmMember.jsp");
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
	}
}
