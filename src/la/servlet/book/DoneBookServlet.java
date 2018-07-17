package la.servlet.book;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.book.Book;
import la.dao.PostgreSQLBookDao;
import la.exception.DataAccessException;
import la.exception.LoginException;

@WebServlet("/DoneBook")
public class DoneBookServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			if(!loginCheck(request)) {
				throw new LoginException("access dinied.");
			}

			// get request parameter
			String action = request.getParameter("action");
			String mode = request.getParameter("mode");
			String id = request.getParameter("id");
			String isbn = request.getParameter("isbn");
			String name = request.getParameter("name");
			String categoryCode = request.getParameter("categoryCode");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publishedDay = request.getParameter("publishedDay");
			String number = request.getParameter("number");

			// SQL
			Book book = new Book();
			PostgreSQLBookDao dao = new PostgreSQLBookDao();
			boolean result = false;
			if(action.equals("insert")) {
				// set parameter
				book.setISBNCode(isbn);
				book.setName(name);
				book.setCategoryCode(Integer.parseInt(categoryCode));
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setPublishedDay(Date.valueOf(publishedDay));

				List<Integer> list = dao.insert(book, Integer.parseInt(number));
				request.setAttribute("id", list);
				result = true;
			} else if(action.equals("update")) {
				// set parameter
				book.setId(Integer.parseInt(id));
				book.setISBNCode(isbn);
				book.setName(name);
				book.setCategoryCode(Integer.parseInt(categoryCode));
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setPublishedDay(Date.valueOf(publishedDay));

				result = dao.update(book);
				request.setAttribute("id",  Arrays.asList(id));
			} else if(action.equals("delete")) {
				result = dao.delete(Integer.parseInt(id));
				request.setAttribute("id",  Arrays.asList(id));
			} else {
				throw new DataAccessException("不正なパラメータです");
			}

			// set request attribute
			request.setAttribute("action", action);
			request.setAttribute("mode", mode);
			request.setAttribute("name", name);
			request.setAttribute("result", result);

		} catch(LoginException e) {
			e.printStackTrace();
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
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

		forward(request, response, "WEB-INF/jsp/doneBook.jsp");
	}

}
