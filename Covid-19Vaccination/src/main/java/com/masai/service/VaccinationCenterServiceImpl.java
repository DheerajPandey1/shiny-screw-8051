package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VaccineCenterNotFoundException;
import com.masai.exception.VaccineCentreException;
import com.masai.model.VaccinationCenter;
import com.masai.repo.VaccineCenterDao;

@Service
public class VaccinationCenterServiceImpl implements  VaccinationCenterService{
	
	@Autowired
	private VaccineCenterDao vDao;
	
	@Autowired
	private AdminLoginSessionDao adminLoginSessionDao;
	
	@Autowired
	private CustomerLoginSessionDao customerLoginSessionDao;

	@Override
	public List<VaccinationCenter> allVaccineCenters(String key) throws VaccineCentreException {
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		CustomerLoginSession customerLoginSession = customerLoginSessionDao.findByUuid(key);
		
		if(adminLoginSession == null &&  customerLoginSession ==null) {
			throw new LoginException("Unauthorised Access");
		}	
		
		List<VaccinationCenter> list = vDao.findAll();
		if (list.size() == 0)
			throw new VaccineCentreException("No Vaccination Center Found...");
		return list;
	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerid, String key) throws VaccineCentreException {
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		CustomerLoginSession customerLoginSession = customerLoginSessionDao.findByUuid(key);
		
		if(adminLoginSession == null &&  customerLoginSession ==null) {
			throw new LoginException("Unauthorised Access");
		}
		
			
	
		return vDao.findById(centerid).orElseThrow(
				() -> new VaccineCenterNotFoundException("No vaccination center is found by the id : " + centerid));
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center, String key) throws VaccineCentreException {
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		
		if(adminLoginSession == null ) {
			throw new LoginException("Unauthorised Access");
		}
		
		Optional<VaccinationCenter> vc = vDao.findById(center.getCenterId());

		if (vc.isPresent()) {
			throw new VaccineCentreException("Vaccination center is present with the same Id");
		}
		return vDao.save(center);
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center, String key) throws VaccineCentreException {
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		
		if(adminLoginSession == null ) {
			throw new LoginException("Unauthorised Access");
		}
		
	
		Optional<VaccinationCenter> vc = vDao.findById(center.getCenterId());

		if (vc.isPresent()) {
			return vDao.save(center);
		} else
			throw new VaccineCenterNotFoundException("Vaccination center is not present with the same Id");
	}

	@Override
	public boolean deleteVaccineCenter(VaccinationCenter center, String key) throws VaccineCentreException {
		AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		
		if(adminLoginSession == null ) {
			throw new LoginException("Unauthorised Access");
		}
		
	
		Optional<VaccinationCenter> vc = vDao.findById(center.getCenterId());

		if (vc.isPresent()) {
			vDao.delete(center);
			return true;
		} else
			throw new VaccineCenterNotFoundException("Vaccination center is not present with the same Id");
	
	}

}
