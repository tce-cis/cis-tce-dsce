package org.dsce.tce.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.service.StudentService;
import org.dsce.tce.cis.service.impl.StudentServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet for common functionalities
 * 
 * @author Asha R
 */
@WebServlet(urlPatterns = { "/subjects", "/companies" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(HomeServlet.class);

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
			if (req.getServletPath().contains("subjects")) {

				logger.debug("Fetching list of subjects.");
				List<Subject> subjectList = service.getSubjects();
				logger.debug("Found " + subjectList.size() + " subjects.");
				resp.setContentType("application/json");
				String subjectJson = new Gson().toJson(subjectList);
				resp.getWriter().write(subjectJson);

			} else if (req.getServletPath().contains("companies")) {

				logger.debug("Fetching list of companies.");
				List<Company> companyList = service.getCompaniesList();
				logger.debug("Found " + companyList.size() + " companies.");
				resp.setContentType("application/json");
				String companyJson = new Gson().toJson(companyList);
				resp.getWriter().write(companyJson);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
