package com.jpaul.hruser.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<String> handleInvalidArguments(RuntimeException exception, WebRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}


}
