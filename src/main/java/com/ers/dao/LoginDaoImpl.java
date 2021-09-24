package com.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ers.db.HibernateUtil;

import com.ers.entity.LoginEntity;


public class LoginDaoImpl implements LoginDao {

	@Override
	public List<LoginEntity> validateUser() {
//		boolean status = false;
		List<LoginEntity> loginList = new ArrayList<LoginEntity>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from LoginEntity l");
			loginList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

		}
		return loginList;
	}
}
