package com.chinna.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinna.spring.Dao.DaoInterface;
//import com.chinna.spring.Dao.EmployeeDao;
import com.chinna.spring.entity.Employee;
@Service
public class EmployeeService implements Serviceinterface{
	@Autowired
	private DaoInterface employeeDao;
	
	/*public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}*/
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		System.out.println("from controller method");
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

	employeeDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return employeeDao.getEmployee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		
		employeeDao.deleteEmployee(theId);
	}
}
