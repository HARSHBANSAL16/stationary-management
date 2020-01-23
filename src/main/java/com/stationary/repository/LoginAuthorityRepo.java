package com.stationary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationary.entity.LoginAuthority;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
public interface LoginAuthorityRepo extends JpaRepository<LoginAuthority, Integer> {}
