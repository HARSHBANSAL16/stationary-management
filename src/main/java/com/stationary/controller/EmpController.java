package com.stationary.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.data.APIResponse;
import com.stationary.data.ErrorReponse;
import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Employee;
import com.stationary.services.EmpService;
import com.stationary.services.InventoryService;
import com.stationary.util.AppliationUtil;

@Transactional
@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@Autowired
	private InventoryService inventoryService;
	
	// Get All Employees
	@GetMapping()
	public APIResponse getAllEmployees() {
		//TODO use GlobalException Handler
		try {
//			return service.getAllEmployees();
			return AppliationUtil.getApiRes("msg",service.getAllEmployees());
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	    
	}
	
	// Create a new Employee
	@PostMapping()
	public APIResponse createNote(@Valid @RequestBody Employee employee) {
		try {
			return service.addNewEmployee(employee);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	    
	}
	
	// Get a Single Employee
	@GetMapping("/{id}")
	public APIResponse getEmployeeById(@PathVariable(value = "id") Long empId) {
		try {
			return service.getEmpById(empId);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	}
	
	// Update a Employee
	@PutMapping("/{id}")
	public APIResponse updateEmployee(@PathVariable(value = "id") Long empId,
	                                        @Valid @RequestBody Employee employeeDetails) {
		try {
			return service.updateEmpById(empId,employeeDetails);
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
	 }
	
//	// Delete a Employee
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long empId) {
//		empService.deleteEmployeeById(empId);
//	    return ResponseEntity.ok().build();
//	}
	
	@PostMapping("/history")
	public APIResponse createEmpHistory(@RequestBody EmpStationaryHistory empStationaryHistory){
		try {
			APIResponse resp =service.createEmpHist(empStationaryHistory);
			if(resp.getStatus() == 1) {
				return new APIResponse(inventoryService.upDateInventory(empStationaryHistory));
			}
			return resp;
		} catch (Exception e) {
			return new APIResponse(new ErrorReponse("1", e.getMessage()));
		}
		
	}
}
