package com.expense.exception;

public class ErrorResponse {

	private int HttpStatus;
	private String message;

	public ErrorResponse(String message, int httpStatus) {
		super();
		HttpStatus = httpStatus;
		this.message = message;
	}

	public int getHttpStatus() {
		return HttpStatus;
	}

	public String getMessage() {
		return message;
	}

}
