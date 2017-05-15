package org.dsce.tce.cis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;
import org.dsce.tce.cis.common.CisConstants;
import org.dsce.tce.cis.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public StudentDetails getStudentDetailsByUsn(String usn) {
		// TODO Rushitha to add JDBC code
		return null;
	}

	@Override
	public MarksCard getMarksCardByUsnAndSemester(String usn, byte semester) {
		// TODO Rushitha to add JDBC code
		return null;
	}

	@Override
	public void saveFeedback(Feedback feedbackReceived) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER,
					CisConstants.PASS);
			Statement sqlStatement = dbConnection.createStatement();
			String queryString = "INSERT INTO cis_tce_dsce.feedback (availability, content_delivery, doubts_clarification, dress_code, "
					+ "evaluation, practical_aspect, regularity, syllabus_coverage, teaching, time_utilization) "
					+ "VALUES ('" + feedbackReceived.getAvailability() + "', '" + feedbackReceived.getContentDelivery()
					+ "','" + feedbackReceived.getDoubtsClarification() + "','" + feedbackReceived.getDressCode()
					+ "','" + feedbackReceived.getEvaluation() + "','" + feedbackReceived.getPracticalAspect() + "','"
					+ feedbackReceived.getRegularity() + "','" + feedbackReceived.getSyllabusCoverage() + "','"
					+ feedbackReceived.getTeaching() + "','" + feedbackReceived.getTimeUtilization() + "'); ";
			System.out.println(queryString);
			sqlStatement.executeUpdate(queryString);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
