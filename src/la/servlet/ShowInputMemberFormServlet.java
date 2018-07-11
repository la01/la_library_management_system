package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.servet.member.MemberServlet;

/**
 * Servlet implementation class ShowInputMemberFormServlet
 */
@WebServlet("/ShowInputMemberFormServlet")
public class ShowInputMemberFormServlet extends MemberServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "/InputMember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "変更");
		forward(request, response, "/InputMember.jsp");
	}

}
