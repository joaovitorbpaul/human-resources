package com.jpaul.hrpayroll.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<String> handleInvalidArguments(RuntimeException exception, WebRequest request){
		log.error("Bad Request: {}", exception.getMessage(), exception.fillInStackTrace());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	@ExceptionHandler({ResponseStatusException.class})
	public ResponseEntity<String> handleRequestError(ResponseStatusException exception, WebRequest request) {
		log.error("Bad Request: {}", exception.getMessage(), exception.fillInStackTrace());
		return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
	}

}
