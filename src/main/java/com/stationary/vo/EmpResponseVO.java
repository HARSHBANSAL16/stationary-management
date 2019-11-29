package com.stationary.vo;

public class EmpResponseVO {
	
private Long empID;
	
	private String name;
	
	private String email;
	
	private String phone;

	public Long getEmpID() {
		return empID;
	}

	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "EmpResponseVO [empID=" + empID + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", getEmpID()=" + getEmpID() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
