package org.dsce.tce.cis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.common.CisConstants;
import org.dsce.tce.cis.dao.FacultyDao;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public List<Faculty> getFacultyDetails() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM cis_tce_dsce.faculty");
		List<Faculty> facultyList = new ArrayList<>();
		while (rs.next()) {
			Faculty faculty = new Faculty(rs.getString("full_name"), rs.getString("designation"),
					rs.getString("education_qualification"), rs.getString("experience"), rs.getString("specialization"),
					rs.getString("email"), rs.getString("phone"), rs.getString("salutation"));
			System.out.print(faculty.getName());
			facultyList.add(faculty);
		}
		return facultyList;
	}

	@Override
	public List<Publication> getPublications() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER, CisConstants.PASS);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM cis_tce_dsce.publication");
		List<Publication> publicationList = new ArrayList<>();
		while (rs.next()) {
			Publication publication = new Publication(rs.getString("title"), rs.getString("journal"),
					rs.getString("primary_author"), rs.getString("co_authors"));
			publicationList.add(publication);
		}
		return publicationList;
	}

}
