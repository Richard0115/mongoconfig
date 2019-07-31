package com.dccsh.personalcard.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dccsh.personalcard.entity.mongo.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
