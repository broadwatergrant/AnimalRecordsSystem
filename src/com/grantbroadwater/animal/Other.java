package com.grantbroadwater.animal;

import java.util.*;

public class Other extends Animal {
	private String species;
	private double weight;
	private String appearance;
	private ArrayList<String> vaccinations;
	
	public Other() {
		super();
		setSpecies("");
		setWeight(0.0);
		setAppearance("");
		setVaccinations(new ArrayList<String>());
	}

	public Other(String name, int age, Date dob, Date doa, Chip chip, String relinquishingParty, 
			int cageNumber,String caseNumber, String species, double weight, String appearance, ArrayList<String> vaccinations) {
		
		super(name, AnimalType.OTHER, age, dob, doa, chip, relinquishingParty, cageNumber, caseNumber);

		setSpecies(species);
		setWeight(weight);
		setAppearance(appearance);
		setVaccinations(vaccinations);
	}
	
	public String getSpecies(){
		return this.species;
	}
	public void setSpecies(String species){
		this.species = species;
	}
	
	public double getWeight(){
		return this.weight;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public String getAppearace(){
		return this.appearance;
	}
	public void setAppearance(String appearance){
		this.appearance = appearance;
	}

	public ArrayList<String> getVaccinations(){
		return this.vaccinations;
	}
	public void setVaccinations(ArrayList<String> vaccinations){
		this.vaccinations = vaccinations;
	}
	
	@Override
	public String toString(){
		return this.getSpecies()+"; "+this.getName();
	}
	
	@Override
	public boolean equals(Object o){
		@SuppressWarnings("unused")
		Other ot = new Other();
		if(o instanceof Other)
			ot = (Other)o;
		else
			return false;
		
		// TODO Compare all instance variables between (this : Other) and (d : Other)
		return false;
		
	}
	
}
