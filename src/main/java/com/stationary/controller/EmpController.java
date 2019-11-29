package com.stationary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.entity.Employee;
import com.stationary.services.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Employee> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return empService.findAll();
	  }
}
