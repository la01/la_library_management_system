package la.servlet.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.book.Category;
import la.dao.PostgreSQLCategoryDao;
import la.exception.DataAccessException;

@WebServlet("/InputBook")
public class InputBookServlet extends BookServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
		request.setAttribute("mode", "登録");
		request.setAttribute("action", "insert");
		request.setAttribute("categoryList", categoryList);
		
		forward(request, response, "WEB-INF/jsp/inputBook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Category> categoryList = new ArrayList<Category>();
		
		try {
			// request parameterをattributeに詰め替える
			String id = request.getParameter("id");
			String isbn = request.getParameter("isbn");
			String name = request.getParameter("name");
			String categoryName = request.getParameter("categoryName");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publishedDay = request.getParameter("publishedDay");
			
			request.setAttribute("id", id);
			request.setAttribute("isbn", isbn);
			request.setAttribute("name", name);
			request.setAttribute("categoryName", categoryName);
			request.setAttribute("author", author);
			request.setAttribute("publisher", publisher);
			request.setAttribute("publishedDay", publishedDay);
			
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
		
		request.setAttribute("mode", "更新");
		request.setAttribute("action", "update");
		request.setAttribute("categoryList", categoryList);
		
		forward(request, response, "WEB-INF/jsp/inputBook.jsp");
	}
}
