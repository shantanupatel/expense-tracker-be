package com.expense.exception;

@SuppressWarnings("serial")
public class DuplicateEntryException extends RuntimeException {

	public DuplicateEntryException(String message) {
		super(message);
	}

}
