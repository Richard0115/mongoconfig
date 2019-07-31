package com.dccsh.personalcard.entity;

import javax.persistence.AttributeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dccsh.personalcard.entity.mysql.JpaEmployee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JpaConvertListToJson implements AttributeConverter<Object, String>{
	private static Logger logger = LoggerFactory.getLogger(JpaConvertListToJson.class);

	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Object attribute) {
		String rst = null;
		try {
			rst = mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return rst;
	}

	@Override
	public Object convertToEntityAttribute(String dbData) {
		Object rst = null;
		try {
			rst = mapper.readValue(dbData,JpaEmployee.class);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return rst;
	}

}
