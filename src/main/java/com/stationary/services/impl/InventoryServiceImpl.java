package com.stationary.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Inventory;
import com.stationary.repository.InventoryRepository;
import com.stationary.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	@Override
	public List<Inventory> getInventoryDetails() {
		return inventoryRepository.findAll();
	}
	@Override
	public List<Inventory> upDateInventory(List<EmpStationaryHistory> empStationaryHistoryList) {
		
			
			for(EmpStationaryHistory e : empStationaryHistoryList) {
				Long itmCode = e.getItemCode();
				Inventory resp = inventoryRepository.getOne(itmCode);
				Long finalQty = (resp.getQuantity()) - (e.getQuantity());
				resp.setQuantity(finalQty);
				inventoryRepository.save(resp);
			}
			
//			Long itmCode = empStationaryHistory.getItemCode();
//			
//			Inventory resp = inventoryRepository.getOne(itmCode);
//			
//			Long finalQty = (resp.getQuantity()) - (empStationaryHistory.getQuantity());
//			
//			resp.setQuantity(finalQty);
//			return inventoryRepository.save(resp);
			
			
		return null;
	}
	

}
