package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private CustomerRepository customerRepository;

	//Endpoint 1 : To get customers list as per request
	  @GetMapping
	    public List<Customer> getCustomers(
	    		//get request parameter as per user request
	            @RequestParam(name = "firstName", required = false) String firstName,
	            @RequestParam(name = "lastName", required = false) String lastName,
	            @RequestParam(name = "mobileNumber", required = false) String mobileNumber) {

	        List<Customer> customers; //created empty list
	        if (firstName != null && lastName != null && mobileNumber != null) {
	        	//if all fields are enter in request
	            customers = customerRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndMobileNumberEquals(
	                    firstName, lastName, mobileNumber);
	        } else if (firstName != null && lastName != null) {
	        	//if first Name and last Name are enter in request
	            customers = customerRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
	                    firstName, lastName);
	        } else if (firstName != null && mobileNumber != null) {
	        	//if first Name and mobile number are enter in request
	            customers = customerRepository.findByFirstNameContainingIgnoreCaseAndMobileNumberEquals(firstName, mobileNumber);
	        } else if (lastName != null && mobileNumber != null) {
	        	//if last Name and mobile number are enter in request
	            customers = customerRepository.findByLastNameContainingIgnoreCaseAndMobileNumberEquals(lastName, mobileNumber);
	        } else if (firstName != null) {
	        	//if only first Name is enter in request
	            customers = customerRepository.findByFirstNameContainingIgnoreCase(firstName);
	        } else if (lastName != null) {
	        	//if only last Name is enter in request
	            customers = customerRepository.findByLastNameContainingIgnoreCase(lastName);
	        } else if (mobileNumber != null) {
	        	//if only mobile number enter in request
	            customers = customerRepository.findByMobileNumberEquals(mobileNumber);
	        } else {
	        	//if nothing is enter in request
	            customers = customerRepository.findAll();
	        }
	        return customers; //return the populated list as per request
	    }

	//Endpoint 2 : To register customer if mobile no is different
	  @PostMapping("/register")
	  public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
		{
		  //customer is added only if mobile no is not match with existing data
		  Customer addedCustomer = customerService.addCustomer(customer);
		  if(addedCustomer !=null)
			  //if customer entry is created then return created entry details
          return ResponseEntity.ok(addedCustomer);
          
		  //if validation fails then return proper msg with status code 500
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body("Unable to add the Customer. Mobile number already present.");
          
		}

}
