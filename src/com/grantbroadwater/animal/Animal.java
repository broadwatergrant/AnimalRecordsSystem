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
	private boolean quarentined;
	
	public Animal() {
		setName("");
		setType(AnimalType.UNDEFINED);
		setAge(0);
		setDateOfBirth(null);
		setDateOfArrival(new Date());
		setChip(new Chip());
		setRelinquishingParty("");
		setCageNumber(0);
		generateCaseNumber();
	}
	
	public Animal(String name, AnimalType type, int age, Date dob, Date doa, Chip chip, String relinquishingParty, int cageNumber){
		setName(name);
		setType(type);
		setAge(age);
		setDateOfBirth(dob);
		setDateOfArrival(doa);
		setChip(chip);
		setRelinquishingParty(relinquishingParty);
		setCageNumber(cageNumber);
		generateCaseNumber();
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
	public String setCaseNumber(String caseNumber){
		this.caseNumber = caseNumber;
		return this.caseNumber;
	}
	
	public String generateCaseNumber(){
		String pre = new String(isQuarentined() ? "Q" : "");
		String type;
		switch(this.type){
		case DOG:
			type = "D";
			break;
		case CAT:
			type = "C";
			break;
		case OTHER:
			type = "O";
			break;
		case UNDEFINED:
			type = "X";
			break;
		default:
			type = "!";
			break;
		}
		return setCaseNumber(pre+type+hashCode());
	}
	
	public boolean isQuarentined() {
		return quarentined;
	}

	public void setQuarentined(boolean quarentined) {
		this.quarentined = quarentined;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + cageNumber;
		result = prime * result
				+ ((caseNumber == null) ? 0 : caseNumber.hashCode());
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result
				+ ((dateOfArrival == null) ? 0 : dateOfArrival.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((relinquishingParty == null) ? 0 : relinquishingParty
						.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (cageNumber != other.cageNumber)
			return false;
		if (caseNumber == null) {
			if (other.caseNumber != null)
				return false;
		} else if (!caseNumber.equals(other.caseNumber))
			return false;
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
			return false;
		if (dateOfArrival == null) {
			if (other.dateOfArrival != null)
				return false;
		} else if (!dateOfArrival.equals(other.dateOfArrival))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (relinquishingParty == null) {
			if (other.relinquishingParty != null)
				return false;
		} else if (!relinquishingParty.equals(other.relinquishingParty))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
	
}
