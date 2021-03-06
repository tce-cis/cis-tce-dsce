package org.dsce.tce.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dsce.tce.cis.bean.User;
import org.dsce.tce.cis.service.LoginService;
import org.dsce.tce.cis.service.impl.LoginServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet for user login and logout
 * 
 * @author Chetan Gorkal
 *
 */
@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getServletPath();
		if (requestUrl.contains("login")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String loginJson = br.readLine();
			User user = new Gson().fromJson(loginJson, User.class);
			LoginService loginService = new LoginServiceImpl();
			boolean isAuthorized = loginService.authenticateUser(user);
			if (isAuthorized) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUser", user.getUsername());
				response.addCookie(new Cookie("userName", user.getUsername()));
			}
		} else if (requestUrl.contains("logout")) {
			request.getSession().invalidate();
			Cookie userNameCookie = new Cookie("userName", "");
			userNameCookie.setMaxAge(0);
			response.addCookie(userNameCookie);
		}
	}

}
