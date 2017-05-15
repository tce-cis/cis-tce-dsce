package org.dsce.tce.cis.dao;

import java.sql.SQLException;
import java.util.List;




public interface SyllabusDao<Syllabus> {
	
	
	  List<Syllabus> getSyllabusList() throws ClassNotFoundException, SQLException ;
			

}

