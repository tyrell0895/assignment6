package com.meritamerica.assignment6.models;

import javax.persistence.Entity;

import com.meritamerica.assignment6.models.BankAccount;
@Entity
public class CheckingAccount extends BankAccount {


	static final double DEFAULT_INTEREST_RATE = .0001;
	
	
	public CheckingAccount() {
		super(); 
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}


}