package com.masai.service;

import com.masai.model.Vaccine;

public interface VaccineService {
	public Vaccine getVaccineByName(String vaccineName,String uuid);
	public Vaccine getVaccineById(Integer id,String uuid);
	public Vaccine addVaccine(Vaccine v);
	public Vaccine updateVaccine(Vaccine v);
	public boolean deleteVaccine(Vaccine v);
}
