package com.grantbroadwater.animal;

import java.util.*;

public abstract class Animal {
	private String name;
	private AnimalType type;
	private int age;
	private Date dateOfBirth;
	private Date dateOfArrival;
	private Chip chip;
	private String relinquishingParty;
	private int cageNumber;
	private String caseNumber;
	
	public Animal() {
		setName("");
		setType(AnimalType.UNDEFINED);
		setAge(0);
		setDateOfBirth(null);
		setDateOfArrival(new Date());
		setChip(new Chip());
		setRelinquishingParty("");
		setCageNumber(0);
		setCaseNumber("");
	}
	
	public Animal(String name, AnimalType type, int age, Date dob, Date doa, Chip chip, String relinquishingParty, int cageNumber, String caseNumber){
		setName(name);
		setType(type);
		setAge(age);
		setDateOfBirth(dob);
		setDateOfArrival(doa);
		setChip(chip);
		setRelinquishingParty(relinquishingParty);
		setCageNumber(cageNumber);
		setCaseNumber(caseNumber);
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public AnimalType getType(){
		return this.type;
	}
	protected void setType(AnimalType type){
		this.type = type;
	}
	
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	
	public Date getDateOfArrival(){
		return this.dateOfArrival;
	}
	public void setDateOfArrival(Date dateOfArrival){
		this.dateOfArrival = dateOfArrival;
	}
	
	public Chip getChip(){
		return this.chip;
	}
	public void setChip(Chip chip){
		this.chip = chip;
	}
	
	public String getRelinquishingParty(){
		return this.relinquishingParty;
	}
	public void setRelinquishingParty(String party){
		this.relinquishingParty = party;
	}
		
	public int getCageNumber(){
		return this.cageNumber;
	}
	public void setCageNumber(int cageNumber){
		this.cageNumber = cageNumber;
	}
	
	public String getCaseNumber(){
		return this.caseNumber;
	}
	public void setCaseNumber(String caseNumber){
		this.caseNumber = caseNumber;
	}
	
	@Override
	public abstract String toString();
	
	@Override
	public abstract boolean equals(Object o);
	
	
}
