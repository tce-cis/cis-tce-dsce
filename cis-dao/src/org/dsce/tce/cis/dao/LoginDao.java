package org.dsce.tce.cis.dao;

public interface LoginDao {

	boolean authenticateUser(String username, String password);

}
