package com.grantbroadwater.staff;

public class StaffMember implements Comparable<StaffMember>{
	private String name;
	private String pin;
	
	public StaffMember() {
		setName("");
		setPin("");
	}
	
	public StaffMember(String name, String pin){
		setName(name);
		setPin(pin);
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getPin(){
		return this.pin;
	}
	
	public void setPin(String pin){
		this.pin = pin;
	}

	@Override
	public int compareTo(StaffMember staffMember){
		return this.getPin().compareToIgnoreCase(staffMember.getPin());
	}

}
