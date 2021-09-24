package com.ers.db;


import java.util.HashSet;
import java.util.Set;



import com.ers.entity.RegistrationEntity;
import com.ers.entity.ReimbursementEntity;

import com.ers.model.ReimbursementModel;


public class ReimbursementMapper{
	
	public static ReimbursementEntity mapReimbursementRequest(ReimbursementModel reimbursementModel,String email) {
		System.out.println("In mapper begin");
		ReimbursementEntity reimbursementEntity = new ReimbursementEntity();
		Set<ReimbursementEntity> reqSet=new HashSet<ReimbursementEntity>();
		RegistrationEntity regEntity = new RegistrationEntity();
		regEntity.setEmail(email);
		
		reimbursementEntity.setReqId(reimbursementModel.getReqId());
		reimbursementEntity.setReqType(reimbursementModel.getReqType());
		reimbursementEntity.setReqAmount(reimbursementModel.getReqAmount());
		reimbursementEntity.setReqDate(reimbursementModel.getReqDate());
		reimbursementEntity.setReqStatus(reimbursementModel.getReqStatus());
		reimbursementEntity.setReqDescription(reimbursementModel.getReqDescription());
		reimbursementEntity.setReqActionDate(reimbursementModel.getReqActionDate());
		reimbursementEntity.setReqActionRemarks(reimbursementModel.getActionRemarks());
		reimbursementEntity.setUserEmail(regEntity);
		
		return reimbursementEntity;
	}
	
}
