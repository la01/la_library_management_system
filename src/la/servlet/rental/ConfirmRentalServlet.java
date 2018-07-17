package la.servlet.rental;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.exception.DataAccessException;
import la.exception.LoginException;

@WebServlet("/ConfirmRental")
public class ConfirmRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			if(!loginCheck(request)) {
				throw new LoginException("access dinied.");
			}
			
			String mode = request.getParameter("mode");
			String action = request.getParameter("action");
			String memberId = request.getParameter("memberId");
			ArrayList<String> bookId = new ArrayList<String>();
			for (int i = 0; i < MAX_RENTAL_NUM; i++) {
				String tmpBookId = request.getParameter("bookId" + (i + 1));
				if (tmpBookId != null && tmpBookId.length() > 0) {
					bookId.add(tmpBookId);
				}
			}
			
			request.setAttribute("memberId", memberId);
			request.setAttribute("bookId", bookId);
			request.setAttribute("mode", mode);
			request.setAttribute("action", action);

		} catch(LoginException e) {
			e.printStackTrace();
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
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

		forward(request, response, "WEB-INF/jsp/confirmRental.jsp");
	}

}
