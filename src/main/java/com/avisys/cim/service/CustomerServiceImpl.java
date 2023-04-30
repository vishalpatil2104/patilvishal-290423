package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		//get mobile no from customer
		String mobileNumber = customer.getMobileNumber();
		
		//check for customer with mobile no already exist or not
        if (customerRepository.findByMobileNumberEquals(mobileNumber).isEmpty()) {
        	
        	//if new mobile no is provided then add customer entry and return to controller
        	return customerRepository.save(customer);
        }
        
        //else return null to controller
        return null;
	}

}
