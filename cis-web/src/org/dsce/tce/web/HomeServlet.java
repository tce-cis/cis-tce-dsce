package org.dsce.tce.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.service.StudentService;
import org.dsce.tce.cis.service.impl.StudentServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet for common functionalities
 * 
 * @author Asha R
 */
@WebServlet(urlPatterns = { "/subjects" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		try {
			List<Subject> subjectList = service.getSubjectDetail();
			resp.setContentType("application/json");
			String subjectJson = new Gson().toJson(subjectList);
			resp.getWriter().write(subjectJson);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
