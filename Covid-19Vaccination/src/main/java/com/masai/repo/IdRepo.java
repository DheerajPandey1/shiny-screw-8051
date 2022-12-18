package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.AdharCard;
import com.masai.model.IdCard;
import com.masai.model.PanCard;

//import com.masai.model.IdCard;

public interface IdRepo extends JpaRepository<IdCard,Integer> {

	public IdCard findByPanCard(PanCard pancard);

	public IdCard findByAdharCard(AdharCard adharcard);

}
