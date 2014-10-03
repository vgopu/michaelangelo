package com.vmware;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class EmployeePerformanceServiceTest {

	@Test
	public void findTheTopTwoPerformingEmployees() {
		
		EmployeePerformanceService employeePerformanceService = new EmployeePerformanceService();
		
		Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		
		Employee employee1 = new Employee(null);
		employee1.addTask(new Task("Fix Bug", 4, 4));
		employee1.addTask(new Task("Changed Header", 1, 3));
		employee1.addTask(new Task("Fixed Major Bug", 5, 1));
		employee1.addTask(new Task("Fixed DE10203", 2, 3));
		
		Employee employee2 = new Employee(null);
		employee2.addTask(new Task("Fix Bug", 2, 2));
		employee2.addTask(new Task("Changed Header", 10, 1));
		employee2.addTask(new Task("Fixed Major Bug", 4, 2));
		employee2.addTask(new Task("Fixed DE10203", 2, 2));
		
		Employee employee3 = new Employee(null);
		employee3.addTask(new Task("Fixed Major Bug", 4, 6));
		employee3.addTask(new Task("Fixed DE10203", 4, 9));
		
		Employee employee4 = new Employee(null);
		employee4.addTask(new Task("Fixed Major Bug", 4, 2));
		employee4.addTask(new Task("Fixed DE10203", 4, 4));
		employee4.addTask(new Task("Fixed Major Bug", 1, 1));
		employee4.addTask(new Task("Fixed DE10203", 9, 2));
		employee4.addTask(new Task("Fixed Major Bug", 10, 6));
		employee4.addTask(new Task("Fixed DE10203", 2, 1));
		
		employeePerformanceService.addEmployee(employee1);
		employeePerformanceService.addEmployee(employee2);
		employeePerformanceService.addEmployee(employee3);
		employeePerformanceService.addEmployee(employee4);
		
		List<Employee> expectedEmployees = new ArrayList<Employee>();
		
		expectedEmployees.add(employee4);
		expectedEmployees.add(employee2);
		assertEquals(employeePerformanceService.getTop2Performers(), expectedEmployees); 
		
	}
}
