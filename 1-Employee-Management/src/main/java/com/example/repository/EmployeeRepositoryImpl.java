package com.example.repository;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository
{
private Session session;
private Transaction transaction;



@Autowired

//Constructor
public EmployeeRepositoryImpl(SessionFactory factory)
{
	session=factory.openSession();
	transaction=session.getTransaction();
}

@Override
public void savaEmployee(Employee employee) 
{
transaction.begin();
session.persist(employee);
transaction.commit();
}


public List<Employee> getEmployeeList() 
{
	Query<Employee> query=session.createQuery("from Employee",Employee.class);
	return query.list();
}

@Override
public Employee getEmployee(int eid) 
{
	Employee emp=session.get(Employee.class, eid);
	return emp;
}

public void deleteEmployee(Employee employee) 
{
		transaction.begin();
		session.remove(employee);
		transaction.commit();
}

@Override
public void updateEmployee(Employee nemp, Employee oemp)
{
	transaction.begin();
	oemp.setFirstname(nemp.getFirstname());
	oemp.setLastname(nemp.getLastname());
	oemp.setPhone(nemp.getPhone());
	oemp.setEmail(nemp.getEmail());
	oemp.setDepartment(nemp.getDepartment());
	oemp.setSalary(nemp.getSalary());
	transaction.commit();
}


}
