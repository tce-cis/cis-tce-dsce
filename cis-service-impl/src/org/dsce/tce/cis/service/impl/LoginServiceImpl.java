package org.dsce.tce.cis.service.impl;

import org.dsce.tce.cis.bean.User;
import org.dsce.tce.cis.dao.LoginDao;
import org.dsce.tce.cis.dao.impl.LoginDaoImpl;
import org.dsce.tce.cis.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao;

	@Override
	public boolean authenticateUser(User user) {
		loginDao = new LoginDaoImpl();
		return loginDao.authenticateUser(user.getUsername(), user.getPassword());
	}

}
