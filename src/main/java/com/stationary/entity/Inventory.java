package com.stationary.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6837870856820439221L;

	@Id
	private Long itemCode;
	
	@NotBlank
	private String itemName;
	
	private String subCategory;
	private Long quantity;
	
	public Long getItemCode() {
		return itemCode;
	}
	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [itemCode=" + itemCode + ", itemName=" + itemName + ", subCategory=" + subCategory
				+ ", quantity=" + quantity + "]";
	}
	
}
