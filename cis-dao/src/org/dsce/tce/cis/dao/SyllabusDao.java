package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;

import org.dsce.tce.cis.bean.Syllabus;

public interface SyllabusDao {

	List<Syllabus> getSyllabusList() throws ClassNotFoundException, SQLException;

}
