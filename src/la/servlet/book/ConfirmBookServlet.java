package la.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.book.Category;
import la.dao.PostgreSQLCategoryDao;
import la.exception.DataAccessException;
import la.exception.LoginException;

@WebServlet("/ConfirmBook")
public class ConfirmBookServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			if(!loginCheck(request)) {
				throw new LoginException("access dinied.");
			}

			// request parameterをattributeに詰め替える
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

			request.setAttribute("mode", mode);
			request.setAttribute("action", action);
			request.setAttribute("id", id);
			request.setAttribute("isbn", isbn);
			request.setAttribute("name", name);
			request.setAttribute("categoryCode", categoryCode);
			request.setAttribute("author", author);
			request.setAttribute("publisher", publisher);
			request.setAttribute("publishedDay", publishedDay);
			request.setAttribute("number", number);

			// get category name
			PostgreSQLCategoryDao dao = new PostgreSQLCategoryDao();
			List<Category> categoryList = dao.select();
			Category category = categoryList.stream()
					.filter(cat -> cat.getCategoryCode() == Integer.parseInt(categoryCode)).findFirst()
					.orElse(new Category());
			request.setAttribute("categoryName", category.getCategoryName());
			
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

		forward(request, response, "WEB-INF/jsp/confirmBook.jsp");
	}
}
