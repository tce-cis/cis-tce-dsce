package me.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/secure_page2")
public class Secure2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Secure2Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession userSession = request.getSession(false);
		if (userSession.getAttribute("loggedIn") != null) {
			response.getWriter().append("<br><br><a href=\"secure_page1\">Secure page1</a>  |  "
					+ "<a href=\"secure_page2\">Secure page2</a>   |  "
					+ "<a href=\"secure_page3\">Secure page3</a>   |  " + "<a href=\"logout\">Logout</a><br><br>");
			response.getWriter().append("<br><br>page 2 content");
		} else {
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
