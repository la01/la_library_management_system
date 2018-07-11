package la.servet.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.book.Book;
import la.bean.book.Category;
import la.dao.PostgreSQLBookDao;
import la.dao.PostgreSQLCategoryDao;
import la.exception.DataAccessException;

@WebServlet("/SearchBook")
public class SearchBookServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Category> categoryList = new ArrayList<Category>();

		try {
			// get category list
			PostgreSQLCategoryDao dao = new PostgreSQLCategoryDao();
			categoryList = dao.select();

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

		//set request scope
		request.setAttribute("categoryList", categoryList);

		request.getRequestDispatcher("WEB-INF/jsp/searchBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Book> bookList = new ArrayList<Book>();
		List<Category> categoryList = new ArrayList<Category>();

		try {
			// get post request parameter
			// search action is not validate parameter
			String bookId = request.getParameter("id");
			String ISBNCode = request.getParameter("isbn");
			String name = request.getParameter("name");
			String categoryCode = request.getParameter("category");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");

			// set parameter for input form
			request.setAttribute("id", bookId);
			request.setAttribute("isbn", ISBNCode);
			request.setAttribute("name", name);
			request.setAttribute("categoryCode", categoryCode);
			request.setAttribute("author", author);
			request.setAttribute("publisher", publisher);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);

			// create book
			Book book = new Book();
			if(bookId != null && bookId.length() != 0) {
				book.setId(Integer.parseInt(bookId));
			}
			book.setISBNCode(ISBNCode);
			book.setName(name);
			book.setAuthor(author);
			book.setCategoryCode(Integer.parseInt(categoryCode));
			book.setPublisher(publisher);

			// dao
			PostgreSQLBookDao dao = new PostgreSQLBookDao();
			bookList = dao.selectByCondition(book);
			System.out.println("bookList length:" + bookList.size());

			PostgreSQLCategoryDao categoryDao = new PostgreSQLCategoryDao();
			categoryList = categoryDao.select();

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
		request.setAttribute("bookList", bookList);
		request.setAttribute("categoryList", categoryList);

		forward(request, response, "WEB-INF/jsp/searchBook.jsp");
	}

}
