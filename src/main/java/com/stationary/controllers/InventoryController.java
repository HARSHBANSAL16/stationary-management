package com.stationary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.data.APIResponse;
import com.stationary.data.ErrorReponse;
import com.stationary.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/details")
	public APIResponse getAllInventoryDetails() {
		try {
			return new APIResponse(inventoryService.getInventoryDetails());
		} catch (Exception e) {
			return new APIResponse((new ErrorReponse("1", e.getMessage())));
		}
	}

}
