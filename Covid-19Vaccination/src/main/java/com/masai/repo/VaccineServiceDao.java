package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Vaccine;

@Repository
public interface VaccineServiceDao extends JpaRepository<Vaccine, Integer> {

	
	
}
