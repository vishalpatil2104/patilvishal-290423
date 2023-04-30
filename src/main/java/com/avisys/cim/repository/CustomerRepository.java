package com.avisys.cim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

    List<Customer> findByLastNameContainingIgnoreCase(String lastName);

    List<Customer> findByMobileNumberEquals(String mobileNumber);

    List<Customer> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

    List<Customer> findByFirstNameContainingIgnoreCaseAndMobileNumberEquals(String firstName, String mobileNumber);

    List<Customer> findByLastNameContainingIgnoreCaseAndMobileNumberEquals(String lastName, String mobileNumber);

    List<Customer> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndMobileNumberEquals(
            String firstName, String lastName, String mobileNumber);
    
    //Customer findByMobileNumber(String mobileNumber);
    
//    @Query("SELECT c FROM Customer c WHERE c.mobileNumber = :mobileNumber")
//    Customer searchByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
