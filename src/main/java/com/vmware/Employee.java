package com.vmware;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Employee {
	private String name;
	private String ssn;
	private Pattern pattern;

	public Employee(Pattern pattern) {
		this.pattern=pattern;
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
		
		if (ssn.trim().equals(""))
			throw new IllegalArgumentException("social security number cannot be blank");
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

	public void addTask(Task task) {
		// TODO Auto-generated method stub
		
	}

}