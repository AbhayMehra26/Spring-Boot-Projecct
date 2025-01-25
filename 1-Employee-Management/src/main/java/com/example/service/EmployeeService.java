package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService 
{

	void saveRecord(Employee employee);

	List<Employee> getList();

	Employee getRecord(int eid);

	void deleteRecord(int eid);

	void updateRecord(Employee nemp);

}
