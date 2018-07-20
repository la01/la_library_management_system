package la.servlet.rental;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;
import la.dao.PostgreSQLRentalDao;
import la.exception.DataAccessException;

@WebServlet("/DoneRental")
public class DoneRentalServlet extends RentalServlet {
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
			int memberId = Integer.parseInt(request.getParameter("memberId"));
			List<Integer> bookId = new ArrayList<Integer>();
			for(int i=0;i < MAX_RENTAL_NUM; i++) {
				String s_id = request.getParameter("bookId" + (i + 1));
				if(s_id != null && s_id.length() > 0) {
					bookId.add(Integer.parseInt(s_id));
				}
			}

			PostgreSQLRentalDao dao = new PostgreSQLRentalDao();
			if (action.equals("rental")) {
				int delayedRentalBookNum = dao.countDelayedRentalBookNum(memberId);
				if (delayedRentalBookNum > 0) {
					request.setAttribute("title", "貸出期限超過");
					request.setAttribute("body", "会員ID" + memberId + "：貸出期限を超過した資料が" + delayedRentalBookNum + "冊あります");
					forward(request, response, "Error");
					return;
				}

				int sumRentalBookNum = bookId.size() + dao.countRentalBookNum(memberId);
				if (sumRentalBookNum > MAX_RENTAL_NUM) {
					request.setAttribute("title", "貸出可能冊数超過");
					request.setAttribute("body", "会員ID" + memberId + "：貸出可能冊数を" + (sumRentalBookNum - MAX_RENTAL_NUM) + "冊超過します");
					forward(request, response, "Error");
					return;
				}

				for (int id : bookId) {
					dao.insert(memberId, id);
				}
			} else if(action.equals("return")) {
				for (int id : bookId) {
					dao.delete(memberId, id);
				}
			}
			request.setAttribute("memberId", memberId);
			request.setAttribute("bookId", bookId);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);

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

		forward(request, response, "WEB-INF/jsp/doneRental.jsp");
	}
}
