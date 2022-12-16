package com.masai.model;

public class AdharCard {

	private Long adhaarNo;

	public Long getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(Long adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public AdharCard(Long adhaarNo) {
		super();
		this.adhaarNo = adhaarNo;
	}

	@Override
	public String toString() {
		return "AdharCard [adhaarNo=" + adhaarNo + "]";
	}
	
	public AdharCard() {
		
	}
}
