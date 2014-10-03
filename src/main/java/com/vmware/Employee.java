package com.vmware;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Employee {
	private String name;
	private String ssn;
	private Pattern pattern;

	public Employee() {
		pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
	}
	
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
		if(!(pattern.matcher(ssn).matches()))
			throw new IllegalArgumentException(ssn + " is not a valid social security number");
		this.ssn = ssn;
	}

	/*
	 * returns Social Security Number
	 */
	public String getSocialSecurityNumber() {
		return ssn;
	}
}