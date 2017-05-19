package org.dsce.tce.cis.service;

import org.dsce.tce.cis.bean.User;

public interface LoginService {

	boolean authenticateUser(User user);

}
