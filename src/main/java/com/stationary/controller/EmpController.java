package com.stationary.controller;

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

import com.stationary.data.APIResponse;
import com.stationary.data.ErrorReponse;
import com.stationary.entity.Employee;
import com.stationary.services.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	// Get All Employees
	@GetMapping("/get-all-employees")
	public APIResponse getAllEmployees() {
		try {
			return empService.getAllEmployees();
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	    
	}
	
	// Create a new Employee
	@PostMapping("/create-new-employee")
	public APIResponse createNote(@Valid @RequestBody Employee employee) {
		try {
			return empService.addNewEmployee(employee);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	    
	}
	
	// Get a Single Employee
	@GetMapping("/employees/{id}")
	public APIResponse getEmployeeById(@PathVariable(value = "id") Long empId) {
		try {
			return empService.getEmpById(empId);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	}
	
	// Update a Employee
	@PutMapping("/employees/{id}")
	public APIResponse updateEmployee(@PathVariable(value = "id") Long empId,
	                                        @Valid @RequestBody Employee employeeDetails) {
		try {
			return empService.updateEmpById(empId,employeeDetails);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	 }
	
	// Delete a Employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long empId) {
		empService.deleteEmployeeById(empId);
	    return ResponseEntity.ok().build();
	}
}
