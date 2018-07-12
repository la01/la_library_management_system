package la.servlet.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.exception.DataAccessException;

@WebServlet("/DoneBook")
public class DoneBookServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String action = request.getParameter("action");
			String mode = request.getParameter("mode");
			
			//TODO: get request parameter
			
			//TODO: check validation
			
			//TODO: to bean
			
			//TODO: run SQL
			if(action.equals("insert")) {
				
			} else if(action.equals("update")) {
				
			} else if(action.equals("delete")) {
				
			} else {
				throw new DataAccessException("不正なパラメータです");
			}
			
			// set request attribute
			
		}catch(DataAccessException e) {
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
