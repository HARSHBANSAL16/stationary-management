package com.stationary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationary.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
