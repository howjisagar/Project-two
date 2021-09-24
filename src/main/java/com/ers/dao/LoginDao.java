package com.ers.dao;

import java.util.List;
import com.ers.entity.LoginEntity;

public interface LoginDao  {
	
	public List<LoginEntity> validateUser();
	
}
