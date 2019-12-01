package com.stationary.services;

import java.util.List;

import com.stationary.entity.EmpStationaryHistory;
import com.stationary.entity.Inventory;

public interface InventoryService {

	List<Inventory> getInventoryDetails();

	List<Inventory> upDateInventory(List<EmpStationaryHistory> empStationaryHistoryList);

}
