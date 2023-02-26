package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.EmplDao;
import com.example.demo.model.Emp;

public interface EmpService {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}
