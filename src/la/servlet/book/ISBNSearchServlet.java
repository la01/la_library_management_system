package la.servlet.book;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.book.BookInfo;
import la.bean.book.Category;
import la.dao.PostgreSQLCategoryDao;
import la.dao.PostgreSQLISBNDao;
import la.exception.DataAccessException;

@WebServlet("/ISBNSearch")
public class ISBNSearchServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Category> categoryList = new ArrayList<Category>();
		
		try {
			String isbn = request.getParameter("searchISBN");
			
			// dao
			PostgreSQLISBNDao isbnDao = new PostgreSQLISBNDao();
			BookInfo bookInfo = isbnDao.select(isbn);
			
			// set
			String name = bookInfo.getName();
			String categoryName = bookInfo.getCategoryName();
			String author = bookInfo.getAuthor();
			String publisher = bookInfo.getPublisher();
			Date publishDay = bookInfo.getPublishedDay();
			String publishedDay = publishDay == null ? "" : publishDay.toString();
			
			request.setAttribute("isbn", isbn);
			request.setAttribute("name", name);
			request.setAttribute("categoryName", categoryName);
			request.setAttribute("author", author);
			request.setAttribute("publisher", publisher);
			request.setAttribute("publishedDay", publishedDay);
			
			// get category list
			PostgreSQLCategoryDao categoryDao = new PostgreSQLCategoryDao();
			categoryList = categoryDao.select();
			
		} catch(DataAccessException e) {
			request.setAttribute("title", "検索に失敗しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(NullPointerException e) {
			request.setAttribute("title", "予期せぬエラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		} catch(Exception e) {
			request.setAttribute("title", "内部エラーが発生しました");
			request.setAttribute("body", e);
			forward(request, response, "Error");
			return;
		}
		
		request.setAttribute("mode", "登録");
		request.setAttribute("action", "insert");
		request.setAttribute("categoryList", categoryList);
		
		forward(request, response, "WEB-INF/jsp/inputBook.jsp");
	}

}
