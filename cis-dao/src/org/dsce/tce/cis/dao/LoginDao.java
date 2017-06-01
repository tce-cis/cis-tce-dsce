package org.dsce.tce.cis.dao;

/**
 * DAO interface to validate user credentials.
 * 
 * @author Chetan Gorkal
 *
 */
public interface LoginDao {

	/**
	 * Method to authenticate user
	 * 
	 * @param username
	 *            User name
	 * @param password
	 *            Password
	 * @return <code>true</code> when user enters valid credentials
	 */
	boolean authenticateUser(String username, String password);

}
