package com.stationary.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.entity.Employee;
import com.stationary.services.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	// Get All Employees
	@GetMapping("/get-all-employees")
	public List<Employee> getAllEmployees() {
	    return empService.getAllEmployees();
	}
	
	// Create a new Employee
	@PostMapping("/create-new-employee")
	public Employee createNote(@Valid @RequestBody Employee employee) {
	    return empService.addNewEmployee(employee);
	}
	
	// Get a Single Employee
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long empId) {
		return empService.getEmpById(empId);
	}
	
	// Update a Employee
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empId,
	                                        @Valid @RequestBody Employee employeeDetails) {
		return empService.updateEmpById(empId,employeeDetails);
	 }
	
	// Delete a Employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long empId) {
		empService.deleteEmployeeById(empId);
	    return ResponseEntity.ok().build();
	}
}
