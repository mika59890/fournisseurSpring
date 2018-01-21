package com.mika.dao;

import java.util.List;

import com.mika.model.Employee;


public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);

	public Employee getEmpl(String email);

}
