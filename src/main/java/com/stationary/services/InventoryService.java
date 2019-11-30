package com.stationary.services;

import com.stationary.data.APIResponse;
import com.stationary.entity.EmpStationaryHistory;

public interface InventoryService {

	APIResponse getInventoryDetails();

	APIResponse upDateInventory(EmpStationaryHistory empStationaryHistory);

}
