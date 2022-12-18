package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repo.IdRepo;
import com.masai.model.AdharCard;
import com.masai.exception.IdCardNotFoundException;
import com.masai.model.PanCard;
import com.masai.model.IdCard;

@Service
public class IdCardServiceImpl implements IdCardService {

	@Autowired
	private IdRepo dao;
	
	@Override
	public IdCard getIdcardByPanNo(String pan, String key) throws IdCardNotFoundException {
		// TODO Auto-generated method stub
		PanCard obj=new PanCard();
		obj.setPanNumber(pan);
		IdCard idcard = dao.findByPanCard(obj);
		if (idcard == null)
			throw new IdCardNotFoundException("NO record found with the pan :" + pan);
		else
			return idcard;
		
	}

	@Override
	public IdCard getIdCardByAdharNo(Long adhar, String key) throws IdCardNotFoundException {
		// TODO Auto-generated method stub
		AdharCard obj=new AdharCard();
		obj.setAdhaarNo(adhar);
		
		IdCard idcard = dao.findByAdharCard(obj);
		if (idcard == null)
			throw new IdCardNotFoundException("No record found with the adhar :" + adhar);
		else
			return idcard;
	}

	@Override
	public IdCard addIdCard(IdCard idCard, String key)
			throws com.masai.exception.IdCardNotRegisterException {
		// TODO Auto-generated method stub
		IdCard id = dao.findByPanCard(idCard.getPanCard());
		if (id != null) {
			throw new com.masai.exception.IdCardNotRegisterException("PAN Number : " + idCard.getPanCard() + "already exists" );
		}
		IdCard id2 = dao.findByAdharCard(idCard.getAdharCard());
		if (id2 != null) {
			throw new com.masai.exception.IdCardNotRegisterException("Adhar Number : " + idCard.getPanCard() + "already exists" );
		}
			

		return dao.save(idCard);

	}





}
