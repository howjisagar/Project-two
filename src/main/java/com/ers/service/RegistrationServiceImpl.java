package com.ers.service;

import java.util.List;
import com.ers.dao.RegistrationDao;
import com.ers.dao.RegistrationDaoImpl;
import com.ers.entity.RegistrationEntity;
import com.ers.model.RegistrationModel;

public class RegistrationServiceImpl implements RegistrationService {

	RegistrationDao regDao = new RegistrationDaoImpl();
	
	@Override
	public boolean addEmployeeDetails(RegistrationModel rModel) {
		// TODO Auto-generated method stub
		return regDao.addEmployeeDetails(rModel);
	}

	@Override
	public List<RegistrationEntity> getEmployeeDetails(String userName) {
		// TODO Auto-generated method stub
		return regDao.getEmployeeDetails(userName);
	}

	@Override
	public boolean updateEmployeeDetails(RegistrationModel rModel) {
		// TODO Auto-generated method stub
		return regDao.updateEmployeeDetails(rModel);
	}

	@Override
	public String getEmployeeType(String userName) {
		// TODO Auto-generated method stub
		return regDao.getEmployeeType(userName);
	}

	@Override
	public List<RegistrationEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return regDao.getAllEmployees();
	}
	
}
