package com.masai.controller;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AppointmentException;
import com.masai.exception.CustomerException;
import com.masai.exception.IdCardNotFoundException;
import com.masai.exception.IdCardNotRegisterException;
import com.masai.exception.MemberNotFoundException;
import com.masai.model.Appointment;
import com.masai.model.Customer;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.service.AppointmentService;
import com.masai.service.CustomerService;
import com.masai.service.IdCardService;
import com.masai.service.MemberService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private IdCardService ids;
	
	@Autowired
	private CustomerService cudao;
	
	@Autowired
	private AppointmentService as;
	
	@Autowired
	private MemberService ms;
	
	
	@PostMapping("/customeradd")
	public ResponseEntity<Customer>saveCustomer(@Valid @RequestBody Customer customer)throws CustomerException{
		Customer custome=cudao.registerCustomer(customer);
		return new ResponseEntity <Customer> (custome, HttpStatus.OK); 
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer>UpdateCustomer(@Valid @RequestBody Customer customer)throws CustomerException {
		Customer cu=cudao.updateCustomer(customer);
		return new ResponseEntity<Customer> (cu,HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer>getCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer cust=cudao.getCustomerById(customerId);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer>deleteCustomer(@PathVariable("customerId")Integer customerId )throws CustomerException{
		Customer customer=cudao.deleteCustomerById(customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
//	Appointment
	
	@GetMapping("/getAppointment/{bookingId}/{key}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("bookingId") long bookingId ,@PathVariable("key") String key) throws AppointmentException {
		
		Appointment app =  as.getAppointmentByBookingId(bookingId, key) ;
		
		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addappointment/{key}")
	
	public ResponseEntity<Appointment>addapp(@RequestBody Appointment appointment , @PathVariable("key") String key) throws MemberNotFoundException, AppointmentException{
		
		Appointment ap= as.addAppointment(appointment, key);
		
		return new ResponseEntity<Appointment>(ap,HttpStatus.OK);
	}
	
	@PutMapping("/updateAppointment/{key}")
	public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment app ,@PathVariable("key") String key ) throws AppointmentException{
		
		Appointment app2 = as.updateAppointment(app, key) ;
		
		return new ResponseEntity<>(app2,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteAppointment/{bookingId}/{key}")
	public ResponseEntity<String> deleteAppointment(@PathVariable("bookingId") Long bookingId,@PathVariable("key")String key)throws AppointmentException{
		
		boolean ans = as.deleteAppointment(bookingId, key) ;
		
		 return new ResponseEntity<String>("Appointment Deleted succesfully", HttpStatus.GONE) ;
	}
	

	
	
	
	
//	Id
	@GetMapping("/idby/{AdharNo}") 
	 public ResponseEntity<IdCard>findByAdhar(@PathVariable Long AdharNo ,@RequestParam String key)throws IdCardNotFoundException{
		 IdCard ic=ids.getIdCardByAdharNo(AdharNo, key);
		 return new ResponseEntity<IdCard>(ic,HttpStatus.FOUND);
	 }
		
	 @GetMapping("/idcard/{PanNo}")
	 public ResponseEntity<IdCard>findByPan(@PathVariable String PanNo,@RequestParam String key)throws IdCardNotFoundException{
		 IdCard ic=ids.getIdcardByPanNo(PanNo, key);
		 return new ResponseEntity<IdCard>(ic,HttpStatus.FOUND);
	 }
		
	@PostMapping("/addidcar/{key}")
	public ResponseEntity<Customer>addId(@RequestBody IdCard idCard ,@PathVariable ("key") String key )throws IdCardNotRegisterException{
		Customer ic=ids.addIdCard(idCard,key );
		
		return new ResponseEntity <>(ic,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/allAppointments/{key}")
	public ResponseEntity<List<Appointment>> getAllAppointments(@PathVariable("key") String key) throws AppointmentException {
		
		List<Appointment> app = as.getAllAppointment(key);
		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
//	member
	
	@PostMapping("/addmember")
	public ResponseEntity<Member>addmember(@RequestBody Member member)throws MemberNotFoundException{
		Member m1=ms.addMember(member);
		return new ResponseEntity <Member>(m1,HttpStatus.OK);
	}
	
	@GetMapping("/IdByAdhar/{AdharNo}")
	public ResponseEntity<IdCard> FindByAdharHandler(@PathVariable Long AdharNo,@RequestParam String key) throws IdCardNotFoundException{
		
		IdCard idc=ids.getIdCardByAdharNo(AdharNo, key);
		return new ResponseEntity<IdCard>(idc,HttpStatus.FOUND);
		
	}
	
	
	
	@GetMapping("/statusget/{key}")
	public ResponseEntity<Member>memberStatus(@PathVariable("key") String key){
		Member c=cudao.getmemberstatus(key);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}
	
	
}
