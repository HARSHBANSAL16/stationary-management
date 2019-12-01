package com.stationary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stationary.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("FROM Employee WHERE empid = ?1")
	Employee findEmpId(Long empId);

}
