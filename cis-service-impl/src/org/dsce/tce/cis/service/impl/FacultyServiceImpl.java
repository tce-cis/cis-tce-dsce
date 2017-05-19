package org.dsce.tce.cis.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Research;
import org.dsce.tce.cis.dao.FacultyDao;
import org.dsce.tce.cis.dao.impl.FacultyDaoImpl;
import org.dsce.tce.cis.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

	private static Logger logger = Logger.getLogger(FacultyServiceImpl.class);
	private FacultyDao facultyDao;

	@Override
	public List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException {
		logger.debug("Fetching faculty details");
		facultyDao = new FacultyDaoImpl();
		List<Faculty> facultyList = facultyDao.getFacultyDetails();
		return facultyList;
	}

	@Override
	public List<Publication> getPublications() throws ClassNotFoundException, SQLException {
		logger.debug("Fetching publications details");
		facultyDao = new FacultyDaoImpl();
		List<Publication> publicationList = facultyDao.getPublications();
		return publicationList;
	}

	@Override
	public List<Research> getResearchDetails() throws ClassNotFoundException, SQLException {
		facultyDao = new FacultyDaoImpl();
		List<Research> researchList = facultyDao.getResearchDetails();
		return researchList;
	}

}
