package org.dsce.tce.cis.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.dao.FacultyDao;
import org.dsce.tce.cis.dao.impl.FacultyDaoImpl;
import org.dsce.tce.cis.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

	private FacultyDao facultyDao;

	@Override
	public List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException {
		facultyDao = new FacultyDaoImpl();
		List<Faculty> facultyList = facultyDao.getFacultyDetails();
		return facultyList;
	}

	@Override
	public List<Publication> getPublications() throws ClassNotFoundException, SQLException {
		facultyDao = new FacultyDaoImpl();
		List<Publication> publicationList = facultyDao.getPublications();
		return publicationList;
	}

}
