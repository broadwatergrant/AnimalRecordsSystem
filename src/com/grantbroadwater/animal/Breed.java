package com.grantbroadwater.animal;

public abstract class Breed {
	private String name;
	private WeightRange weight;
	private String hairColor;
	private HairType hairType;
	
	public Breed() {
		setName("");
		setWeight(new WeightRange());
		setHairColor("");
		setHairType(HairType.UNDEFINED);
	}
	
	public Breed(String name, WeightRange weight, String hairColor, HairType hairType){
		setName(name);
		setWeight(weight);
		setHairColor(hairColor);
		setHairType(hairType);
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public WeightRange getWeight(){
		return this.weight;
	}
	public void setWeight(WeightRange weight){
		this.weight = weight;
	}
	
	public String getHairColor(){
		return this.hairColor;
	}
	public void setHairColor(String hairColor){
		this.hairColor = hairColor;
	}

	public HairType getHairType(){
		return this.hairType;
	}
	public void setHairType(HairType hairType){
		this.hairType = hairType;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	@Override
	public abstract boolean equals(Object o);
	
}
