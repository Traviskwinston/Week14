package com.coderscampus.Week14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Week14.dto.Person;
import com.coderscampus.Week14.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;
	
	@PostMapping("/persons")
	public Person createPerson (String name, String gender, Integer age, Long id) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setId(id);
		 
		personRepo.save(person);
		return person;
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable Long personId) {
		System.out.println("Person ID: " + personId);
		return personRepo.findById(personId);
	}

}