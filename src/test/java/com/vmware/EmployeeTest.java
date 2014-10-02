package com.vmware;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EmployeeTest {

		@Test
		public void createEmployeeAndGetName() {
			Employee employee = new Employee();
			
			employee.setName("Ricardo Montalban");
			assertEquals(employee.getName(), "Ricardo Montalban");
		}
}
