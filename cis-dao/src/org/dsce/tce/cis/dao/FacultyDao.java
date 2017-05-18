package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Research;

public interface FacultyDao {

	List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException;

	List<Publication> getPublications() throws SQLException, ClassNotFoundException;
	List<Research> getResearchDetails() throws ClassNotFoundException, SQLException;

}
