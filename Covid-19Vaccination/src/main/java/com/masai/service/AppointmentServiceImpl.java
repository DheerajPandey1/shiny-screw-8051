package com.masai.service;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.exception.MemberNotFoundException;
import com.masai.model.AdminLoginSession;
import com.masai.model.Appointment;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginSession;
import com.masai.model.Member;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.AppointmentDao;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.MemberDao;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private AdminLoginSessionDao adminLoginSessionDao ;
	
	@Autowired
	private CustomerDao cdao;
	
	@Autowired
	private CustomerLoginSessionDao clsd;
	
	@Autowired
	private MemberDao mdao;
	
	@Override
	public List<Appointment> getAllAppointment(String key) throws AppointmentException {
		// TODO Auto-generated method stub
		 CustomerLoginSession adminLoginSession = clsd.findByUuid(key);
		 
			
			if(adminLoginSession ==null  ) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		List<Appointment> appointments = appointmentDao.findAll();
		if (appointments.size() > 0)
			return appointments;
		else
			throw new AppointmentException("No appointment found");
	}
 

	@Override
	public Appointment getAppointmentByBookingId(Long bookingId, String key) throws AppointmentException {
		// TODO Auto-generated method stub
AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		
		CustomerLoginSession customerLoginSession = clsd.findByUuid(key);
			
//			if(adminLoginSession==null && customerLoginSession==null) {
//				
//				throw new RuntimeException("Unauthorised access");
//			}
			
			
		Optional<Appointment> opt =  appointmentDao.findById(bookingId) ;
		if(opt.isPresent())
			return opt.get();
		else
			throw new AppointmentException("Appointment not found by same booking id!");
		
		
	}

	@Override
	public Appointment addAppointment(Appointment appoinment, String key)
			throws MemberNotFoundException, AppointmentException {
		
		
			// TODO Auto-generated method stub
		
//	          AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
			
			CustomerLoginSession customerLoginSession = clsd.findByUuid(key);
				
//				if( customerLoginSession==null) {
//					
//					throw new RuntimeException("Unauthorised access");
//				}
				
				return appointmentDao.save(appoinment) ;

			
	}

	@Override
	public Appointment updateAppointment(Appointment app, String key) throws AppointmentException {
		// TODO Auto-generated method stub
		CustomerLoginSession customerLoginSession = clsd.findByUuid(key);
		
//		if( customerLoginSession==null) {
//			
//			throw new RuntimeException("Unauthorised access");
//		}
		
		Appointment appointment = appointmentDao.findById(app.getBookingId())
				.orElseThrow(() -> new AppointmentException("Appointment not found!"));

		appointment.setDateofBooking(app.getDateofBooking());
		appointment.setVaccinationCenter(app.getVaccinationCenter());
		appointment.setSlot(app.getSlot());
		return appointmentDao.save(appointment);
	}

	@Override
	public boolean deleteAppointment(Long bookingId, String key) throws AppointmentException {
		// TODO Auto-generated method stub
		
		 AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
			
			CustomerLoginSession customerLoginSession = clsd.findByUuid(key);
				
				if(adminLoginSession==null && customerLoginSession==null) {
					
					throw new RuntimeException("Unauthorised access");
				}
				
				
				Appointment ExitApp = appointmentDao.findById(bookingId)
						.orElseThrow(() -> new AppointmentException("Appointment not found!"));
				appointmentDao.delete(ExitApp);
				return true;
	

//		return false;
	}

}
