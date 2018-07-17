package la.servlet.book;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
			// get parameter
			String bookId = request.getParameter("id");
			String ISBNCode = request.getParameter("isbn");
			String name = request.getParameter("name");
			String categoryCode = request.getParameter("category");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String rental = request.getParameter("rental");
			String fromPublishDate = request.getParameter("from_publish_date");
			String toPublishDate = request.getParameter("to_publish_date");
			String status = request.getParameter("status");
			String fromAddedDate = request.getParameter("from_added_date");
			String toAddedDate = request.getParameter("to_added_date");
			String fromRemovedDate = request.getParameter("from_removed_date");
			String toRemovedDate = request.getParameter("to_removed_date");
			
			// set parameter for input form
			request.setAttribute("id", bookId);
			request.setAttribute("isbn", ISBNCode);
			request.setAttribute("name", name);
			request.setAttribute("categoryCode", categoryCode);
			request.setAttribute("author", author);
			request.setAttribute("publisher", publisher);
			request.setAttribute("rental", rental);
			request.setAttribute("from_publish_date", fromPublishDate);
			request.setAttribute("to_publish_date", toPublishDate);
			request.setAttribute("status", status);
			request.setAttribute("from_added_date", fromAddedDate);
			request.setAttribute("to_added_date", toAddedDate);
			request.setAttribute("from_removed_date", fromRemovedDate);
			request.setAttribute("to_removed_date", toRemovedDate);

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
			book.setRentalCode(rental);
			book.setStatusCode(status);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(fromPublishDate != null && fromPublishDate.length() != 0) {
				book.setFromPublishDate(sdf.parse(fromPublishDate));
			}
			if(toPublishDate != null && toPublishDate.length() != 0) {
				book.setToPublishDate(sdf.parse(toPublishDate));
			}
			if(fromAddedDate != null && fromAddedDate.length() != 0) {
				book.setFromAddedDate(sdf.parse(fromAddedDate));
			}
			if(toAddedDate != null && toAddedDate.length() != 0) {
				book.setToAddedDate(sdf.parse(toAddedDate));
			}
			if(fromRemovedDate != null && fromRemovedDate.length() != 0) {
				book.setFromRemovedDate(sdf.parse(fromRemovedDate));
			}
			if(toRemovedDate != null && toRemovedDate.length() != 0) {
				book.setToRemovedDate(sdf.parse(toRemovedDate));
			}

			// dao
			PostgreSQLBookDao dao = new PostgreSQLBookDao();
			bookList = dao.selectByCondition(book);

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
		request.setAttribute("result", true);
		request.setAttribute("bookList", bookList);
		request.setAttribute("categoryList", categoryList);

		forward(request, response, "WEB-INF/jsp/searchBook.jsp");
	}

}
