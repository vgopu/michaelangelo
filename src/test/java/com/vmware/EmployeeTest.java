package com.vmware;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EmployeeTest {

		@Test
		public void createEmployeeAndGetName() {
			Employee employee = new Employee();
			String name = "Ricardo Montalban";
			employee.setName(name);
			assertEquals(employee.getName(), name);
		}
		
		// F2 brings up the helper
		// Ctrl+F11 Run
		// CTRL+E recent files
		// F3 Jump to Source
		@Test
		public void addSocialSecurityNumber(){
			Employee employee = new Employee();
			employee.setSocialSecurityNumber("123-45-6789");
			assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
		}
		
		@Test
		public void addAnotherSocialSecurityNumber(){
			Employee employee = new Employee();
			employee.setSocialSecurityNumber("123-45-6710");
			assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
		}
}
