package la.servet.member;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputMember")
public class InputMemberServlet extends MemberServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("mode", "登録");
		request.setAttribute("action", "insert");
		request.getRequestDispatcher("WEB-INF/jsp/inputMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String familyName = request.getParameter("familyName");
		String name = request.getParameter("name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		int year, month, date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date formatDate = sdf.parse(birthday);

			SimpleDateFormat ysdf = new SimpleDateFormat("yyyy");
			String strYear = ysdf.format(formatDate);
			year = Integer.parseInt(strYear);
			SimpleDateFormat msdf = new SimpleDateFormat("MM");
			String strMonth = msdf.format(formatDate);
			month = Integer.parseInt(strMonth);
			SimpleDateFormat dsdf = new SimpleDateFormat("dd");
			String strDate = dsdf.format(formatDate);
			date = Integer.parseInt(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
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
		request.setAttribute("date", date);
		request.setAttribute("mode", "変更");
		request.setAttribute("action", "update");
		request.getRequestDispatcher("WEB-INF/jsp/inputMember.jsp").forward(request, response);

	}

}
