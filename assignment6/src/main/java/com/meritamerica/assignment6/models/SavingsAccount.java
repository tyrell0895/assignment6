package com.meritamerica.assignment6.models;

import javax.persistence.Entity;

import com.meritamerica.assignment6.models.BankAccount;
@Entity
public class SavingsAccount extends BankAccount {
	static final double DEFAULT_INTEREST_RATE = .01;
	
	
	
	
	public SavingsAccount() { 
		super();
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}


}
