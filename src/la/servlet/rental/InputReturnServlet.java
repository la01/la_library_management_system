package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputReturn")
public class InputReturnServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("mode", "返却");
		request.setAttribute("action", "return");

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("mode", "返却");
		request.setAttribute("action", "return");
		
		//TODO: try-catch
		//TODO: searchIdからRentalDao叩いてレンタル中の本のIDリストげt
		//TODO: request set
		
		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}
}
