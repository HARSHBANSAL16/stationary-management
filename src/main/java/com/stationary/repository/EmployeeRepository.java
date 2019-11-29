package com.stationary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationary.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
