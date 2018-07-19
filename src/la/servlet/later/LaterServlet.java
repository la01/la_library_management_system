package la.servlet.later;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.later.LaterBook;
import la.bean.later.LaterRental;
import la.dao.PostgreSQLLaterDao;
import la.exception.DataAccessException;
import la.servlet.rental.RentalServlet;

@WebServlet("/Later")
public class LaterServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	//TODO: ヘッダからのアクセス
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

	//TODO: 書類対応ボタン押下時印刷ページ表示
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			// requestを詰め替え
			request.setAttribute("familyName", request.getParameter("familyName"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("date",
					new SimpleDateFormat("yyyy年MM月dd日").format(Calendar.getInstance().getTime()));

			List<LaterBook> list = new ArrayList<LaterBook>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i = 0; i<5;i++) {
				String bookName = request.getParameter("bookName" + i);
				if(bookName != null && bookName.length() != 0) {
					Date rentalDate = sdf.parse(request.getParameter("bookRental" + i));
					Date returnDate = sdf.parse(request.getParameter("bookReturn" + i));

					LaterBook lb = new LaterBook();
					lb.setName(bookName);
					lb.setRentalDate(rentalDate);
					lb.setReturnDate(returnDate);
					list.add(lb);
				}
			}
			request.setAttribute("books", list);

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

		forward(request, response, "WEB-INF/jsp/laterPrint.jsp");
	}

}
