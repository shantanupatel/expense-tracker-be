package com.expense.response;

public class GenericResponse<T> {

	private int HttpStatus;
	private String message;
	private T data;

	public GenericResponse() {
	}

	public GenericResponse(int HttpStatus, String message, T data) {
		this.HttpStatus = HttpStatus;
		this.message = message;
		this.data = data;
	}

	public int getHttpStatus() {
		return HttpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		HttpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
