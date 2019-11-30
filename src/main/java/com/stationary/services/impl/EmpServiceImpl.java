package com.stationary.services.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.data.APIResponse;
import com.stationary.entity.Employee;
import com.stationary.exception.ResourceNotFoundException;
import com.stationary.repository.EmployeeRepository;
import com.stationary.services.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public APIResponse getAllEmployees() {
		return new APIResponse(employeeRepository.findAll());
	}

	@Override
	public APIResponse addNewEmployee(Employee employee) {
		return new APIResponse(employeeRepository.save(employee));
	}

	@Override
	public APIResponse getEmpById(Long empId) {
		return new APIResponse(employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId)));
	}

	@Override
	public APIResponse updateEmpById(Long empId, @Valid Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
		employee.setPhone(employee.getPhone());
	    return new APIResponse(employeeRepository.save(employee));

	}

	@Override
	public void deleteEmployeeById(Long empId) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		employeeRepository.delete(employee);

		
	}


}
