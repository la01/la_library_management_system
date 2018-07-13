package la.servlet.rental;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ValidationErrors;
import la.bean.rental.InputRentalForm;

@WebServlet("/ConfirmRental")
public class ConfirmRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;
	public static final int MAX_RENTAL_NUM = 5;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/confirmRental.jsp").forward(request, response);
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

		String memberId = request.getParameter("memberId");
		ArrayList<String> bookId = new ArrayList<String>();
		for (int i = 0; i < MAX_RENTAL_NUM; i++) {
			String tmpBookId = request.getParameter("bookId" + (i + 1));
			if (tmpBookId != null && tmpBookId.length() > 0) {
				bookId.add(tmpBookId);
			}
		}

		InputRentalForm rentalForm = new InputRentalForm(memberId, bookId);
		ValidationErrors errors = rentalForm.validate();

		if (errors.getSize() != 0) {
			request.setAttribute("title", "入力フォームエラー");
			request.setAttribute("body", errors);
			forward(request, response, "Error");
		}

		request.setAttribute("memberId", memberId);
		request.setAttribute("bookId", bookId);
		request.setAttribute("mode", mode);
		request.setAttribute("action", action);
		forward(request, response, "WEB-INF/jsp/confirmRental.jsp");
	}

}
