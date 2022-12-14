package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.VaccinationCenter;

public interface VaccineCenterDao extends JpaRepository<VaccinationCenter, Integer>{

}
