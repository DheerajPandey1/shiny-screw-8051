package com.masai.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Appointment;
import com.masai.model.Member;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

	 public List<Appointment> findByMember(Member member);

	  Optional<Appointment> findByBookingId(Long bookingId);
}
