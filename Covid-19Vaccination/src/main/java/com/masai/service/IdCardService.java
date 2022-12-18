package com.masai.service;

import com.masai.exception.IdCardNotFoundException; 
import com.masai.exception.IdCardNotRegisterException;
import com.masai.model.Customer;
import com.masai.model.IdCard;
import com.masai.model.Member;

public interface IdCardService {


	public IdCard getIdcardByPanNo(String panNumber,String key) throws IdCardNotFoundException;

	public IdCard getIdCardByAdharNo(Long adharnumber,String key) throws IdCardNotFoundException;

	public Customer addIdCard(IdCard idCard,String key) throws IdCardNotRegisterException;
	
//	public boolean memberDefault (Member m); 
		
	

}


