package la.servlet.later;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.servlet.rental.RentalServlet;

@WebServlet("/Later")
public class LaterServlet extends RentalServlet {
	private static final long serialVersionUID = 1L;

	//TODO: ヘッダからのアクセス
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "WEB-INF/jsp/searchLater.jsp");
	}

	//TODO: 書類対応ボタン押下時印刷ページ表示
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "WEB-INF/jsp/laterPrint.jsp");
	}

}
