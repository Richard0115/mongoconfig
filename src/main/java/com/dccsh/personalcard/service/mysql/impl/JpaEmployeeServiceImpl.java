package com.dccsh.personalcard.service.mysql.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dccsh.personalcard.entity.mysql.JpaEmployee;
import com.dccsh.personalcard.repository.mysql.jpaEmployeeRepository;
import com.dccsh.personalcard.service.mysql.jpaEmployeeService;

@Service
public class JpaEmployeeServiceImpl implements jpaEmployeeService{

	@Autowired
	private jpaEmployeeRepository repo;
	
	@Override
	public Object insertEmployee(JpaEmployee employee) {
		Object rst = repo.save(employee);
		return rst;
	}

	@Override
	public Object listEmployee() {
		Object rst = repo.findAll();
		return rst;
	}

	@Override
	public Object removeEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
