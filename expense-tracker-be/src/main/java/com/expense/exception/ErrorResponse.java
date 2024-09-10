package com.expense.exception;

public class ErrorResponse {

	private final String message;
	private final Throwable throwable;
	private final Integer httpStatus;

	public ErrorResponse(String message, Throwable throwable, Integer httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

}
