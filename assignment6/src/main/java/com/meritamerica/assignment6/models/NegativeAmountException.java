package com.meritamerica.assignment6.models;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegativeAmountException extends Exception {
	public NegativeAmountException(String message) {
		super(message);
	}
}
