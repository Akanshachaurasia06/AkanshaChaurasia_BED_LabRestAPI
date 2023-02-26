package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;

public class EmpController {
	
	private EmpService empService;
	
	@Autowired(required=true)
	@Qualifier(value="empService")
	public void setEmployeeService(EmpService ps){
		this.empService = ps;
	}
	
	@RequestMapping(value = "/Employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("emp", new Employee());
		model.addAttribute("listEmployee", this.empService.listEmployees());
		return "emp";
	}
	
	//For add and update Employee both
	@RequestMapping(value= "/emp/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee p){
		
		if(p.getId() == 0){
			//new Employee, add it
			this.empService.addEmployee(p);
		}else{
			//existing Employee, call update
			this.empService.updateEmployee(p);
		}
		
		return "redirect:/Employees";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
        this.empService.removeEmployee(id);
        return "redirect:/Employees";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("Employee", this.empService.getEmployeeById(id));
        model.addAttribute("listEmployee", this.empService.listEmployee());
        return "Employee";
    }
	
}

