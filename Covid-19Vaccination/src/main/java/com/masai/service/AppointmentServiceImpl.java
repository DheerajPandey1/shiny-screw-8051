package com.masai.service;

import java.time.LocalDate;
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AppointmentException;
import com.masai.exception.CustomerException;
import com.masai.exception.MemberNotFoundException;
import com.masai.model.AdminLoginSession;
import com.masai.model.Appointment;
import com.masai.model.ChooseCenter;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginSession;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.Slot;
import com.masai.model.Vaccine;
import com.masai.repo.AdminLoginSessionDao;
import com.masai.repo.AppointmentDao;
import com.masai.repo.CustomerDao;
import com.masai.repo.CustomerLoginSessionDao;
import com.masai.repo.MemberDao;

@Service
public class AppointmentServiceImpl implements AppointmentService {

//	@Autowired
//	private Vaccine vacc;
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
			
			if(customerLoginSession==null) {
				
				throw new RuntimeException("Please Login first...");
			}
			
			
		Optional<Appointment> opt =  appointmentDao.findById(bookingId) ;
		if(opt.isPresent())
			return opt.get();
		else
			throw new AppointmentException("Appointment not found by same booking id!");
		
		
	}

	@Override
	public Appointment addAppointment( String key)
			throws MemberNotFoundException, AppointmentException {
		
		
			// TODO Auto-generated method stub
		
//	          AdminLoginSession adminLoginSession = adminLoginSessionDao.findByUuid(key);
		
	
		CustomerLoginSession clas =clsd.findByUuid(key);
		if(clas==null) {
			throw new MemberNotFoundException("Please login first..");
		}
			int i= clas.getCustomerId();
			Optional<Customer> c=cdao.findById(i);
			Customer cr = c.get();
		  
			IdCard idcar=cr.getIdcard();
			Member memb=idcar.getMember();
			
		Appointment ap=new Appointment();
		
		ap.setMobileNumber(memb.getVaccineRegistration().getMobileNumber());
		ap.setDateofBooking(LocalDate.now());
		
	
		ap.setSlot(Slot.SLOT1);
		ap.setBookingStatus(true);
		ap.setChoosecenter(ChooseCenter.Sanjeevni);
		
		Boolean tem=true;
		memb.setAppointment(ap);
		if(memb.getDose1status().equals(tem)|| memb.getDose1status()==tem ) {
			memb.setDose2date(LocalDate.now());
			memb.setDose2status(true);
			
			memb.setVaccineName("fighter");
		}
		else {
			memb.setDose1date(LocalDate.now());
			memb.setDose1status(true);
//			memb.setVaccineName("fighter");
		}
		
	
		
		
				return appointmentDao.save(ap);

			
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
