package com.avisys.cim;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
	private String mobileNumber;
	
//	@Column(name = "ALT_MOBILE_NUMBER", unique = true, nullable = false)
//	private String alternateMobileNumber;
	
//	@OneToMany(mappedBy = "customer")
//    private List<MobileNumber> mobileNumbers = new ArrayList<>();
//
//	public List<MobileNumber> getMobileNumbers() {
//		return mobileNumbers;
//	}
//
//	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
//		this.mobileNumbers = mobileNumbers;
//	}

//	public String getAlternateMobileNumber() {
//		return alternateMobileNumber;
//	}
//
//	public void setAlternateMobileNumber(String alternateMobileNumber) {
//		this.alternateMobileNumber = alternateMobileNumber;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
