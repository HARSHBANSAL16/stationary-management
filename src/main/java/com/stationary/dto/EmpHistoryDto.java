package com.stationary.dto;

import java.util.Date;

public class EmpHistoryDto {
	
	private Long empId;
	
	private Long itemCode;
	private Long quantity;
	private Date stationaryDate;
	private String note;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getItemCode() {
		return itemCode;
	}
	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Date getStationaryDate() {
		return stationaryDate;
	}
	public void setStationaryDate(Date stationaryDate) {
		this.stationaryDate = stationaryDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "EmpDto [empId=" + empId + ", itemCode=" + itemCode + ", quantity=" + quantity + ", stationaryDate="
				+ stationaryDate + ", note=" + note + "]";
	}
	
}
