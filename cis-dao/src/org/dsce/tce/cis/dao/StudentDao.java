package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import java.util.List;

import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.Syllabus;

/**
 * 
 * @author CHETAN
 *
 */
public interface StudentDao {

	StudentDetails getStudentDetailsByUsn(String usn);

	MarksCard getMarksCardByUsnAndSemester(String usn, byte semester);

	void saveFeedback(Feedback feedbackReceived);

	List<Subject> getSubjectDetail() throws ClassNotFoundException, SQLException;

	List<Company> getCompaniesList() throws SQLException, ClassNotFoundException;

	List<Syllabus> getSyllabusDetails();

}
