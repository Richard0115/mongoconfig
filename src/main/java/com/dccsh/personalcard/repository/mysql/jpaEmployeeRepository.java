package com.dccsh.personalcard.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dccsh.personalcard.entity.mysql.JpaEmployee;

@Repository
public interface jpaEmployeeRepository extends JpaRepository<JpaEmployee, String>{

	
}
