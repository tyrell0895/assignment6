package com.meritamerica.assignment6.models;
//Needs a many to one relation with AccountHolder; or do I need the relation with Bank account
import java.text.DecimalFormat;

import javax.persistence.Entity;
@Entity
public class CheckingAccount extends BankAccount{
	//Constructors
    public CheckingAccount(){
        super(0.00, 0.0001);
    }

    public CheckingAccount(double checkingB){
        super(checkingB, 0.0001);
    }
    
    //Methods

    // set amount of years.
    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nChecking Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Checking Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Checking Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
}
