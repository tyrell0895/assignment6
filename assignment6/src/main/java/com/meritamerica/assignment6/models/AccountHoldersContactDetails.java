package com.meritamerica.assignment6.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Contact_Details", catalog = "assignment6")
public class AccountHoldersContactDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "contact_id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", referencedColumnName = "accountHolder_id" )
	private AccountHolder accountHolder;
	
	@Column(name = "contact_email")
	private String email;
	
	public AccountHoldersContactDetails() {}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String firstName) {
		this.email = firstName;
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	


}
