package com.stationary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.data.APIResponse;
import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Inventory;
import com.stationary.repository.InventoryRepository;
import com.stationary.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	@Override
	public APIResponse getInventoryDetails() {
		return new APIResponse(inventoryRepository.findAll());
	}
	@Override
	public APIResponse upDateInventory(EmpStationaryHistory empStationaryHistory) {
		Long itmCode = empStationaryHistory.getItemCode();
		
		Inventory resp = inventoryRepository.getOne(itmCode);
		
		Long finalQty = (resp.getQuantity()) - (empStationaryHistory.getQuantity());
		
		resp.setQuantity(finalQty);
		return new APIResponse(inventoryRepository.save(resp));
		
	}

}
