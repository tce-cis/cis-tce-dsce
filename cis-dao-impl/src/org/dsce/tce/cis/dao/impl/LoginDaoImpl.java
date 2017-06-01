package org.dsce.tce.cis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsce.tce.cis.common.CisConstants;
import org.dsce.tce.cis.dao.LoginDao;

/**
 * Implementation class to authenticate user.
 * 
 * @author Chetan Gorkal
 *
 */
public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean authenticateUser(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection = DriverManager.getConnection(CisConstants.DB_URL, CisConstants.USER,
					CisConstants.PASS);
			Statement sqlStatement = dbConnection.createStatement();
			String queryString = "select * from cis_tce_dsce.user where username='" + username + "'";
			System.out.println(queryString);
			ResultSet rs = sqlStatement.executeQuery(queryString);
			while (rs.next()) {
				String name = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				if (passwordFromDB.equals(PasswordHashingDemo.generateHash(password))) {
					return true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
