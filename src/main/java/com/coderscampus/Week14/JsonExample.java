package com.coderscampus.Week14;

import org.junit.jupiter.api.Test;

import com.coderscampus.Week14.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {

	@Test
	public void converJsonToJava () {
		String jsonString = "{\"name\" : \"Travis\",\"age\" : 28,\"gender\" : \"Unknown\"}";
		
		//Convert to Java from String
		ObjectMapper mapper = new ObjectMapper();
		try {
			Person person = mapper.readValue(jsonString, Person.class);
			System.out.println(person);
			celebrateBirthday(person);
			
			//convert to JSON from Java
			System.out.println(mapper.writeValueAsString(person));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	private void celebrateBirthday(Person person) {
		person.setAge(person.getAge()+1);
	}
}
