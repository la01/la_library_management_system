package la.servlet.rental;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;
import la.bean.rental.RentalHistory;
import la.dao.PostgreSQLRentalDao;
import la.exception.DataAccessException;

@WebServlet("/SearchRental")
public class SearchRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.check(request)) {
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}
		
		forward(request, response, "WEB-INF/jsp/searchRental.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<RentalHistory> historyList = new ArrayList<RentalHistory>();

		try {
			LoginCheck loginCheck = new LoginCheck();
			if(!loginCheck.check(request)) {
				request.setAttribute("title", "ログインが必要なページです");
				request.setAttribute("body", "");
				forward(request, response, "Error");
				return;
			}
			
			// get parameter
			String memberId = request.getParameter("memberId");
			String bookId = request.getParameter("bookId");
			String isbn = request.getParameter("isbn");
			String name = request.getParameter("name");
			String fromDay = request.getParameter("fromDay");
			String toDay = request.getParameter("toDay");
			String s_later = request.getParameter("later");
			String s_noReturn = request.getParameter("noReturn");
			boolean later = s_later != null && s_later.length() != 0 ? true : false;
			boolean noReturn = s_noReturn != null && s_noReturn.length() != 0 ? true : false;
			
			// set parameter
			request.setAttribute("memberId", memberId);
			request.setAttribute("bookId", bookId);
			request.setAttribute("isbn", isbn);
			request.setAttribute("name", name);
			request.setAttribute("fromDay", fromDay);
			request.setAttribute("toDay", toDay);
			request.setAttribute("later", s_later);
			request.setAttribute("noReturn", s_noReturn);

			// create RentalHistory
			RentalHistory history = new RentalHistory();
			if(memberId != null && memberId.length() != 0) {
				history.setMemberId(Integer.parseInt(memberId));
			}
			if(bookId != null && bookId.length() != 0) {
				history.setBookId(Integer.parseInt(bookId));
			}
			history.setIsbn(isbn);
			history.setName(name);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(fromDay != null && fromDay.length() != 0) {
				history.setFromDay(sdf.parse(fromDay));
			}
			if(toDay != null && toDay.length() != 0) {
				history.setToDay(sdf.parse(toDay));
			}
			history.setLater(later);
			history.setNoReturn(noReturn);

			//dao
			PostgreSQLRentalDao dao = new PostgreSQLRentalDao();
			historyList = dao.selectByCondition(history);

		} catch(DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("title", "検索に失敗しました");
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

		// set request scope
		request.setAttribute("result", true);
		request.setAttribute("historyList", historyList);

		forward(request, response, "WEB-INF/jsp/searchRental.jsp");
	}

}
