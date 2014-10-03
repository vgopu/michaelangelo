package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest {
		
		private Employee employee;
		
		@BeforeMethod
		public void setUp(){
			System.out.println("Construct a new Emplyee per test");
			employee = new Employee();
		}
		
		@Test
		public void createEmployeeAndGetName() {
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
			employee.setSocialSecurityNumber("123-45-6789");
			assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
		}
		
		@Test
		public void addAnotherSocialSecurityNumber(){
			employee.setSocialSecurityNumber("123-45-6710");
			assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
		}
		
		@Test
		public void fixDE30201_SocialSecurityMustBeACertainFormat(){
			String badSSN = "RamLikesThe49ers";
			try{
				employee.setSocialSecurityNumber(badSSN);
				fail("This linke should never have been reached...");
			} catch (IllegalArgumentException iae){
				assertEquals(iae.getMessage(), "RamLikesThe49ers is not a valid social security number");
			}
		}
}
