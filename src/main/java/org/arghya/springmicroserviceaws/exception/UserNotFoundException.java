package org.arghya.springmicroserviceaws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends Exception {
	
	
	public UserNotFoundException(String message) {
		super(message);
	}

	public  HttpStatus getHttpErrorCode() {
		return HttpStatus.NOT_FOUND;
	}
}
