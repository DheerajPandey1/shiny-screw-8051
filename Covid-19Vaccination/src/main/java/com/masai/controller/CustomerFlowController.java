package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AppointmentException;
import com.masai.exception.CustomerException;
import com.masai.exception.IdCardNotRegisterException;
import com.masai.exception.MemberNotFoundException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.Appointment;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.service.AppointmentService;
import com.masai.service.CustomerService;
import com.masai.service.IdCardService;
import com.masai.service.LoginServiceImpl;
import com.masai.service.MemberService;
import com.masai.service.VaccineRegistrationService;

@RestController
@RequestMapping("/customerFlow")
public class CustomerFlowController {

	@Autowired
	private VaccineRegistrationService ser;
	
	@Autowired 
	LoginServiceImpl loginService ;
	
	@Autowired
	private IdCardService ids;
	
	@Autowired
	private CustomerService cudao;
	
	@Autowired
	private AppointmentService as;
	
	@Autowired
	private MemberService ms;
	
	@PostMapping("/customeradd")
	public ResponseEntity<Customer>addNewCustomer(@Valid @RequestBody Customer customer)throws CustomerException{
		Customer custome=cudao.registerCustomer(customer);
		return new ResponseEntity <Customer> (custome, HttpStatus.OK); 
	}

	@PostMapping("/customerLogin")
	public ResponseEntity<String> customerLogging(@RequestBody CustomerDTO cusstomerDto){
		String str =  loginService.CustomerLoggin(cusstomerDto);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED) ;
	}
	
	@DeleteMapping("/customerLogin/{key}")
	public ResponseEntity<String> customerLoggedOut(@PathVariable("key") String key){
		
		String str = loginService.customerLoggedOut(key);
		
		return new ResponseEntity<>(str , HttpStatus.OK) ;
	}
	
	@PostMapping("/addidcar/{key}")
	public ResponseEntity<Customer>addId(@RequestBody IdCard idCard ,@PathVariable ("key") String key )throws IdCardNotRegisterException{
		Customer ic=ids.addIdCard(idCard,key );
		
		return new ResponseEntity <>(ic,HttpStatus.ACCEPTED);
	}
	
	 @PostMapping("/registration/{mobile}/{key}")
	   public ResponseEntity<Member> addRegistration( @PathVariable("mobile") String m,@RequestParam("key") String key) throws VaccineRegistrationException{
		   
		      return new ResponseEntity<>(ser.addVaccineRegistration(m,key), HttpStatus.OK);
	   }
	
	@GetMapping("/getAppointment/{key}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("key") String key) throws AppointmentException, MemberNotFoundException {
		
		Appointment app =  as.addAppointment( key) ;
		
		return new ResponseEntity<>(app,HttpStatus.ACCEPTED);
	}

	@PostMapping("/addmember")
	public ResponseEntity<Member>addmember(@RequestBody Member member)throws MemberNotFoundException{
		Member m1=ms.addMember(member);
		return new ResponseEntity <Member>(m1,HttpStatus.OK);
	}
	
	@GetMapping("/statusget/{key}")
	public ResponseEntity<Member>memberStatus(@PathVariable("key") String key)throws CustomerException{
		Member c=cudao.getmemberstatus(key);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}
	
	
	
}
