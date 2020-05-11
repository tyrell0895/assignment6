package com.meritamerica.assignment6.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
/*
 * import javax.validation.constraints NotBlank; NotEmpty; Max
 */

import com.meritamerica.assignment6.exceptions.ExceedsAvailableBalanceException;
import com.meritamerica.assignment6.exceptions.NegativeAmountException;


@MappedSuperclass
@Table(name = "bank_accounts", catalog = "assignment6")
public class BankAccount {
	
	@Min(0)
	protected double balance;
	
	@DecimalMin("0.0")
	@DecimalMax("0.99999")
	protected double interestRate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long accountNumber;
	
	protected Long accountholder;
	
	public Long getAccountholder() {
		return accountholder;
	}




	public void setAccountholder(Long accountholder) {
		this.accountholder = accountholder;
	}




	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	protected Date accountOpenedOn;
	
	
	public BankAccount() {
		this.accountOpenedOn = new Date();
	}
	
	
	
	
	public boolean withdraw(double amount) 
				throws ExceedsAvailableBalanceException, NegativeAmountException {
		
		if(amount <= 0) { throw new NegativeAmountException(); }
		if(amount > this.balance) { throw new ExceedsAvailableBalanceException(); }
		
		this.balance -= amount;
		return true;
	}
	
	
	
	
	public boolean deposit(double amount) throws NegativeAmountException {
		if(amount <= 0) { throw new NegativeAmountException(); }
		
		this.balance += amount;
		return true;
	}
	
	
	
	public double futureValue(int years) {
		if(years == 0) { return this.balance; }
		return futureValue(years - 1) * (1 + this.interestRate);
	}

	
	public double getBalance() { return balance; }
	public double getInterestRate() { return interestRate; }
	public long getAccountNumber() { return accountNumber; }
	public Date getAccountOpenedOn() { return accountOpenedOn; }

	public void setBalance(double balance) { this.balance = balance; }
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
	public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
	public void setAccountOpenedOn(Date accountOpenedOn) { this.accountOpenedOn = accountOpenedOn; }

	
	

}

