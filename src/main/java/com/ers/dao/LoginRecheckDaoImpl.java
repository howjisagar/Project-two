package com.ers.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.ers.db.HibernateUtil;
import com.ers.db.LoginMapper;
import com.ers.model.LoginModel;

public class LoginRecheckDaoImpl implements LoginRecheckDao {

	@Override
	public boolean addLoginDetails(LoginModel loginModel) {
		boolean getStatus = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			 session.save(LoginMapper.mapLogin(loginModel));
			session.getTransaction().commit();
			System.out.println("Data inserted successfully!");
			getStatus = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return getStatus;
	}
	
}
