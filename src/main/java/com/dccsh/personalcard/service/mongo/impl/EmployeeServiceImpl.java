package com.dccsh.personalcard.service.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dccsh.personalcard.entity.mongo.Employee;
import com.dccsh.personalcard.repository.mongo.EmployeeRepository;
import com.dccsh.personalcard.service.mongo.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Object insertEmployee(Employee employee) {
		System.out.println(employee.toString());
		return repo.insert(employee);
	}

	@Override
	public Object listEmployee() {
		return repo.findAll();
	}

}
