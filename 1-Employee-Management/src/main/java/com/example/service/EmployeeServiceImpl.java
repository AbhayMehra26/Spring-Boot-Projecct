package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
 private EmployeeRepository employeeRepository;

	@Override
	public void saveRecord(Employee employee)
	{
		employeeRepository.savaEmployee(employee);
	}


	@Override
	public List<Employee> getList() 
	{
		
		return employeeRepository.getEmployeeList();
	}


	@Override
	public Employee getRecord(int eid) 
	{
		return employeeRepository.getEmployee(eid);

	}


	@Override
	public void deleteRecord(int eid) 
	{
		Employee employee=employeeRepository.getEmployee(eid);
		employeeRepository.deleteEmployee(employee);
	}


	@Override
	public void updateRecord(Employee nemp) 
	{
		Employee oemp=employeeRepository.getEmployee(nemp.getEid());
		employeeRepository.updateEmployee(nemp,oemp);
	}
 
}
