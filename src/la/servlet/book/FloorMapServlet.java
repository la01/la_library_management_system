package la.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FloorMapServlet
 */
@WebServlet("/FloorMap")
public class FloorMapServlet extends BookServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "WEB-INF/jsp/confirmBook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String categoryCode = request.getParameter("categoryCode");

		String imgSource = "./image/floormap" + categoryCode + ".gif";

		request.setAttribute("imgSource", imgSource);
		forward(request, response, "WEB-INF/jsp/floorMap.jsp");
	}

}
