package com.meritamerica.assignment6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//Need a one to many relation with CD account 
@Entity
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cd_offering")
	private long id;
	
	private int term;
    private double interestRate;
    

    

    public CDOffering(){}

    
    public CDOffering(int term, double interestRate){
        this.term = term;
        this.interestRate = interestRate;
    }

    public int getTerm(){
        return this.term;
    }

    public double getInterestRate(){
        return this.interestRate;
    }
    
    public void setTerm(int term) {
    	this.term = term;
    }
    
    public void setInterestRate(double interest) {
    	this.interestRate = interest;
    }

    public String toString(){
        return "Term: " + this.getTerm() + " Interest Rate: " + this.getInterestRate();
    }
    
    static CDOffering readFromString(String accountData) {
    	
    	String array1[] = accountData.split(",");
    	int fTerm = Integer.parseInt(array1[0]);
    	double fInterest = Double.parseDouble(array1[1]);
    	
    	CDOffering offeringX = new CDOffering(fTerm, fInterest);
    	return offeringX;
    	
    }
	
	public String writeToString() {
    	return this.term + "," + this.interestRate;
    }
}
