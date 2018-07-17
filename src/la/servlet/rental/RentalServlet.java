package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.servlet.BaseServlet;

public class RentalServlet extends BaseServlet {
	
	final protected int MAX_RENTAL_NUM = 5;

	protected void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
}
