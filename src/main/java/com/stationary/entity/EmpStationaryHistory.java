package com.stationary.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_stat_hist")
public class EmpStationaryHistory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7144396624642529639L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seqNo = 0L;
	private Long empID;
	private Long itemCode;
	private Long quantity;
	private Date stationaryDate;
	private String note;
	
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
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
		return "EmpStationaryHistory [seqNo=" + seqNo + ", empID=" + empID + ", itemCode=" + itemCode + ", quantity="
				+ quantity + ", stationaryDate=" + stationaryDate + ", note=" + note + "]";
	}
	
}
