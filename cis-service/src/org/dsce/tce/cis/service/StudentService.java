package org.dsce.tce.cis.service;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;
import org.dsce.tce.cis.bean.Subject;

public interface StudentService {

	/**
	 * Method to obtain personal details of a student by USN
	 * 
	 * @param usn
	 *            USN of the student
	 * @return StudentDetails holding personal details of the student
	 */
	public StudentDetails getStudentDetailsByUsn(String usn);

	/**
	 * Method to obtain marks card of a student by semester and usn
	 * 
	 * @param usn```
	 *            USN of the student
	 * @param semester
	 *            Semester number
	 * @return {@link MarksCard} containing semester results
	 */
	public MarksCard getMarksCardByUsnAndSemester(String usn, byte semester);

	/**
	 * Method to save feedback submitted by a student.
	 * 
	 * @param feedbackReceived
	 */
	public void saveFeedback(Feedback feedbackReceived);

	public List<Subject> getSubjectDetail() throws ClassNotFoundException, SQLException;

}
