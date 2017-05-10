package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;

public interface FacultyDao {

	List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException;

}
