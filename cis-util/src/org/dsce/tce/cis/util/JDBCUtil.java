package org.dsce.tce.cis.util;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Research;
import org.dsce.tce.cis.bean.Student;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;
import org.dsce.tce.cis.common.CisConstants;

public class JDBCUtil {

	Connection dbConnection = null;
	Statement sqlStatement = null;

	public void persistFacultyData(List<Faculty> facultyList) {

		try {
			initDBConnections();
			facultyList.remove(0);
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
			publicationList.remove(0);
			for (Publication publication : publicationList) {
				String queryString = "INSERT INTO cis_tce_dsce.publication ( title, journal, primary_author, co_authors) "
						+ "VALUES ('" + publication.getTitle() + "', '" + publication.getJournal() + "','"
						+ publication.getPrimaryAuthor() + "','" + publication.getCoAuthors() + "');";
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

	public void persistSubjectList(List<Subject> SubjectsList) {
		try {
			initDBConnections();
			// Remove the header
			SubjectsList.remove(0);

			for (Subject subject : SubjectsList) {
				String sqlQueryString = "INSERT INTO cis_tce_dsce.Subject ( subjectName, code, iaMarks, examHours, hrsPerWeek, totalHrs, examMarks) "
						+ "VALUES ('" + subject.getName() + "', '" + subject.getCode() + "','"
						+ Integer.parseInt(subject.getIaMarks()) + "'," + Integer.parseInt(subject.getExamHours())
						+ ",'" + Integer.parseInt(subject.getHoursPerWeek()) + "','"
						+ Integer.parseInt(subject.getTotalHours()) + "'," + Integer.parseInt(subject.getExamMarks())
						+ "); ";
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

	public void persistSubjectUnitsData(List<SubjectUnit> subjectUnitsList) {
		try {

			initDBConnections();
			// remove header
			subjectUnitsList.remove(0);
			for (SubjectUnit unit : subjectUnitsList) {

				String queryString = "INSERT INTO cis_tce_dsce.subject_unit ( subject_code, part, unit, unit_title, Unit_Description, unit_Hours) "
						+ "VALUES ('" + unit.getSubjectCode() + "', '" + unit.getPart() + "','" + unit.getUnit() + "','"
						+ unit.getUnitTitle() + "','" + unit.getUnitDescription() + "','" + unit.getUnitHours() + "');";
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

	public void populateAuthenticatedUsers() {

		String[] queryList = new String[104];

		for (int i = 0; i < 9;) {
			queryList[i] = "INSERT INTO user (username, password) VALUES ('1DS13TE00" + ++i + "', '"
					+ PasswordHashingDemo.generateHash("1DS13TE00" + i) + "'); ";
		}

		for (int i = 9; i < 100;) {
			queryList[i] = "INSERT INTO user (username, password) VALUES ('1DS13TE0" + ++i + "', '"
					+ PasswordHashingDemo.generateHash("1DS13TE0" + i) + "'); ";
		}
		for (int i = 99; i < 104;) {
			queryList[i] = "INSERT INTO user (username, password) VALUES ('1DS13TE" + ++i + "', '"
					+ PasswordHashingDemo.generateHash("1DS13TE" + i) + "'); ";
		}

		for (String queryString : queryList) {
			System.out.println(queryString);
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
				stmt = conn.createStatement();
				stmt.executeUpdate(queryString);

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
		}

	}

	public void persistStudentMarks(List<Student> studentsList) {
		try {

			initDBConnections();
			// remove header
			studentsList.remove(0);
			for (Student student : studentsList) {
				for (SubjectScore score : student.getMarksCard()) {
					String queryString = "INSERT INTO cis_tce_dsce.results ( subject_code, semester_number, usn, internal_marks, external_marks) "
							+ "VALUES ('" + score.getSubjectCode() + "', '" + score.getSemesterNumber() + "','"
							+ student.getUsn() + "','" + score.getInternalMarks() + "','" + score.getExternalMarks()
							+ "');";
					sqlStatement.executeUpdate(queryString);
				}

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

	public void persistResearchData(List<Research> researchList) {

		try {
			initDBConnections();

			for (Research research : researchList) {
				String queryString = "INSERT INTO cis_tce_dsce.research ( title, description, pi_name_designation, co_pi_name_designation, "
						+ "funding_agency_amount, start_year_end_year) " + "VALUES ('" + research.getTitle() + "', '"
						+ research.getDescription() + "','" + research.getPiNameDesignation() + "','"
						+ research.getCoPiNameDesignation() + "','" + research.getFundingAgencyAndAmount() + "','"
						+ research.getStartYearEndYear() + "');";
				// System.out.println(queryString);
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

	public void persistCompanyData(List<Company> companyList) {

		try {
			initDBConnections();
			companyList.remove(0);
			for (Company company : companyList) {
				String queryString = "INSERT INTO cis_tce_dsce.company ( name, no_offers, ctc, type) " + "VALUES ('"
						+ company.getName() + "', '" + company.getNoOffers() + "','" + company.getCtc() + "','"
						+ company.getCompanyType() + "');";
				// System.out.println(queryString);
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
}
