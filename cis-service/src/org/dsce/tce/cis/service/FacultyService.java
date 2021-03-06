package org.dsce.tce.cis.service;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Research;

public interface FacultyService {

	public List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException;

	public List<Publication> getPublications() throws ClassNotFoundException, SQLException;
	public List<Research> getResearchDetails() throws ClassNotFoundException, SQLException;

}
