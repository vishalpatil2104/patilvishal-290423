package com.avisys.cim.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.avisys.cim.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	

}
