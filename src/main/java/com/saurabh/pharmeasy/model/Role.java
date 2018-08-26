package com.saurabh.pharmeasy.model;

public enum Role {
	Doctor("Doctor"),
	Patient("Patient");
	private String roleName;
	public String getRoleName(){
		return this.roleName;
	}
	private Role(String roleName){
		this.roleName=roleName;
	}
}
