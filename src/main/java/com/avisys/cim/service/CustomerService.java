package com.avisys.cim.service;

import com.avisys.cim.Customer;


public interface CustomerService {
	
	//method to create customer entry
	public Customer addCustomer(Customer customer);
	
	//method to remove customer entry
	public String removeCustomer(String mobileNumber);
	
	//method to update existing customer mobile number
	public String updateCustomer(Long id,String mobileNumber);
}
