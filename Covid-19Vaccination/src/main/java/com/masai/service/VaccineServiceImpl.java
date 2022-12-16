package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.VaccineNotFoundException;
import com.masai.model.AdminLoginSession;
import com.masai.model.Vaccine;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.VaccineDao;
import com.masai.model.Vaccine;
//import com.masai.main.repo.VaccineServiceDB;


@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineDao dbOprations;
	
	@Autowired
	private AdminLoginSessionDao als;
	
	@Override
	public Vaccine getVaccineByName(String Vname, String uuid) throws VaccineNotFoundException,LoginException {
		
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		
		Vaccine obj= dbOprations.findByVaccineName(Vname);
		if(obj==null) {
			throw new VaccineNotFoundException("No Vaccine found with this name...");
		}
		return obj;
	}

	@Override
	public Vaccine getVaccineById(Integer vId, String uuid)  throws VaccineNotFoundException,LoginException {
		
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		
		Optional<Vaccine> op= dbOprations.findById(vId) ;
		if(op.isEmpty()) {
			throw new VaccineNotFoundException("No vaccine found with this ID "+vId);
		}
		return op.get();
	}

	@Override
	public Vaccine addVaccine(Vaccine v, String uuid)  throws VaccineNotFoundException,LoginException {
		
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		
		if(v==null) {
			throw new VaccineNotFoundException("Please don't pass null Vaccine...");
		}
		return dbOprations.save(v);
	}

	@Override
	public Vaccine updateVaccine(Vaccine v, String uuid)  throws VaccineNotFoundException,LoginException {
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		Optional<Vaccine> op= dbOprations.findById(v.getVaccineId()) ;
		if(op.isEmpty()) {
			throw new VaccineNotFoundException("No vaccine found with this ID "+v.getVaccineId());
		}
		Vaccine res=op.get();
		res.setDescription(v.getDescription());
		res.setVaccineName(v.getVaccineName());
		return res;
	}

	@Override
	public boolean deleteVaccine(Vaccine v, String uuid)  throws VaccineNotFoundException,LoginException {
//		if(als.findByUuid(uuid)== null) {
//			throw new LoginException("Please login first as a admin ....");
//		}
		
		if(dbOprations.findById( v.getVaccineId() ).isEmpty()  ) {
			throw new VaccineNotFoundException("Unable to find Vaccine with this ID "+v.getVaccineId());
		}
		
		dbOprations.delete(v);
		return true;
	}

}
