package org.dsce.tce.cis.util;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;

public class JDBCUtil {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/cis_tce_dsce";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void persistFacultyData(List<Faculty> facultyList) {
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

			for (Faculty faculty : facultyList) {

				String sql = "INSERT INTO cis_tce_dsce.faculty ( full_name, designation, education_qualification, experience, specialization, email, phone) "
						+ "VALUES ('" + faculty.getName() + "', '" + faculty.getDesignation() + "','"
						+ faculty.getEducationalQualification() + "'," + Integer.parseInt(faculty.getExperienceYears())
						+ ",'" + faculty.getSpecialization() + "','" + faculty.getEmailId() + "',"
						+ faculty.getPhoneNumber() + "); ";
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
}// end JDBCExample