package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputRental")
public class InputRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = "rental";
		String mode = "貸出";

		request.setAttribute("mode", mode);
		request.setAttribute("action", action);

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

}
