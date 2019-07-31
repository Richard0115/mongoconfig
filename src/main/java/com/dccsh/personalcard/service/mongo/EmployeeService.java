package com.dccsh.personalcard.service.mongo;

import com.dccsh.personalcard.entity.mongo.Employee;

public interface EmployeeService {
	
	Object insertEmployee(Employee employee);
	Object listEmployee();

}
