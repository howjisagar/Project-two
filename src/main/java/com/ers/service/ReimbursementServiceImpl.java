package com.ers.service;

import java.util.List;
import com.ers.dao.ReimbursementDao;
import com.ers.dao.ReimbursementDaoImpl;
import com.ers.entity.RegistrationEntity;
import com.ers.entity.ReimbursementEntity;
import com.ers.model.ReimbursementModel;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDao reimbursementDao = (ReimbursementDao) new ReimbursementDaoImpl();

	@Override
	public boolean addReimbursementRequestDetails(ReimbursementModel reimbursementModel, String email) {
		// TODO Auto-generated method stub
		return reimbursementDao.addReimbursementRequestDetails(reimbursementModel, email);
	}

	@Override
	public List<ReimbursementEntity> getParticularUserPendingRequests(String userName) {
		// TODO Auto-generated method stub
		return reimbursementDao.getParticularUserPendingRequests(userName);
	}

	@Override
	public List<ReimbursementEntity> getParticularUserApprovedRequests(String userName) {
		// TODO Auto-generated method stub
		return reimbursementDao.getParticularUserApprovedRequests(userName);
	}


	@Override
	public List<ReimbursementEntity> getAllApprovedRequests() {
		// TODO Auto-generated method stub
		return reimbursementDao.getAllApprovedRequests();
	}


	@Override
	public List<String> getRequestIds() {
		// TODO Auto-generated method stub
		return reimbursementDao.getRequestIds();
	}

	@Override
	public List<ReimbursementEntity> getDetailsById(String requestId) {
		// TODO Auto-generated method stub
		return reimbursementDao.getDetailsById(requestId);
	}

	@Override
	public boolean updateRequestStatus(String requestId, String managerAction, String reqActionDate,
			String reqActionRemarks) {
		// TODO Auto-generated method stub
		return reimbursementDao.updateRequestStatus(requestId, managerAction,reqActionDate,reqActionRemarks);
	}

}
