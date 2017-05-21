package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;

/**
 * 
 * @author CHETAN
 *
 */
public interface StudentDao {

	void saveFeedback(Feedback feedbackReceived);

	/**
	 * Method to obtain list of subjects taught in the department from DB.
	 * 
	 * @return {@link List} of {@link Subject} <br>
	 *         List of subjects taught in the department.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Subject> getSubjects() throws ClassNotFoundException, SQLException;

	/**
	 * Method to get list of companies associated with recruitment
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<Company> getCompaniesList() throws SQLException, ClassNotFoundException;

	/**
	 * Method to obtain syllabus of subjects taught in the department
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<SubjectUnit> getSubjectUnits() throws ClassNotFoundException, SQLException;

	List<SubjectScore> getResultsByUsn(String usn) throws ClassNotFoundException, SQLException;

	List<SubjectScore> getMarksCardByUsnAndSemester(String usn, byte semester);

}
