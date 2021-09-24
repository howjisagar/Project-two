package com.ers.db;

import com.ers.entity.LoginEntity;
import com.ers.entity.RegistrationEntity;

import com.ers.model.LoginModel;

public class LoginMapper {
	
	public static LoginEntity mapLogin(LoginModel loginModel) {
		
		LoginEntity loginEntity = new LoginEntity();
		RegistrationEntity regEntity = new RegistrationEntity();
		regEntity.setEmail(loginModel.getUserName());
		loginEntity.setRegEntity(regEntity);
		loginEntity.setUserName(loginModel.getUserName());
		loginEntity.setPassWord(loginModel.getPassWord());
		
		return loginEntity;
	}
	
}
