package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Inventory;
import com.masai.model.Vaccine;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.InventoryDao;
import com.masai.repo.VaccineDao;


@Service
public class VaccineInventryServiceImpl implements VaccineInventryService{

	@Autowired
	private AdminLoginSessionDao als;
	
	@Autowired
	private VaccineDao vacc;
	
	@Autowired
	private InventoryDao inDao;
	
	
	@Override
	public Inventory getVacineByCenter(Integer centerId,String key) {
		
//		if(als.findByUuid(uuid)== null) {
//		throw new LoginException("Please login first as a admin ....");
//	}
		
		return null;
	}

	

	@Override
	public Inventory addVaccineCount(Integer VaccineInventory,Integer count,String key) {
		
//		if(als.findByUuid(uuid)== null) {
//		throw new LoginException("Please login first as a admin ....");
//	}
		
		Optional<Inventory> obj=inDao.findById(VaccineInventory);
		
		if(obj.isEmpty()) {
			
		}
		Inventory res=obj.get();
		res.getVaccinecountList().setQuantity(res.getVaccinecountList().getQuantity()+count);
		return res;
	}

	@Override
	public Inventory updateVaccineInvantory(Integer VaccineInventory,String key) {
		
		return null;
	}

	@Override
	public boolean deleteVaccineInvantory(Integer VaccineInventory,String key) {
//		if(als.findByUuid(uuid)== null) {
//		throw new LoginException("Please login first as a admin ....");
//	}
		
       Optional<Inventory> obj=inDao.findById(VaccineInventory);
		
		if(obj.isEmpty()) {
			
		}
		Inventory res=obj.get();
		inDao.delete(res);
		return true;
		
	}

	@Override
	public List<Inventory> getVaccineInvantoryByDate(LocalDate date,String key) {
		
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		
		List<Inventory> lst= inDao.findByDate(date);
		
		return lst;
		
//		return null;
	}

	@Override
	public Inventory getVaccineInvantoryByVaccine(Vaccine vaccine,String key) {
		
//		if(als.findByUuid(uuid)== null) {
//		throw new LoginException("Please login first as a admin ....");
//	}
	
		Optional<Vaccine> v=vacc.findById(vaccine.getVaccineId());
		
		if(v.isEmpty()) {
			
		}
		
		return v.get().getVaccineCount().getInventory();
		
		
	}

}
