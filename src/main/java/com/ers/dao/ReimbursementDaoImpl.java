package com.ers.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.ers.db.HibernateUtil;
import com.ers.db.ReimbursementMapper;
import com.ers.entity.RegistrationEntity;
import com.ers.entity.ReimbursementEntity;
import com.ers.model.ReimbursementModel;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public boolean addReimbursementRequestDetails(ReimbursementModel reimbursementModel, String email) {
		
		boolean getStatus = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("before mapper");
			ReimbursementEntity reimbursementEntity = ReimbursementMapper.mapReimbursementRequest(reimbursementModel,
					email);
		
			session.beginTransaction();
			session.save(reimbursementEntity);
			System.out.println("after mapper");
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


	@Override
	public List<ReimbursementEntity> getParticularUserPendingRequests(String userName) {
		List<ReimbursementEntity> pendingList = new ArrayList<ReimbursementEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("FROM ReimbursementEntity r where email=:userId and reqStatus=:status");

			query.setParameter("userId", userName);
			query.setParameter("status", "Pending");
			pendingList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return pendingList;
	}

	@Override
	public List<ReimbursementEntity> getParticularUserApprovedRequests(String userName) {
		List<ReimbursementEntity> approvedList = new ArrayList<ReimbursementEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("FROM ReimbursementEntity r where email=:userId and reqStatus=:status");

			query.setParameter("userId", userName);
			query.setParameter("status", "Accepted");
			approvedList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return approvedList;
	}


	@Override
	public List<ReimbursementEntity> getAllApprovedRequests() {
		List<ReimbursementEntity> allApprovedRequestList = new ArrayList<ReimbursementEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementEntity r where reqStatus=:status");
			query.setParameter("status", "Accepted");
			allApprovedRequestList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allApprovedRequestList;
	}

	@Override
	public List<String> getRequestIds() {
		List<String> allRequestIdList = new ArrayList<String>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("SELECT r.reqId FROM ReimbursementEntity r where reqStatus=:status");
			query.setParameter("status", "Pending");
			allRequestIdList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allRequestIdList;
	}

	@Override
	public List<ReimbursementEntity> getDetailsById(String requestId) {
		List<ReimbursementEntity> RequestDetailsList = new ArrayList<ReimbursementEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementEntity r where reqId=:requestId");
			query.setParameter("requestId", requestId);
			RequestDetailsList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return RequestDetailsList;
	}

	@Override
	public boolean updateRequestStatus(String requestId, String managerAction, String reqActionDate,
			String reqActionRemarks) {
		boolean getStatus = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query=session.createQuery("UPDATE ReimbursementEntity SET reqStatus=:status,reqActionDate=:actionDate,reqActionRemarks=:actionRemarks WHERE reqId=:requestId");
			query.setParameter("status",managerAction);
			query.setParameter("actionDate",reqActionDate);
			query.setParameter("actionRemarks", reqActionRemarks);
			query.setParameter("requestId", requestId);
			int count=query.executeUpdate();
			getStatus=true;
			session.getTransaction().commit();
			System.out.println(count+" "+"Rows Updated");
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
