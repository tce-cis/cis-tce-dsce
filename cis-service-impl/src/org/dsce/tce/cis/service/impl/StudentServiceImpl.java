package org.dsce.tce.cis.service.impl;

import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;
import org.dsce.tce.cis.dao.StudentDao;
import org.dsce.tce.cis.dao.impl.StudentDaoImpl;
import org.dsce.tce.cis.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	@Override
	public StudentDetails getStudentDetailsByUsn(String usn) {
		StudentDetails details = studentDao.getStudentDetailsByUsn(usn);
		return details;
	}

	@Override
	public MarksCard getMarksCardByUsnAndSemester(String usn, byte semester) {
		MarksCard card = studentDao.getMarksCardByUsnAndSemester(usn, semester);
		return card;
	}

	@Override
	public void saveFeedback(Feedback feedbackReceived) {
		studentDao.saveFeedback(feedbackReceived);
	}

}
