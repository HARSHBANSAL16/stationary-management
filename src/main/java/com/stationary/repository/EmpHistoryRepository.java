package com.stationary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationary.entity.EmpStationaryHistory;

public interface EmpHistoryRepository extends JpaRepository<EmpStationaryHistory, Long>{

}
