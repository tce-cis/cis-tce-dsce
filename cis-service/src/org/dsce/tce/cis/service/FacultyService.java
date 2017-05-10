package org.dsce.tce.cis.service;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;

public interface FacultyService {

	public List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException;

}
