package org.dsce.tce.cis.service;

import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;

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
	 * @param usn
	 *            USN of the student
	 * @param semester
	 *            Semester number
	 * @return {@link MarksCard} containing semester results
	 */
	public MarksCard getMarksCardByUsnAndSemester(String usn, byte semester);

	// TODO Namana Add further required methods
}
