package com.ers.db;

import com.ers.entity.RegistrationEntity;

import com.ers.model.RegistrationModel;

public class RegistrationMapper {
	
	public static RegistrationEntity mapReg(RegistrationModel rModel) {
		RegistrationEntity regEntity = new RegistrationEntity();
		regEntity.setuName(rModel.getuName());
		regEntity.setEmail(rModel.getEmail());
		regEntity.setContactNo(rModel.getContactNo());
		regEntity.setAge(rModel.getAge());
		regEntity.setGender(rModel.getGender());
		regEntity.setAddress(rModel.getAddress());
		regEntity.setEmployeeType(rModel.getEmployeeType());
		
		return regEntity;
	}

}
