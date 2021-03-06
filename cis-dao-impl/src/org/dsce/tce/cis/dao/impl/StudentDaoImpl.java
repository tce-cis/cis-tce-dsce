package org.dsce.tce.cis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;
import org.dsce.tce.cis.common.CisConstants;
import org.dsce.tce.cis.dao.StudentDao;

/**
 * DAO implementation for Student services
 * 
 * @author Chetan Gorkal
 *
 */
public class StudentDaoImpl implements StudentDao {

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

	@Override
	public List<Subject> getSubjects() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM Subject");
		List<Subject> subjectlist = new ArrayList<>();
		while (rs.next()) {
			Subject subject = new Subject(rs.getString("subjectName"), rs.getString("code"), rs.getString("iaMarks"),
					rs.getString("examHours"), rs.getString("hrsPerWeek"), rs.getString("totalHrs"),
					rs.getString("examMarks"));
			subjectlist.add(subject);
		}
		return subjectlist;

	}

	@Override
	public List<Company> getCompaniesList() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM Company");
		List<Company> companylist = new ArrayList<>();
		while (rs.next()) {
			Company company = new Company(rs.getString("name"), Integer.parseInt(rs.getString("no_offers")),
					Float.parseFloat(rs.getString("ctc")), rs.getString("type"));
			companylist.add(company);
		}
		return companylist;

	}

	@Override
	public List<SubjectUnit> getSubjectUnits() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM cis_tce_dsce.subject_unit");
		List<SubjectUnit> subjectUnitList = new ArrayList<>();

		while (rs.next()) {

			SubjectUnit subjectUnit = new SubjectUnit(rs.getString("subject_code"), rs.getString("part"),
					rs.getString("unit"), rs.getString("unit_title"), rs.getString("unit_description"),
					rs.getString("unit_hours"));
			subjectUnitList.add(subjectUnit);
		}

		while (rs.next()) {
			SubjectUnit syllabus = new SubjectUnit();
			subjectUnitList.add(syllabus);
		}
		return subjectUnitList;
	}

	@Override
	public List<SubjectScore> getResultsByUsn(String usn) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM cis_tce_dsce.results where usn='" + usn + "';");
		List<SubjectScore> subjectScoreList = new ArrayList<>();

		while (rs.next()) {

			SubjectScore subjectScore = new SubjectScore(rs.getString("subject_code"), rs.getString("semester_number"),
					rs.getString("internal_marks"), rs.getString("external_marks"));
			subjectScoreList.add(subjectScore);
		}
		return subjectScoreList;
	}

	@Override
	public List<SubjectScore> getMarksCardByUsnAndSemester(String usn, byte semester) {
		// TODO Auto-generated method stub
		return null;
	}

}
