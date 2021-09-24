package com.ers.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ReimbursementTable")
public class ReimbursementEntity  {
	
	@ManyToOne
	@JoinColumn(name = "email", nullable = false)
	private RegistrationEntity userEmail;
	@Id
	private String reqId;
	@Column(nullable = false)
	private String reqType;
	@Column(nullable = false)
	private Double reqAmount;
	@Column(nullable = false)
	private String reqDate;
	@Column(nullable = false)
	private String reqStatus;
	@Column(nullable = false)
	private String reqDescription;
	@Column(nullable = false)
	private String reqActionDate;
	@Column(nullable = false)
	private String reqActionRemarks;
	public RegistrationEntity getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(RegistrationEntity userEmail) {
		this.userEmail = userEmail;
	}
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
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getReqDescription() {
		return reqDescription;
	}
	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}
	public String getReqActionDate() {
		return reqActionDate;
	}
	public void setReqActionDate(String reqActionDate) {
		this.reqActionDate = reqActionDate;
	}
	public String getReqActionRemarks() {
		return reqActionRemarks;
	}
	public void setReqActionRemarks(String reqActionRemarks) {
		this.reqActionRemarks = reqActionRemarks;
	}
	@Override
	public String toString() {
		return "ReimbursementEntity [userEmail=" + userEmail + ", reqId=" + reqId + ", reqType=" + reqType
				+ ", reqAmount=" + reqAmount + ", reqDate=" + reqDate + ", reqStatus=" + reqStatus + ", reqDescription="
				+ reqDescription + ", reqActionDate=" + reqActionDate + ", reqActionRemarks=" + reqActionRemarks + "]";
	}
	
	
}
