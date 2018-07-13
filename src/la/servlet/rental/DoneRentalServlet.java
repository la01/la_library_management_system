package la.servlet.rental;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.PostgreSQLRentalDao;

@WebServlet("/DoneRental")
public class DoneRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_RENTAL_NUM = 5;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/doneRental.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			request.setAttribute("title", "不正な操作が実行されました");
			forward(request, response, "Error");
			return;
		}
		try {
			String strMemberId = request.getParameter("memberId");
			ArrayList<String> strBookId = new ArrayList<String>();
			for (int i = 0; i < MAX_RENTAL_NUM; i++) {
				String tmpBookId = request.getParameter("bookId" + (i + 1));
				if (tmpBookId != null && tmpBookId.length() > 0) {
					strBookId.add(tmpBookId);
				}
			}

			int memberId = Integer.parseInt(strMemberId);
			ArrayList<Integer> bookId = new ArrayList<Integer>();
			for(String str:strBookId) {
				bookId.add(Integer.parseInt(str));
			}

			//Rental rental = new Rental(memberId, bookId);
			PostgreSQLRentalDao dao = new PostgreSQLRentalDao();

			int delayedRentalBookNum = dao.countDelayedRentalBookNum(memberId);
			if(delayedRentalBookNum > 0) {
				request.setAttribute("title", "貸出期限超過");
				request.setAttribute("body", "貸出期限を超過した資料が" + delayedRentalBookNum + "冊あります");
				forward(request, response, "Error");
				return;
			}

			int sumRentalBookNum = bookId.size() + dao.countRentalBookNum(memberId);
			if (sumRentalBookNum > MAX_RENTAL_NUM) {
				request.setAttribute("title", "貸出可能冊数超過");
				request.setAttribute("body", "貸出可能冊数を" + (sumRentalBookNum - MAX_RENTAL_NUM) + "冊超過します");
				forward(request, response, "Error");
				return;
			}

			ArrayList<Integer> rentalId = new ArrayList<Integer>();
			for(int id: bookId) {
				rentalId.add(dao.insert(memberId, id));
			}

			request.setAttribute("memberId", memberId);
			request.setAttribute("bookId", bookId);
			request.setAttribute("rentalId", rentalId);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			forward(request, response, "WEB-INF/jsp/doneRental.jsp");
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



	}

}
