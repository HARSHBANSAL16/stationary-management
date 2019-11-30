package com.stationary.services;

import java.util.List;

import javax.validation.Valid;

import com.stationary.data.APIResponse;
import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Employee;

public interface EmpService {

//	List<Employee> getAllEmployees();

//	APIResponse addNewEmployee(Employee employee);

	Employee getEmpById(Long empId);

//	APIResponse updateEmpById(Long empId, @Valid Employee employeeDetails);

//	void deleteEmployeeById(Long empId);

	EmpStationaryHistory createEmpHist(EmpStationaryHistory empStationaryHistory);

	
}
