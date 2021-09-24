package com.ers.dao;

import java.util.List;
import com.ers.entity.RegistrationEntity;
import com.ers.entity.ReimbursementEntity;
import com.ers.model.ReimbursementModel;

public interface ReimbursementDao  {
	
	public boolean addReimbursementRequestDetails(ReimbursementModel reimbursementModel, String email);

	public List<ReimbursementEntity> getParticularUserPendingRequests(String userName);

	public List<ReimbursementEntity> getParticularUserApprovedRequests(String userName);

	public List<ReimbursementEntity> getAllApprovedRequests();

	public List<String> getRequestIds();

	public List<ReimbursementEntity> getDetailsById(String requestId);

	public boolean updateRequestStatus(String requestId, String managerAction,String reqActionDate,String reqActionRemarks);
	
}
