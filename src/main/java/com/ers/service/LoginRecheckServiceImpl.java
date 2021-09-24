package com.ers.service;

import com.ers.dao.LoginRecheckDao;
import com.ers.dao.LoginRecheckDaoImpl;
import com.ers.model.LoginModel;

public class LoginRecheckServiceImpl implements LoginRecheckService {

	LoginRecheckDao loginDao = (LoginRecheckDao) new LoginRecheckDaoImpl();

	@Override
	public boolean addLoginDetails(LoginModel loginModel) {
		// TODO Auto-generated method stub
		return loginDao.addLoginDetails(loginModel);
	}

}
