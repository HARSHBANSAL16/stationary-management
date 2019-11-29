package com.stationary.services;

import java.util.List;

import javax.validation.Valid;

import com.stationary.entity.Employee;

public interface EmpService {

	List<Employee> getAllEmployees();

	Employee addNewEmployee(Employee employee);

	Employee getEmpById(Long empId);

	Employee updateEmpById(Long empId, @Valid Employee employeeDetails);

	void deleteEmployeeById(Long empId);

	
}
