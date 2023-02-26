package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Emp;

public interface EmpDao {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Emp getEmployeeById(int id);
	public void removeEmployee(int id);
	
}
