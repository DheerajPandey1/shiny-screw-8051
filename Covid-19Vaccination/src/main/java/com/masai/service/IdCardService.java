package com.masai.service;

import com.masai.exception.IdCardNotFoundException;
import com.masai.exception.IdCardNotRegisterException;
import com.masai.model.IdCard;

public interface IdCardService {
	

	public IdCard getIdcardByPanNo(String panno,String key) throws IdCardNotFoundException;

	public IdCard getIdCardByAdharNo(Long adharno,String key) throws IdCardNotFoundException;

	public IdCard addIdCard(IdCard idCard,String key) throws IdCardNotRegisterException;

}
