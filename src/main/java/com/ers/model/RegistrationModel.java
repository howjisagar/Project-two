package com.ers.model;

public class RegistrationModel {

	private String uName;
	private String email;
	private String contactNo;
	private Integer age;
	private String gender;
	private String address;
	private String employeeType;
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
	@Override
	public String toString() {
		return "RegistrationModel [uName=" + uName + ", email=" + email + ", contactNo=" + contactNo + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + ", employeeType=" + employeeType + "]";
	}
	public RegistrationModel(String uName, String email, String contactNo, Integer age, String gender, String address,
			String employeeType) {
		super();
		this.uName = uName;
		this.email = email;
		this.contactNo = contactNo;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.employeeType = employeeType;
	}
	public RegistrationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
