package com.meritamerica.assignment6.controller; 

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.meritamerica.assignment6.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment6.exceptions.NotFoundException;
import com.meritamerica.assignment6.models.*;
import com.meritamerica.assignment6.repos.*;

@RestController
public class MeritBankController {
	List<String> strings = new ArrayList<String>(); 
	
	@Autowired
	private AccountHolderContactDetailsRepository accountHolderContactRepo;
	@Autowired
	private AccountHolderRepository accountHolderRepo;
	@Autowired
	private CDAccountRepository cdAccountRepo;
	@Autowired
	private CDOfferingRepository cdOfferingRepo;
	@Autowired
	private CheckingAccountRepository checkingAccountRepo;
	@Autowired
	private SavingsAccountRepository savingsAccountRepo;
	
	

	
	@GetMapping(value = "/AccountHolders")

	public List<AccountHolder> getAccountHolders(){

		return accountHolderRepo.findAll();

	}
	
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		accountHolderRepo.save(accountHolder);
		return accountHolder; 
	}
	
	@PostMapping(value = "/ContactDetails")
	@ResponseStatus(HttpStatus.CREATED)
	public void addContactDetails(@RequestBody @Valid AccountHolderContactDetails contactDetails) {
		accountHolderContactRepo.save(contactDetails);
	}
	
	@GetMapping(value = "/ContactDetails")
	public List<AccountHolderContactDetails> getContactDetails(){
		return accountHolderContactRepo.findAll();
	}
	
	//Check URL Mapping
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getACById(@PathVariable (name = "id" )long id)  throws NotFoundException {
			 
		return accountHolderRepo.findById(id); 
		}
	
	@PostMapping(value ="/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder acctH = accountHolderRepo.findById(id); 
		acctH.addCheckingAccount(checkingAccount);
		checkingAccountRepo.save(checkingAccount); 
		return checkingAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		return checkingAccountRepo.findByAccountholder(id);
		 
	}
	@PostMapping(value ="/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@RequestBody @Valid SavingsAccount savingsAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder acctH = accountHolderRepo.findById(id);
		acctH.addSavingsAccount(savingsAccount); 
		savingsAccountRepo.save(savingsAccount);
		return savingsAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		return savingsAccountRepo.findByAccountholder(id);
		
		
	}
	
	@PostMapping(value ="/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@RequestBody @Valid CDAccount cdAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder acctHolder = accountHolderRepo.findById(id); 
		acctHolder.addCDAccount(cdAccount);
		cdAccountRepo.save(cdAccount);
		
		return cdAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		return cdAccountRepo.findByAccountholder(id);
		
	}
	
	@PostMapping(value ="/CDOffering")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		cdOfferingRepo.save(cdOffering); 
		return cdOffering; 
	}
	
	@GetMapping(value = "/CDOffering")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOffering() throws NotFoundException {
		return cdOfferingRepo.findAll(); 
	}
	
		

}
