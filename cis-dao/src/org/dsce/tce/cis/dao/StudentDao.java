package org.dsce.tce.cis.dao;

import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;

/**
 * 
 * @author CHETAN
 *
 */
public interface StudentDao {

	StudentDetails getStudentDetailsByUsn(String usn);

	MarksCard getMarksCardByUsnAndSemester(String usn, byte semester);

}
