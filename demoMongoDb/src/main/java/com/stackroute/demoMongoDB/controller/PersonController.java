package com.stackroute.demoMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.demoMongoDB.model.Person;
import com.stackroute.demoMongoDB.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.create(firstName, lastName, age);
//	demo request url	http://localhost:8080/create?firstName=demo&lastName=last2&age=25
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}
	@RequestMapping("/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.update(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		personService.delete(firstName);
		return "Deleted "+firstName;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}
	
}
