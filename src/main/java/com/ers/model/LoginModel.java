package com.ers.model;

public class LoginModel {
	
	private String userName;
	private String passWord;
	public LoginModel(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "LoginEntity [userName=" + userName + ", passWord=" + passWord + "]";
	}
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
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

}
