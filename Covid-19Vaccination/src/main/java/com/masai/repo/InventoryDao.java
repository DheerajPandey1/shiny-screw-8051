package com.masai.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Inventory;

public interface InventoryDao extends JpaRepository<Inventory, Integer> {

	public List<Inventory> findByDate(LocalDate a);
	
}
