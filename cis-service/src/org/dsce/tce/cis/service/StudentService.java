package org.dsce.tce.cis.service;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;;

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
	 */
	public void saveFeedback(Feedback feedbackReceived);

	public List<Subject> getSubjects() throws ClassNotFoundException, SQLException;

	List<SubjectUnit> getSubjectUnits() throws ClassNotFoundException, SQLException;

	public List<Company> getCompaniesList() throws ClassNotFoundException, SQLException;

}
