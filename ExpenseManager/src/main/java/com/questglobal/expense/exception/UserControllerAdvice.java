package com.questglobal.expense.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.questglobal.expense.model.ExceptionResponse;

@ControllerAdvice
public class UserControllerAdvice {

	@Autowired
    private  ExceptionResponse exceptionResponse;

	

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(EntityNotFoundException ex,final
			 HttpServletRequest request)
	{

		exceptionResponse.setErrorMessage(ex.getMessage());

        exceptionResponse.callerURL(request.getRequestURI());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex,final HttpServletRequest request)
    {

		exceptionResponse.setErrorMessage(ex.getMessage());

        exceptionResponse.callerURL(request.getRequestURI());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);


	}

}
