package org.dsce.tce.cis.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Feedback;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;
import org.dsce.tce.cis.dao.StudentDao;
import org.dsce.tce.cis.dao.impl.StudentDaoImpl;
import org.dsce.tce.cis.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	@Override
	public List<SubjectScore> getResultsByUsn(String usn) {
		List<SubjectScore> results = studentDao.getResultsByUsn(usn);
		return results;
	}

	@Override
	public List<SubjectScore> getMarksCardByUsnAndSemester(String usn, byte semester) {
		List<SubjectScore> semesterResult = studentDao.getMarksCardByUsnAndSemester(usn, semester);
		return semesterResult;
	}

	@Override
	public void saveFeedback(Feedback feedbackReceived) {
		studentDao.saveFeedback(feedbackReceived);
	}

	@Override
	public List<Subject> getSubjects() throws ClassNotFoundException, SQLException {
		studentDao = new StudentDaoImpl();
		List<Subject> subjectlist = studentDao.getSubjects();
		return subjectlist;
	}

	@Override
	public List<Company> getCompaniesList() throws ClassNotFoundException, SQLException {
		studentDao = new StudentDaoImpl();
		List<Company> companylist = studentDao.getCompaniesList();
		return companylist;
	}

	@Override
	public List<SubjectUnit> getSubjectUnits() throws ClassNotFoundException, SQLException {
		List<SubjectUnit> syllabusList = studentDao.getSubjectUnits();
		return syllabusList;
	}

}
