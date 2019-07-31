package com.dccsh.personalcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dccsh.personalcard.DTO.EntityConst;
import com.dccsh.personalcard.DTO.ResponseEntity;
import com.dccsh.personalcard.entity.mongo.Employee;
import com.dccsh.personalcard.service.mongo.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

//	@Autowired
//	private jpaEmployeeService service;
	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public Object insertEmployee(@RequestBody Employee employee) {
		ResponseEntity resp = null;
		Object rst = service.insertEmployee(employee);
		if (rst != null) {
			resp = ResponseEntity.success(EntityConst.INSERT_SUCCESS, rst);
		} else {
			resp = ResponseEntity.fail(EntityConst.INSERT_FAIL);
		}
		return resp;
	}

	@GetMapping("/employees")
	public Object listEmployee() {
		ResponseEntity resp = null;
		Object rst = service.listEmployee();
		if (rst != null) {
			resp = ResponseEntity.success(EntityConst.QUERY_SUCCESS, rst);
		} else {
			resp = ResponseEntity.fail(EntityConst.QUERY_FAIL);
		}
		return resp;
	}
	
}
