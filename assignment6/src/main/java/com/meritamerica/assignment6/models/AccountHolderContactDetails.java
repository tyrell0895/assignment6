package com.meritamerica.assignment6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_details", catalog = "assignment6")
public class AccountHolderContactDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_Id")
	private Long contactId;
	
	
	private String emailAddress;
	
	private String phoneNumber;

	
	public AccountHolderContactDetails() {}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public AccountHolderContactDetails setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public AccountHolderContactDetails setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

}
