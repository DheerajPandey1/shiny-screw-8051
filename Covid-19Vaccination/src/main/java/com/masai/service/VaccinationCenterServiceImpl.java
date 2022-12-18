package com.masai.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineCenterException;
import com.masai.exception.VaccineCenterNotFoundException;
import com.masai.model.Admin;
import com.masai.model.AdminLoginSession;
import com.masai.model.CustomerLoginSession;
import com.masai.model.VaccinationCenter;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.VaccinationCenterDao;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{
	
	@Autowired
	private VaccinationCenterDao vDao;
	
	@Autowired
	private AdminLoginSessionDao aDao;
	
	@Autowired
	private CustomerLoginSessionDao cDao;
	
	@Override
	public List<VaccinationCenter> allVaccineCenters(String key) throws VaccineCenterException {
		AdminLoginSession adminLoginSession = aDao.findByUuid(key);
		CustomerLoginSession customerLoginSession = cDao.findByUuid(key);
		
		if(adminLoginSession == null &&  customerLoginSession ==null) {
			throw new LoginException("Unauthorised Access");
		}
		
		
			
		
		List<VaccinationCenter> list = vDao.findAll();
		if (list.size() == 0)
			throw new VaccineCenterException("No Vaccination Center Found...");
		return list;
	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerid, String key) throws VaccineCenterException {
		AdminLoginSession adminLoginSession = aDao.findByUuid(key);
		CustomerLoginSession customerLoginSession = cDao.findByUuid(key);
		
		if(adminLoginSession == null &&  customerLoginSession ==null) {
			throw new LoginException("Unauthorised Access");
		}
		
			
	
		return vDao.findById(centerid).orElseThrow(
				() -> new VaccineCenterNotFoundException("No vaccination center is found by the id : " + centerid));
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center, String key) throws VaccineCenterException {
		AdminLoginSession adminLoginSession = aDao.findByUuid(key);
		
//		if(adminLoginSession == null ) {
//			throw new LoginException("Unauthorised Access");
//		}
		
		
		  
	      
		
		Optional<VaccinationCenter> vc = vDao.findById(center.getCenterId());

		if (vc.isPresent()) {
			throw new VaccineCenterException("Vaccination center is present with the same Id");
		}
		return vDao.save(center);
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center, String key) throws VaccineCenterException {
		AdminLoginSession adminLoginSession = aDao.findByUuid(key);
		
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
	public boolean deleteVaccineCenter(VaccinationCenter center, String key) throws VaccineCenterException {
		AdminLoginSession adminLoginSession = aDao.findByUuid(key);
		
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
