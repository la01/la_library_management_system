package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.rental.Rental;
import la.dao.PostgreSQLRentalDao;
import la.exception.DataAccessException;

@WebServlet("/MemberIdSearch")
public class MemberIdSearchServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String memberId = request.getParameter("searchMemberId");
			// dao
			PostgreSQLRentalDao rentalDao = new PostgreSQLRentalDao();
			Rental rental = rentalDao.select(Integer.parseInt(memberId));

			request.setAttribute("rental", rental);
		} catch (DataAccessException e) {
			request.setAttribute("title", "検索に失敗しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
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

		request.setAttribute("mode", "返却");
		request.setAttribute("action", "return");

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}
}
