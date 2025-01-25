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
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getList() 
	{
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getRecord(int eid) 
	{
		return employeeRepository.findById(eid).orElse(null);

	}


	@Override
	public void deleteRecord(int eid) 
	{
		employeeRepository.deleteById(eid);
	}


	@Override
	public void updateRecord(Employee nemp) 
	{
		employeeRepository.save(nemp);
	}
 
}
