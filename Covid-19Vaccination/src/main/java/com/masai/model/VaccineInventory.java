package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = "Date should not be Null")
	private LocalDate date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "inventory")
	private List<VaccinationCenter> ListvaccinationCenter;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "inventory")
	private List<VaccineCount> vaccinecountList;
}
