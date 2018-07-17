package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.exception.LoginException;

@WebServlet("/InputRental")
public class InputRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(!loginCheck(request)) {
				throw new LoginException("access dinied.");
			}
		} catch(LoginException e) {
			e.printStackTrace();
			request.setAttribute("title", "ログインが必要なページです");
			request.setAttribute("body", "");
			forward(request, response, "Error");
			return;
		}
		
		request.setAttribute("mode", "貸出");
		request.setAttribute("action", "rental");

		forward(request, response, "WEB-INF/jsp/inputRental.jsp");
	}
}
