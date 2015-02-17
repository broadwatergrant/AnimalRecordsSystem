package com.grantbroadwater.animal;

import java.util.Date;

public final class Chip {
	private final boolean chipped;
	private final int chipNumber;
	private final String owner;
	private final Date contactDate;
	private final Date implantDate;
	
	public Chip(){
		chipped = false;
		chipNumber = 0;
		owner = null;
		contactDate = null;
		implantDate = null;
	}
	
	public Chip(String owner, int chipNumber, Date contactDate){
		chipped = true;
		this.owner = owner;
		this.chipNumber = chipNumber;
		this.contactDate = contactDate;
		
		this.implantDate = null;
	}
	
	public Chip(int chipNumber, Date implantDate){
		this.chipped = false;
		this.chipNumber = chipNumber;
		this.implantDate = implantDate;
		
		this.owner = null;
		this.contactDate = null;
	}
	
	@SuppressWarnings("deprecation")
	public static Chip parseChip(String representation){
		Chip result = null;
		String[] parts = representation.split("-");
		
		boolean chipped = Boolean.parseBoolean(parts[0]);
		if(chipped){
			result = new Chip(parts[1], Integer.parseInt(parts[2]), new Date(parts[3])); // Owner, chip #, Contact Date
		}else{
			result = new Chip(Integer.parseInt(parts[1]), new Date(parts[2])); // Chip #, Implant Date
		}
		
		return result;
	}
	
	public String stringRepresentation(){
		String result = isChipped()+"-";
		
		if(isChipped())
			result += getOwner() + "-" + getChipNumber() + "-" + getContactDate();
		else
			result += getChipNumber() + "-" + getImplantDate();
		
		return result;
	}
	
	public boolean isChipped(){
		return this.chipped;
	}
	
	public int getChipNumber(){
		return this.chipNumber;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public Date getContactDate(){
		return this.contactDate;
	}
	
	public Date getImplantDate(){
		return this.implantDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chipNumber;
		result = prime * result + (chipped ? 1231 : 1237);
		result = prime * result
				+ ((contactDate == null) ? 0 : contactDate.hashCode());
		result = prime * result
				+ ((implantDate == null) ? 0 : implantDate.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Chip))
			return false;
		
		Chip other = (Chip) obj;
		if (chipNumber != other.chipNumber)
			return false;
		if (chipped != other.chipped)
			return false;
		if (contactDate == null) {
			if (other.contactDate != null)
				return false;
		} else if (!contactDate.equals(other.contactDate))
			return false;
		if (implantDate == null) {
			if (other.implantDate != null)
				return false;
		} else if (!implantDate.equals(other.implantDate))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	

}
