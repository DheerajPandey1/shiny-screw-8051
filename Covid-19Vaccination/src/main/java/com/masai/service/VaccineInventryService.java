package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.convert.ThreeTenBackPortConverters.LocalTimeToDateConverter;

import com.masai.model.Inventory;
import com.masai.model.Vaccine;



public interface VaccineInventryService {
	
//	Inventory=VaccineInvantory

	public Inventory getVacineByCenter(Integer centerId,String key);
	
	public Inventory addVaccineCount(Integer VaccineInventory,Integer count,String key);
	public Inventory updateVaccineInvantory(Integer VaccineInventory,String key);
	public boolean deleteVaccineInvantory(Integer VaccineInventory,String key);
	public List<Inventory> getVaccineInvantoryByDate(LocalDate date,String key);
	public Inventory getVaccineInvantoryByVaccine(Vaccine vaccine,String key);
	
	
}
