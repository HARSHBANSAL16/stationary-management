package com.stationary.services;

import javax.validation.Valid;

import com.stationary.data.APIResponse;
import com.stationary.entity.Employee;

public interface EmpService {

	APIResponse getAllEmployees();

	APIResponse addNewEmployee(Employee employee);

	APIResponse getEmpById(Long empId);

	APIResponse updateEmpById(Long empId, @Valid Employee employeeDetails);

	void deleteEmployeeById(Long empId);

	
}
