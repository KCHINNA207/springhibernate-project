package com.chinna.spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chinna.spring.entity.Employee;
@Repository
public class EmployeeDao implements DaoInterface{

	
	    @Autowired
		private SessionFactory sessionFactory;
		
		/*public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}*/
				
		@Override
		public List<Employee> getEmployees() {
			
			
		System.out.println("from service method");
			Session currentSession = sessionFactory.getCurrentSession();
					
			
			Query<Employee> theQuery = 
					currentSession.createQuery("from Employee order by lastName",
							Employee.class);			
			List<Employee> customers = theQuery.getResultList();				
			return customers;
		}

		@Override
		public void saveEmployee(Employee theEmployee) {
			Session currentSession = sessionFactory.getCurrentSession();			
			currentSession.saveOrUpdate(theEmployee);		
		}

		@Override
		public Employee getEmployee(int theId) {
			Session currentSession = sessionFactory.getCurrentSession();		
			Employee theEmployee = currentSession.get(Employee.class, theId);			
			return theEmployee;
		}

		@Override
		public void deleteEmployee(int theId) {		
			Session currentSession = sessionFactory.getCurrentSession();		
			@SuppressWarnings("unchecked")
			Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
			
			theQuery.setParameter("employeeId", theId);
			
			theQuery.executeUpdate();		
		}



}
