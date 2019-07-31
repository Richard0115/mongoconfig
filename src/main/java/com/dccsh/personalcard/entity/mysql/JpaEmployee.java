package com.dccsh.personalcard.entity.mysql;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dccsh.personalcard.entity.JpaConvertListToJson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee")
//这是lombok注解 ,这个注解比较残暴,他会
@Getter
@Setter
@ToString
public class JpaEmployee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column
	private String empName;
	@Column
	private String empId;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String empLevel;
	@Column
	private String office;
	@Convert(converter=JpaConvertListToJson.class)
	@Column(columnDefinition="TEXT")
	private List<String> organizations;
	@Convert(converter=JpaConvertListToJson.class)
	@Column(columnDefinition="TEXT")
	private List<String> memberShips;
	@Column
	private String team;
	@Column
	private String department;

}
