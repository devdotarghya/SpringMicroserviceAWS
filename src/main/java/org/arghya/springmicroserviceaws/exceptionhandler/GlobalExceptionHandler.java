package org.arghya.springmicroserviceaws.exceptionhandler;

import org.arghya.springmicroserviceaws.dto.ServiceErrorResponse;
import org.arghya.springmicroserviceaws.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ServiceErrorResponse> handleGenericException(Exception exception) {
		ServiceErrorResponse serviceErrorResponse = new ServiceErrorResponse(exception.getMessage());
		return new ResponseEntity<>(serviceErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<ServiceErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
		ServiceErrorResponse serviceErrorResponse = new ServiceErrorResponse(exception.getMessage());
		return new ResponseEntity<>(serviceErrorResponse, exception.getHttpErrorCode());
	}
}
