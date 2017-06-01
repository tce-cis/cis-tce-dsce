package org.dsce.tce.cis.service;

import org.dsce.tce.cis.bean.User;

/**
 * Service interface to validate user credentials
 * 
 * @author Chetan Gorkal
 *
 */
public interface LoginService {

	/**
	 * 
	 * @param user
	 *            {@link User} bean having credentials entered by the user
	 * @return <code>true</code> when the entered credentials are valid
	 */
	boolean authenticateUser(User user);

}
