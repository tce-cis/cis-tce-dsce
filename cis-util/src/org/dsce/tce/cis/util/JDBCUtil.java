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

public class JDBCUtil {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/cis_tce_dsce";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void persistFacultyData(List<Faculty> facultyList) {
		Connection dbConnection = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.createStatement();

			for (Faculty faculty : facultyList) {

				String queryString = "INSERT INTO cis_tce_dsce.faculty ( full_name, designation, education_qualification, experience, specialization, email, phone) "
						+ "VALUES ('" + faculty.getName() + "', '" + faculty.getDesignation() + "','"
						+ faculty.getEducationalQualification() + "'," + Integer.parseInt(faculty.getExperienceYears())
						+ ",'" + faculty.getSpecialization() + "','" + faculty.getEmailId() + "',"
						+ faculty.getPhoneNumber() + "); ";
				System.out.println(queryString);
				// stmt.executeUpdate(queryString);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
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

	public static void persistPublicationData(List<Publication> publicationList) {
		Connection dbConnection = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.createStatement();
			for (Publication publication : publicationList) {

				String queryString = "INSERT INTO cis_tce_dsce.publication ( title, journal, primary_author, co_authors) "
						+ "VALUES ('" + publication.getTitle() + "', '" + publication.getJournal() + "','"
						+ publication.getPrimaryAuthor() + "','" + publication.getCoAuthors() + "');";
				System.out.println(queryString);
				// stmt.executeUpdate(queryString);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
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

	public static void persistSubjectList(List<Subject> SubjectDetail) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			for (Subject subject : SubjectDetail) {
				// {"name":"ENGINEERING MATHEMATICS –
				// III","code":"10MAT31","iaMarks":"25","examHours":"3","hoursPerWeek":"4","totalHours":"52","examMarks":"100"}
				String sql = "INSERT INTO cis_tce_dsce.Subject ( name, code, IA_marks, exam_hours, hours_per_week, total_hours, exam_marks) "
						+ "VALUES ('" + subject.getName() + "', '" + subject.getCode() + "','"
						+ Integer.parseInt(subject.getIaMarks()) + "'," + Integer.parseInt(subject.getExamHours())
						+ ",'" + Integer.parseInt(subject.getHoursPerWeek()) + "','"
						+ Integer.parseInt(subject.getTotalHours()) + "'," + Integer.parseInt(subject.getExamMarks())
						+ "); ";
				stmt.executeUpdate(sql);
			}
			System.out.println("Inserted records into the table...");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}