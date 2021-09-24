package com.ers.model;

public class ReimbursementModel{
	
	private String reqId;
	private String reqType;
	private Double reqAmount;
	private String reqDate;
	private String reqDescription;
	private String reqStatus;
	private Integer loginId;
	private String email;
	private String reqActionDate;
	private String actionRemarks;
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public Double getReqAmount() {
		return reqAmount;
	}
	public void setReqAmount(Double reqAmount) {
		this.reqAmount = reqAmount;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getReqDescription() {
		return reqDescription;
	}
	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReqActionDate() {
		return reqActionDate;
	}
	public void setReqActionDate(String reqActionDate) {
		this.reqActionDate = reqActionDate;
	}
	public String getActionRemarks() {
		return actionRemarks;
	}
	public void setActionRemarks(String actionRemarks) {
		this.actionRemarks = actionRemarks;
	}
	@Override
	public String toString() {
		return "ReimbursementModel [reqId=" + reqId + ", reqType=" + reqType + ", reqAmount=" + reqAmount + ", reqDate="
				+ reqDate + ", reqDescription=" + reqDescription + ", reqStatus=" + reqStatus + ", loginId=" + loginId
				+ ", email=" + email + ", reqActionDate=" + reqActionDate + ", actionRemarks=" + actionRemarks + "]";
	}
	public ReimbursementModel(String reqId, String reqType, Double reqAmount, String reqDate, String reqDescription,
			String reqStatus, Integer loginId, String email, String reqActionDate, String actionRemarks) {
		super();
		this.reqId = reqId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.reqDate = reqDate;
		this.reqDescription = reqDescription;
		this.reqStatus = reqStatus;
		this.loginId = loginId;
		this.email = email;
		this.reqActionDate = reqActionDate;
		this.actionRemarks = actionRemarks;
	}
	public ReimbursementModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
