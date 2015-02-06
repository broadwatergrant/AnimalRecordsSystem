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
		chipNumber = -1;
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

}
