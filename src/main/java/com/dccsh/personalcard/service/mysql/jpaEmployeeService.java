package com.dccsh.personalcard.service.mysql;

import com.dccsh.personalcard.entity.mysql.JpaEmployee;

public interface jpaEmployeeService {

	Object insertEmployee(JpaEmployee employee);
	
	Object listEmployee();
	
	Object removeEmployee();
	
	Object updateEmployee();

}
