package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeTest {
		
		private Employee employee;
		
		@BeforeMethod
		public void setUp(){
			employee = new Employee(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));
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
		
		@DataProvider(name="badSSNs")
		public Object[][] badSSNProvider(){
			return new Object[][]{
					{"djajssjs", "djajssjs is not a valid social security number"},	
					{"RamLikesThe49ers", "RamLikesThe49ers is not a valid social security number"},
					{"1", "1 is not a valid social security number"},
					{"19", "19 is not a valid social security number"},
					{"  ", "social security number cannot be blank"},
					{"", "social security number cannot be blank"}
			};
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
		
		
		@Test(dataProvider="badSSNs")
		public void fixDE30201_SocialSecurityBadSSNsFromDataProvidert(String badSSN, String expectedMessage){
			try{
				employee.setSocialSecurityNumber(badSSN);
				fail("This linke should never have been reached...");
			} catch (IllegalArgumentException iae){
				assertEquals(iae.getMessage(), expectedMessage);
			}
		}
		
		
}
