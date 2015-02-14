package com.grantbroadwater.staff;

public class StaffMember implements Comparable<StaffMember>{
	private String firstName;
	private String lastName;
	private String pin;
	private boolean admin;
	
	public StaffMember() {
		setFirstName("");
		setLastName("");
		setPin("");
		setAdmin(false);
	}
	
	public StaffMember(String firstName, String lastName, String pin){
		setFirstName(firstName);
		setLastName(lastName);
		setPin(pin);
		setAdmin(false);
	}
	
	public StaffMember(String firstName, String lastName, String pin, boolean isAdmin){
		setFirstName(firstName);
		setLastName(lastName);
		setPin(pin);
		setAdmin(isAdmin);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName(){
		return this.firstName+" "+this.lastName;
	}
	
	public void setName(String firstName, String lastName){
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getPin(){
		return this.pin;
	}
	
	public void setPin(String pin){
		this.pin = pin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int compareTo(StaffMember staffMember){
		return this.getPin().compareToIgnoreCase(staffMember.getPin());
	}

	@Override
	public String toString() {
		return "StaffMember [firstName=" + firstName + ", lastName=" + lastName
				+ ", pin=" + pin + "]";
	}
	
	public String toStringForSave(){
		return this.firstName+":"+this.lastName+":"+this.pin+":"+this.admin+";";
	}

}
