package com.example.repository;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeRepository 
{

	void savaEmployee(Employee employee);

	List<Employee> getEmployeeList();

	Employee getEmployee(int eid);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee nemp, Employee oemp);

	
}
