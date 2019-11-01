package com.chinna.spring.Dao;

import java.util.List;
import com.chinna.spring.entity.Employee;

public interface DaoInterface {
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
}
