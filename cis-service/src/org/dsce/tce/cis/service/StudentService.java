package org.dsce.tce.cis.service;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;;

/**
 * Service interface for student functionalities
 * 
 * @author Chetan Gorkal
 *
 */
public interface StudentService {

	/**
	 * Method to obtain results of a student by USN
	 * 
	 * @param usn
	 *            USN of the student
	 * @return List<SubjectScore> results of the student
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SubjectScore> getResultsByUsn(String usn) throws ClassNotFoundException, SQLException;

	/**
	 * Method to obtain marks card of a student by semester and usn
	 * 
	 * @param usn
	 *            USN of the student
	 * @param semester
	 *            Semester number
	 * @return {@link SubjectScore} containing semester results
	 */
	@Deprecated
	public List<SubjectScore> getMarksCardByUsnAndSemester(String usn, byte semester);

	/**
	 * Method to save feedback submitted by a student.
	 * 
	 * @param feedbackReceived
	 *            {@link Feedback} instance containing feedback data submitted
	 *            by the logged in user.
	 */
	public void saveFeedback(Feedback feedbackReceived);

	/**
	 * Method to get subjects being taught in the department
	 * 
	 * @author Ankitha Venkatesh
	 * @return {@link List} of {@link Subject} giving list of subjects
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Subject> getSubjects() throws ClassNotFoundException, SQLException;

	/**
	 * Method to obtain syllabus of subjects
	 * 
	 * @return List<SubjectUnit>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<SubjectUnit> getSubjectUnits() throws ClassNotFoundException, SQLException;

	/**
	 * Method to obtain list of companies visiting campus for recruitment
	 * 
	 * @return List<Company>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Company> getCompaniesList() throws ClassNotFoundException, SQLException;

}
