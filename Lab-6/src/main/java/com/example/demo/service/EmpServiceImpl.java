package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmplDao;
import com.example.demo.model.Emp;


@Service
public class EmpServiceImpl implements EmpService {

	@Override
	@Transactional
	public void addEmployee(Employee p) {
		this.EmpDao.addEmployee(p);
	}
	
	@Override
	@Transactional
	public void updateEmployee(Employee p) {
		this.EmpDao.updateEmployee(p);
	}
	
	@Override
	@Transactional
	public List<Employee> listEmployees(){
		return this.EmpDao.listEmployees();
	}
	
	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.EmpDao.getEmployeeById(id);
	}
	
	@Override
	@Transactional
	public void removeEmployee(int id) {
		this.EmpDao.removeEmployee(id);
	}
}
