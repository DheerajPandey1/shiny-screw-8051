package com.masai.model;

public class PanCard {

	private String panNumber;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public PanCard(String panNumber) {
		super();
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "PanCard [panNumber=" + panNumber + "]";
	}
	
	public PanCard() {
		
	}
}
