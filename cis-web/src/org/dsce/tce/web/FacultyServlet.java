package org.dsce.tce.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.service.FacultyService;
import org.dsce.tce.cis.service.impl.FacultyServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet for faculty functionalities
 * 
 * @author Chetan Gorkal
 */
@WebServlet(urlPatterns = { "/faculty", "/publication" })
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FacultyService facultyService;

	/**
	 * Default constructor.
	 */
	public FacultyServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getServletPath();
		facultyService = new FacultyServiceImpl();
		try {

			if (requestUrl.contains("faculty")) {
				// get faculty of the department.
				List<Faculty> facultyList = facultyService.getFacultyDetails();
				response.setContentType("application/json");
				String facultyJson = new Gson().toJson(facultyList);
				response.getWriter().write(facultyJson);
			} else if (requestUrl.contains("publication")) {
				// get publications of the faculty and students
				List<Publication> publicationList = facultyService.getPublications();
				response.setContentType("application/json");
				String publicationJson = new Gson().toJson(publicationList);
				response.getWriter().write(publicationJson);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
