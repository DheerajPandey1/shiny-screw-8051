package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = "Date should not be Null")
	private LocalDate date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "inventory")
	private List<VaccinationCenter> ListvaccinationCenter;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy= "inventory")
	private VaccineCount vaccinecountList;
	
	
	
	
	

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<VaccinationCenter> getListvaccinationCenter() {
		return ListvaccinationCenter;
	}

	public void setListvaccinationCenter(List<VaccinationCenter> listvaccinationCenter) {
		ListvaccinationCenter = listvaccinationCenter;
	}

	public VaccineCount getVaccinecountList() {
		return vaccinecountList;
	}

	public void setVaccinecountList(VaccineCount vaccinecountList) {
		this.vaccinecountList = vaccinecountList;
	}

	public Inventory(Integer inventoryId, @NotNull(message = "Date should not be Null") LocalDate date,
			List<VaccinationCenter> listvaccinationCenter, VaccineCount vaccinecountList) {
		super();
		this.inventoryId = inventoryId;
		this.date = date;
		ListvaccinationCenter = listvaccinationCenter;
		this.vaccinecountList = vaccinecountList;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", date=" + date + ", ListvaccinationCenter="
				+ ListvaccinationCenter + ", vaccinecountList=" + vaccinecountList + "]";
	}
	
	public Inventory() {
		
	}
	
}


