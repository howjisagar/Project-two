package com.ers.service;

import java.util.List;
import com.ers.dao.LoginDao;
import com.ers.dao.LoginDaoImpl;
import com.ers.entity.LoginEntity;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDaoImpl = (LoginDao) new LoginDaoImpl();
	
	@Override
	public List<LoginEntity> validateUser() {
		return loginDaoImpl.validateUser();
	}
	
}
