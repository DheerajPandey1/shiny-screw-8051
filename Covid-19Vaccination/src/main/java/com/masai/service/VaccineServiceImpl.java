package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Vaccine;
import com.masai.repo.VaccineServiceDao;

public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineServiceDao da;
	
	@Override
	public Vaccine getVaccineByName(String vaccineName, String uuid) {
		
		
		
		return null;
	}

	@Override
	public Vaccine getVaccineById(Integer id, String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine addVaccine(Vaccine v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine updateVaccine(Vaccine v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVaccine(Vaccine v) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
