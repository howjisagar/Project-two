package com.ers.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.ers.model.LoginModel;

@Entity
@Table(name = "employee")
public class RegistrationEntity {
	@OneToMany(mappedBy="userEmail",fetch=FetchType.EAGER, orphanRemoval=true)
	private Set<ReimbursementEntity> reimbursementEntity;
	@Column(nullable = false)
	private String uName;
	@Id
	private String email;
	@Column(nullable = false)
	private String contactNo;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String employeeType;
	@OneToOne(mappedBy = "regEntity",cascade=CascadeType.ALL, orphanRemoval=true)
	private LoginEntity loginEntity;
	public Set<ReimbursementEntity> getReimbursementEntity() {
		return reimbursementEntity;
	}
	public void setReimbursementEntity(Set<ReimbursementEntity> reimbursementEntity) {
		this.reimbursementEntity = reimbursementEntity;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public LoginEntity getLoginEntity() {
		return loginEntity;
	}
	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
	@Override
	public String toString() {
		return "RegistrationEntity [reimbursementEntity=" + reimbursementEntity + ", uName=" + uName + ", email="
				+ email + ", contactNo=" + contactNo + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", employeeType=" + employeeType + ", loginEntity=" + loginEntity + "]";
	}
}
