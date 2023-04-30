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

	@Override
	public String removeCustomer(String mobileNumber) {
		//get the customer to be delete from mobile number provided
		List<Customer> customerToBeDelete=customerRepository.findByMobileNumberEquals(mobileNumber);
		// check if customer is available for given mobile no.
		
		if(!customerToBeDelete.isEmpty()) {
		//delete the customer to be delete i.e. at 0th index (as mobile no is unique)
		customerRepository.delete(customerToBeDelete.get(0));
		//return proper message to the controller
		return "Customer Entry Deleted";
		}
		else
			return null;
	}

	@Override
	public String updateCustomer(Long id,String mobileNumber) {
		//get the customer to be update from mobile number provided
				Customer customerToBeUpdate=customerRepository.findById(id).orElse(null);
				// check if customer is available for given mobile no.
				
				if(customerToBeUpdate != null) {
				//update the mobile no of customer
					customerToBeUpdate.setMobileNumber(mobileNumber);
					customerRepository.saveAndFlush(customerToBeUpdate);
				//return updated customer details to the controller
						return "Updated";
				}
				else	
				return null;
	}

}
