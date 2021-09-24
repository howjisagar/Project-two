package com.ers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LoginTable")
public class LoginEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String passWord;
	@OneToOne(targetEntity = RegistrationEntity.class)
	@JoinColumn(name = "email", nullable = false, unique = true)
	private RegistrationEntity regEntity;
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public RegistrationEntity getRegEntity() {
		return regEntity;
	}
	public void setRegEntity(RegistrationEntity regEntity) {
		this.regEntity = regEntity;
	}
	@Override
	public String toString() {
		return "LoginEntity [loginId=" + loginId + ", userName=" + userName + ", passWord=" + passWord + ", regEntity="
				+ regEntity + "]";
	}
	
	

}
