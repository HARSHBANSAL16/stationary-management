package com.stationary.services;

import java.util.List;

import com.stationary.data.ErrorReponse;
import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Employee;

public interface EmpService {

//	List<Employee> getAllEmployees();

//	APIResponse addNewEmployee(Employee employee);

	Employee getEmpDtlById(Long empId);

//	APIResponse updateEmpById(Long empId, @Valid Employee employeeDetails);

//	void deleteEmployeeById(Long empId);

	List<EmpStationaryHistory> createEmpHist(List<EmpStationaryHistory> empStationaryHistoryList);

	List<EmpStationaryHistory> getEmpHistById(Long empId);

	List<EmpStationaryHistory> getAllEmpHistBy();

	
}
