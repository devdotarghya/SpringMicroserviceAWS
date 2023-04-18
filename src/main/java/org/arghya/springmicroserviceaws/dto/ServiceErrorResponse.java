package org.arghya.springmicroserviceaws.dto;

public class ServiceErrorResponse {
	
	private String errorMessage;

	
	public ServiceErrorResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
