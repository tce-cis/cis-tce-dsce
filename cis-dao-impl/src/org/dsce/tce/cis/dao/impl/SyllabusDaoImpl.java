
package org.dsce.tce.cis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Syllabus;
import org.dsce.tce.cis.common.CisConstants;
import org.dsce.tce.cis.dao.FacultyDao;
import org.dsce.tce.cis.dao.SyllabusDao;

public  class SyllabusDaoImpl implements SyllabusDao {

	public List<Syllabus> getSyllabusList() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM cis_tce_dsce.syllabus");
		List<Syllabus> SyllabusList = new ArrayList<>();
		while (rs.next()) {
			Syllabus syllabus = new Syllabus();
			System.out.println( syllabus.getName());
			SyllabusList.add(syllabus);
		}
		// TODO: log faculty count
		return SyllabusList;
	}

}
