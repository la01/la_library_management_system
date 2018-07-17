package la.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {

	protected void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
}
