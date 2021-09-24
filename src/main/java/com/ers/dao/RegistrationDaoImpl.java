package com.ers.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.ers.db.RegistrationMapper;
import com.ers.entity.RegistrationEntity;
import com.ers.model.RegistrationModel;
import com.ers.db.*;

public class RegistrationDaoImpl implements RegistrationDao {

	@Override
	public boolean addEmployeeDetails(RegistrationModel rModel) {
		
		boolean getStatus = false;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			RegistrationEntity sessionEntity = RegistrationMapper.mapReg(rModel);
			session.saveOrUpdate(sessionEntity);
			session.flush();
			session.getTransaction().commit();
			System.out.println("Data inserted successfully");
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

	@Override
	public List<RegistrationEntity> getEmployeeDetails(String userName) {
		List<RegistrationEntity> employeeList = new ArrayList<RegistrationEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM RegistrationEntity s where email=:userId");

			query.setParameter("userId", userName);
			employeeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employeeList;
	}

	@Override
	public boolean updateEmployeeDetails(RegistrationModel rModel) {
		
		boolean getStatus = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			RegistrationEntity regEntity = RegistrationMapper.mapReg(rModel);
			session.find(RegistrationEntity.class, rModel.getEmail());
			RegistrationEntity regEntity1 = session.load(RegistrationEntity.class, rModel.getEmail());
			regEntity1.setuName(regEntity.getuName());
			regEntity1.setEmail(regEntity.getEmail());
			regEntity1.setContactNo(regEntity.getContactNo());
			regEntity1.setAge(regEntity.getAge());
			regEntity1.setGender(regEntity.getGender());
			regEntity1.setAddress(regEntity.getAddress());
			regEntity1.setEmployeeType(regEntity.getEmployeeType());
			session.merge(regEntity1);
			session.flush();
			session.getTransaction().commit();
			System.out.println("Data updated successfully1");
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

	@Override
	public String getEmployeeType(String userName) {
		String empType = "";
		List<RegistrationEntity> employeeList = new ArrayList<RegistrationEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from RegistrationEntity s where email=:userId");
			query.setParameter("userId", userName);
			System.out.println("Before query");
			employeeList = query.list();
			System.out.println("After query");
			for (RegistrationEntity eList : employeeList) {
				empType = eList.getEmployeeType();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return empType;
	}

	@Override
	public List<RegistrationEntity> getAllEmployees() {
		List<RegistrationEntity> allEmployeeList = new ArrayList<RegistrationEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM RegistrationEntity s where employeeType=:eType");
			query.setParameter("eType", "Employee");
			allEmployeeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allEmployeeList;
	}
	
}
