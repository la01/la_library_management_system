package la.servlet.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.LoginCheck;

@WebServlet("/InputRental")
public class InputRentalServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginCheck loginCheck = new LoginCheck();
		if(!loginCheck.staffCheck(request)) {
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
