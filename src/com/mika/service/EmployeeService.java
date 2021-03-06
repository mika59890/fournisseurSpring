package com.mika.service;

import java.util.List;

import com.mika.model.Employee;


public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);

	public Employee getEmpl(String email);
	
	public void deleteEmployee(Employee employee);
}
