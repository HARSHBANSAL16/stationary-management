package com.stationary.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Employee;
import com.stationary.exception.ResourceNotFoundException;
import com.stationary.repository.EmpHistoryRepository;
import com.stationary.repository.EmployeeRepository;
import com.stationary.services.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmpHistoryRepository empHistoryRepository;

//	@Override
//	public List<Employee> getAllEmployees() {
//		return employeeRepository.findAll();
//	}

//	@Override
//	public APIResponse addNewEmployee(Employee employee) {
//		return new APIResponse(employeeRepository.save(employee));
//	}

	@Override
	public Employee getEmpById(Long empId) {
		return employeeRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	}

//	@Override
//	public APIResponse updateEmpById(Long empId, @Valid Employee employeeDetails) {
//		Employee employee = employeeRepository.findById(empId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
//		employee.setPhone(employee.getPhone());
//	    return new APIResponse(employeeRepository.save(employee));
//
//	}

//	@Override
//	public void deleteEmployeeById(Long empId) {
//		Employee employee = employeeRepository.findById(empId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
//
//		employeeRepository.delete(employee);
//
//		
//	}

	@Override
	public List<EmpStationaryHistory> createEmpHist(List<EmpStationaryHistory> empStationaryHistoryList) {
		
		for(EmpStationaryHistory e : empStationaryHistoryList) {
			e.setStationaryDate(new Date());
		}
		return empHistoryRepository.saveAll(empStationaryHistoryList);
	}

	@Override
	public List<EmpStationaryHistory> getEmpHistById(Long empId) {
		// TODO Auto-generated method stub
		return empHistoryRepository.findByEmpId(empId);
	}

	@Override
	public List<EmpStationaryHistory> getAllEmpHistBy() {
		// TODO Auto-generated method stub
		return empHistoryRepository.findAll();
	}


}
