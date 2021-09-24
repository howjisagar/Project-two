package com.ers.dao;

import java.util.List;
import com.ers.entity.RegistrationEntity;
import com.ers.model.RegistrationModel;

public interface RegistrationDao  {
	
	public boolean addEmployeeDetails(RegistrationModel rModel);

	public List<RegistrationEntity> getEmployeeDetails(String userName);
	public boolean updateEmployeeDetails(RegistrationModel rModel);
	public String getEmployeeType(String userName);
	public List<RegistrationEntity> getAllEmployees();
}
