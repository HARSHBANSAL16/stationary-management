package com.stationary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stationary.entity.EmpStationaryHistory;

public interface EmpHistoryRepository extends JpaRepository<EmpStationaryHistory, Long>{

	@Query("FROM EmpStationaryHistory WHERE empid = ?1")
	List<EmpStationaryHistory> findByEmpId(Long empID);
}
