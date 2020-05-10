package com.meritamerica.assignment6.models;

public class WithdrawTransaction extends Transaction {
	// used for creation the specific object of Withdraw Transaction
	
	public WithdrawTransaction(long targetNum, long sourceNum, double amountNum, java.util.Date date) {
		super(targetNum, sourceNum, amountNum, date);
	}
	
	public void process() {
		BankAccount source = this.getSourceAccount();
		if(this.getSourceAccount() instanceof CheckingAccount) {
			source = (CheckingAccount) this.getSourceAccount();
		}
		
		if(this.getSourceAccount() instanceof SavingsAccount) {
			source = (SavingsAccount) this.getSourceAccount();
		}
		
		if(this.getSourceAccount() instanceof CDAccount) {
			source = (CDAccount) this.getSourceAccount();
		}
		double currentBal = source.getBalance();
		source.setBalance(currentBal + this.getAmount());
		DepositTransaction copy = new DepositTransaction(this.getTargetAccountNum(), this.getSourceAccountNum(), this.getAmount(), this.getTransactionDate());
		
		source.addTransaction(copy);
		MeritBank.setBankAccount(source, this.getSourceAccountNum());
	}
}
