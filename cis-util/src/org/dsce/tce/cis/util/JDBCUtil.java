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
import org.dsce.tce.cis.bean.Syllabus;
import org.dsce.tce.cis.common.CisConstants;

public class JDBCUtil {

	Connection dbConnection = null;
	Statement sqlStatement = null;

	public void persistFacultyData(List<Faculty> facultyList) {

		try {
			initDBConnections();

			for (Faculty faculty : facultyList) {
				String queryString = "INSERT INTO cis_tce_dsce.faculty ( full_name, designation, education_qualification, experience, specialization, email, phone, salutation) "
						+ "VALUES ('" + faculty.getName() + "', '" + faculty.getDesignation() + "','"
						+ faculty.getEducationalQualification() + "'," + Integer.parseInt(faculty.getExperienceYears())
						+ ",'" + faculty.getSpecialization() + "','" + faculty.getEmailId() + "',"
						+ faculty.getPhoneNumber() + ",'" + faculty.getSalutation() + "'); ";
				System.out.println(queryString);
				sqlStatement.executeUpdate(queryString);
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
				String sqlQueryString = "INSERT INTO cis_tce_dsce.Subject ( subjectName, code, iaMarks, examHours, hrsPerWeek, totalHrs, examMarks) "
						+ "VALUES ('" + subject.getName() + "', '" + subject.getCode() + "','"
						+ Integer.parseInt(subject.getIaMarks()) + "'," + Integer.parseInt(subject.getExamHours())
						+ ",'" + Integer.parseInt(subject.getHoursPerWeek()) + "','"
						+ Integer.parseInt(subject.getTotalHours()) + "'," + Integer.parseInt(subject.getExamMarks())
						+ "); ";
				// System.out.println(sqlQueryString);
				sqlStatement.executeUpdate(sqlQueryString);
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

	/////
	public class JDBCUtilSyllabus {
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/cis_tce_dsce";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "";

		public void persistSyllabusData(List<Syllabus> syllabusList, Object syllabusList1) {
			Connection conn = null;
			Statement stmt = null;
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");

				// STEP 4: Execute a query
				System.out.println("Inserting records into the table...");
				stmt = conn.createStatement();

				for (Syllabus syllabus : syllabusList) {

					String sql = "INSERT INTO cis_tce_dsce.syllabus ( subjectCode, part, unit, unitTitle, UnitDiscription, unitHours) "
							+ "VALUES ('" + syllabus.getName() + "', '" + syllabus.getpart() + "','"
							+ syllabus.getunit() + "'," + Integer.parseInt(syllabus.getunitTitle()) + ",'"
							+ syllabus.getUnitDescription() + "','" + syllabus.getunitHours() + "',";

					stmt.executeUpdate(sql);
				}
				System.out.println("Inserted records into the table...");

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						conn.close();
				} catch (SQLException se) {
				} // do nothing
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}// end main
	}
}