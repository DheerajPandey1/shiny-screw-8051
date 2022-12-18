package com.masai.service;

//import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {

//	@Service
     public Admin registerAdmin(Admin admin)  ;
	
	public Admin updateAdmin(Admin admin)throws AdminException ;
	
	public Admin getAdminById(Integer adminId)throws AdminException ;
	
	public Admin deleteAdminById(Integer adminId)throws AdminException ;
}
