package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputReturn")
public class InputReturnServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = "return";
		String mode = "返却";

		request.setAttribute("mode", mode);
		request.setAttribute("action", action);

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

}
