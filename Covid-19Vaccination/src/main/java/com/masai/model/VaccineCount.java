package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineCount {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccinecountId;
	private Integer quantity;
	private Double price;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Inventory inventory;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;

	public Integer getVaccinecountId() {
		return vaccinecountId;
	}

	public void setVaccinecountId(Integer vaccinecountId) {
		this.vaccinecountId = vaccinecountId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public VaccineCount(Integer vaccinecountId, Integer quantity, Double price, Inventory inventory, Vaccine vaccine) {
		super();
		this.vaccinecountId = vaccinecountId;
		this.quantity = quantity;
		this.price = price;
		this.inventory = inventory;
		this.vaccine = vaccine;
	}

	@Override
	public String toString() {
		return "VaccineCount [vaccinecountId=" + vaccinecountId + ", quantity=" + quantity + ", price=" + price
				+ ", inventory=" + inventory + ", vaccine=" + vaccine + "]";
	}
	public VaccineCount() {
		
	}
	
	
}
