package com.stationary.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.entity.Employee;
import com.stationary.exception.ResourceNotFoundException;
import com.stationary.repository.EmployeeRepository;
import com.stationary.services.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmpById(Long empId) {
		return employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	}

	@Override
	public Employee updateEmpById(Long empId, @Valid Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		employee.setPhone(employee.getPhone());

	    Employee updatedEmployee = employeeRepository.save(employee);
	    return updatedEmployee;

	}

	@Override
	public void deleteEmployeeById(Long empId) {
		Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		employeeRepository.delete(employee);

		
	}


}
