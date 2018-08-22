package com.identityE2E.persistence.domain;

public class Vehicle {
	private String regNo;
	private String make;
	private String colour;
	
	
	public Vehicle() {
		
	}
	
	public String toString() {
        return String.format("%s - %s", regNo, colour);
    }
	
	public boolean isMatch(String make, String colour) {
		return make.equalsIgnoreCase(getMake()) && colour.equalsIgnoreCase(getColour());
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNumber) {
		this.regNo = regNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
}
