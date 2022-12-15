package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

@Service
public interface AdminService {

//public Admin createAdmin(Admin admin)throws AdminException;
	
//	public Admin updateAdmin(Admin admin,String key)throws AdminException;

public Admin registerAdmin(Admin admin)  ;

public Admin updateAdmin(Admin admin)throws AdminException ;

public Admin getAdminById(Integer adminId)throws AdminException ;

public Admin deleteAdminById(Integer adminId)throws AdminException ;
}
