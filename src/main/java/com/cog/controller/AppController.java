package com.cog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cog.exception.StudentNotFound;
import com.cog.model.Admin;
import com.cog.model.Student;
import com.cog.service.StudentService;

@RestController
@RequestMapping("api/v1/admin")
public class AppController {

	@Autowired
	private StudentService srevice;

	@PostMapping(value = "/add")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student s) {
		System.out.println(s);
		return new ResponseEntity<Student>(srevice.save(s), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> getStdent(@PathVariable int id) throws StudentNotFound {
		return new ResponseEntity<Student>(srevice.find(id), HttpStatus.OK);
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Student>> findAll() {
		System.out.println("in findAll");
		return new ResponseEntity<List<Student>>(srevice.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/newAdmin")
	public ResponseEntity<String> addNewAdmin(@RequestBody Admin a) {
		return new ResponseEntity<String>(srevice.saveAdmin(a), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?>deleteStudent(@PathVariable int id) throws StudentNotFound{
		
		return new ResponseEntity<String>(srevice.deleteStudent(id),HttpStatus.OK);
	}

}
