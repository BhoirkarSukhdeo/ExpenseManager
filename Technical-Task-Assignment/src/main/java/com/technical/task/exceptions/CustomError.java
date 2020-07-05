package com.technical.task.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

public class CustomError implements Serializable{

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	private String error;
	private HttpStatus status;

}
