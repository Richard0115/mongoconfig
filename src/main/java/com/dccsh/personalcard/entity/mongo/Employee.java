package com.dccsh.personalcard.entity.mongo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="employee")

//使用 lombok 注解
@Getter
@Setter
@ToString(includeFieldNames=true)
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Employee {

	@Id
	private String id;

	private String empName;
	private String empId;
	private String email;
	private String phone;
	private String empLevel;
	private String office;
	private List<String> organization;
	private List<String> memberShips;
	private String team;
	private String department;
	
}
