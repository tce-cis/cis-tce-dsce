package org.dsce.tce.cis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;

public class JDBCUtil {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/cis_tce_dsce";

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
}