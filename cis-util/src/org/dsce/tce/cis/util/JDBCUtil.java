package org.dsce.tce.cis.util;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.common.CisConstants;

public class JDBCUtil {

	Connection dbConnection = null;
	Statement sqlStatement = null;

	public void persistFacultyData(List<Faculty> facultyList) {

		try {
			initDBConnections();

			for (Faculty faculty : facultyList) {
				String queryString = "INSERT INTO cis_tce_dsce.faculty ( full_name, designation, education_qualification, experience, specialization, email, phone) "
						+ "VALUES ('" + faculty.getName() + "', '" + faculty.getDesignation() + "','"
						+ faculty.getEducationalQualification() + "'," + Integer.parseInt(faculty.getExperienceYears())
						+ ",'" + faculty.getSpecialization() + "','" + faculty.getEmailId() + "',"
						+ faculty.getPhoneNumber() + "); ";
				// System.out.println(queryString);
				// sqlStatement.executeUpdate(queryString);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sqlStatement != null)
					dbConnection.close();
			} catch (SQLException se) {
			}
			try {
				if (dbConnection != null)
					dbConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	private void initDBConnections() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		sqlStatement = dbConnection.createStatement();
	}

	public void persistPublicationData(List<Publication> publicationList) {
		try {
			initDBConnections();
			for (Publication publication : publicationList) {
				String queryString = "INSERT INTO cis_tce_dsce.publication ( title, journal, primary_author, co_authors) "
						+ "VALUES ('" + publication.getTitle() + "', '" + publication.getJournal() + "','"
						+ publication.getPrimaryAuthor() + "','" + publication.getCoAuthors() + "');";
				// System.out.println(queryString);
				// stmt.executeUpdate(queryString);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sqlStatement != null)
					dbConnection.close();
			} catch (SQLException se) {
			}
			try {
				if (dbConnection != null)
					dbConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void persistSubjectList(List<Subject> SubjectDetail) {
		try {
			initDBConnections();
			for (Subject subject : SubjectDetail) {
				String sqlQueryString = "INSERT INTO cis_tce_dsce.Subject ( name, code, IA_marks, exam_hours, hours_per_week, total_hours, exam_marks) "
						+ "VALUES ('" + subject.getName() + "', '" + subject.getCode() + "','"
						+ Integer.parseInt(subject.getIaMarks()) + "'," + Integer.parseInt(subject.getExamHours())
						+ ",'" + Integer.parseInt(subject.getHoursPerWeek()) + "','"
						+ Integer.parseInt(subject.getTotalHours()) + "'," + Integer.parseInt(subject.getExamMarks())
						+ "); ";
				// System.out.println(sqlQueryString);
				// stmt.executeUpdate(sqlQueryString);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sqlStatement != null)
					dbConnection.close();
			} catch (SQLException se) {
			}
			try {
				if (dbConnection != null)
					dbConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}