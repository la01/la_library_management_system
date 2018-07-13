package la.servlet.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.member.Member;
import la.dao.PostgreSQLMemberDao;
import la.exception.DataAccessException;


@WebServlet("/InsertMemberServlet")
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
			String familyname = request.getParameter("user_family_name"); //VARCHAR
			String name = request.getParameter("user_name");  //VARCHAR
			String postal = request.getParameter("user_postal");  //CHAR
			String address = request.getParameter("user_address");  //VARCHAR
			String tel = request.getParameter("user_tel");  //VARCHAR
			String email = request.getParameter("user_email");  //VARCHAR
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");


			Date birthday = Date.valueOf(year + "-" + month + "-" + date);

			Member member = new Member(familyname, name, postal, address, tel, email, birthday);

			PostgreSQLMemberDao dao = new PostgreSQLMemberDao();
			dao.insert(member);

			request.setAttribute("member", member);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			forward(request, response, "WEB-INF/jsp/doneMember.jsp");

			//RandomStringGeneratorで生成したパスワードを取得
			//取得したパスワードをuser_passwordに格納

	}catch (DataAccessException e) {
		e.printStackTrace();
		request.setAttribute("message", "内部エラーが発生しました。");
		gotoPage(request, response, "/error.jsp");
	}

	}
}
