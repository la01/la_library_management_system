package la.servlet.later;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.later.LaterRental;
import la.dao.PostgreSQLLaterDao;
import la.exception.DataAccessException;
import la.servlet.rental.RentalServlet;

@WebServlet("/Later")
public class LaterServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	//ヘッダからのアクセス
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			PostgreSQLLaterDao dao = new PostgreSQLLaterDao();
			List<LaterRental> list1 = dao.select10_30dayUserList();
			List<LaterRental> list2 = dao.select30dayUserList();

			request.setAttribute("tel_or_mail_list", list1);
			request.setAttribute("post_list", list2);

		} catch(DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("title", "データの操作に失敗しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("title", "予期せぬエラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}

		forward(request, response, "WEB-INF/jsp/searchLater.jsp");
	}

	//削除ボタン
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			int rentalId = Integer.parseInt(request.getParameter("rentalId"));
			System.out.println("rentalId" + rentalId);
			PostgreSQLLaterDao dao = new PostgreSQLLaterDao();
			dao.delete(rentalId);

		} catch(DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("title", "データの操作に失敗しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("title", "予期せぬエラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}

		doGet(request, response);
	}

}
