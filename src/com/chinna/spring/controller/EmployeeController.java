package com.chinna.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinna.spring.entity.Employee;
//import com.chinna.spring.service.EmployeeService;
import com.chinna.spring.service.Serviceinterface;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private Serviceinterface employeeService;
	
	//@Autowired(required=true)
	//@Qualifier(value="employeeService")
	//public void setEmployeeService(EmployeeService employeeService){
		//this.employeeService = employeeService;
		//System.out.println("employee service injucted");

	//}

	
	@GetMapping("/list")
public String listEmployee(Model theModel) {
		System.out.println("list employee method called");
		
		List<Employee> theEmployee = employeeService.getEmployees();
				
		
		theModel.addAttribute("employees", theEmployee);
		
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		System.out.println("add method called");
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("customer") Employee theEmployee) {
		System.out.println("save method called");
		employeeService.saveEmployee(theEmployee);	
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		System.out.println("update method called");
		Employee theEmployee =employeeService.getEmployee(theId);	
		
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId,Model model) {
	//public String deleteEmployee() {
		System.out.println("delete method called");
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}
}

