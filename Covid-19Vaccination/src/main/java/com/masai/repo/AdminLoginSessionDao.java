package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.AdminLoginSession;

public interface AdminLoginSessionDao extends JpaRepository<AdminLoginSession, Integer>{

public AdminLoginSession findByAdminId(Integer adminId) ;
	
	public AdminLoginSession findByUuid(String key) ;

}
