package org.dsce.tce.cis.service.impl;

import org.dsce.tce.cis.bean.MarksCard;
import org.dsce.tce.cis.bean.StudentDetails;
import org.dsce.tce.cis.dao.StudentDao;
import org.dsce.tce.cis.dao.impl.SudentDaoImpl;
import org.dsce.tce.cis.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new SudentDaoImpl();
	}

	@Override
	public StudentDetails getStudentDetailsByUsn(String usn) {
		// TODO Namana
		StudentDetails details = studentDao.getStudentDetailsByUsn(usn);
		return details;
	}

	@Override
	public MarksCard getMarksCardByUsnAndSemester(String usn, byte semester) {
		// TODO Namana
		MarksCard card = studentDao.getMarksCardByUsnAndSemester(usn, semester);
		return card;
	}

}
