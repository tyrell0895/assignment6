package com.meritamerica.assignment6.models;

public class ExceedsAvailableBalanceException extends Exception {
	public ExceedsAvailableBalanceException(String message) {
		super(message);
	}
}
