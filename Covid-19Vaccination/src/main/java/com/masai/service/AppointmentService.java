package com.masai.service;

import java.util.List;

import com.masai.exception.AppointmentException;
import com.masai.exception.MemberNotFoundException;
import com.masai.model.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointment(String key) throws AppointmentException;

	public Appointment getAppointmentByBookingId(Long bookingId,String key)throws AppointmentException;;

	public Appointment addAppointment(Appointment appointment,String key) throws MemberNotFoundException, AppointmentException;

	public Appointment updateAppointment(Appointment app,String key)throws AppointmentException;;

	public boolean deleteAppointment(Long bookingId,String key)throws AppointmentException;


}
