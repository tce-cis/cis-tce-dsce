package me.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() != null && request.getSession().getAttribute("loggedIn") == null) {
			response.setContentType("text/html");
			response.getWriter()
					.append("<html><head></head><body>	<form name=\"loginForm\" method=\"post\" action=\"login\">		"
							+ "user name: <input type=\"text\" name=\"username\" /> <br /> "
							+ "password: <input			type=\"text\" name=\"password\" /> <br /> "
							+ "<input type=\"submit\"			value=\"Login\" />	</form></body></html>");
		} else {
			response.sendRedirect("secure_page1");
		}
	}

}
