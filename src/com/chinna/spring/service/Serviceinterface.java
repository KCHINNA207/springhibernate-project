package com.chinna.spring.service;

import java.util.List;

import com.chinna.spring.entity.Employee;

public interface Serviceinterface {
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
}
