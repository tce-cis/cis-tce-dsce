package org.dsce.tce.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.SubjectUnit;
import org.dsce.tce.cis.service.StudentService;
import org.dsce.tce.cis.service.impl.StudentServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet for student functionalities
 * 
 * @author Chetan Gorkal
 */
@WebServlet(urlPatterns = { "/feedback", "/syllabus" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Syllabus
			StudentService studentService = new StudentServiceImpl();
			resp.setContentType("application/json");
			List<SubjectUnit> syllabusList;
			syllabusList = studentService.getSubjectUnits();
			String syllabusJson = new Gson().toJson(syllabusList);
			resp.getWriter().write(syllabusJson);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Feedback
		StudentService studentService = new StudentServiceImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String feedbackJson = br.readLine();
		Feedback feedbackReceived = new Gson().fromJson(feedbackJson, Feedback.class);
		studentService.saveFeedback(feedbackReceived);
	}

}
