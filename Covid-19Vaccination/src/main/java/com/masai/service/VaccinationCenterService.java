package com.masai.service;

import java.util.List;

import com.masai.exception.VaccineCentreException;
import com.masai.model.VaccinationCenter;

public interface VaccinationCenterService {
	public List<VaccinationCenter> allVaccineCenters(String key) throws VaccineCentreException;

	public VaccinationCenter getVaccineCenter(Integer centerid,String key) throws VaccineCentreException;

	public VaccinationCenter addVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;

	public VaccinationCenter updateVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;

	public boolean deleteVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;
}
