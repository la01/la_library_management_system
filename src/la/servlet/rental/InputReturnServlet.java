package la.servlet.rental;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;
import la.bean.rental.Rental;
import la.dao.PostgreSQLRentalDao;
import la.exception.DataAccessException;

@WebServlet("/InputReturn")
public class InputReturnServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.staffCheck(request)) {
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}

		request.setAttribute("mode", "返却");
		request.setAttribute("action", "return");

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

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

			String memberId = request.getParameter("searchMemberId");
			Rental rental = null;
			if(memberId != null && memberId.length() != 0 && Pattern.matches("^[0-9]*$", memberId)) {
				// dao
				PostgreSQLRentalDao rentalDao = new PostgreSQLRentalDao();
				rental = rentalDao.select(Integer.parseInt(memberId));
			}

			request.setAttribute("rental", rental);
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

		request.setAttribute("mode", "返却");
		request.setAttribute("action", "return");

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}
}
