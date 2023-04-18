package org.arghya.springmicroserviceaws.dto;

public class UserResponse {

	public UserResponse(String uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}

	private String uid;

	private String name;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
