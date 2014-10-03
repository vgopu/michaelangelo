package com.vmware;

public class Employee {
	private String name;
	private String ssn;

	/*
	 * sets the name of the employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * returns name of the employee
	 */
	public String getName() {
		return name;
	}

	/*
	 * sets Social Security Number
	 */
	public void setSocialSecurityNumber(String ssn) {
		this.ssn = ssn;
	}

	/*
	 * returns Social Security Number
	 */
	public String getSocialSecurityNumber() {
		return ssn;
	}
}