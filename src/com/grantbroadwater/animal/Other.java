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
			int cageNumber, String species, double weight, String appearance, ArrayList<String> vaccinations) {
		
		super(name, AnimalType.OTHER, age, dob, doa, chip, relinquishingParty, cageNumber);

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
		return this.getSpecies()+": "+this.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((appearance == null) ? 0 : appearance.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result
				+ ((vaccinations == null) ? 0 : vaccinations.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Other))
			return false;
		Other other = (Other) obj;
		if (appearance == null) {
			if (other.appearance != null)
				return false;
		} else if (!appearance.equals(other.appearance))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (vaccinations == null) {
			if (other.vaccinations != null)
				return false;
		} else if (!vaccinations.equals(other.vaccinations))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	
}
