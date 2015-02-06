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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hairColor == null) ? 0 : hairColor.hashCode());
		result = prime * result
				+ ((hairType == null) ? 0 : hairType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Breed))
			return false;
		Breed other = (Breed) obj;
		if (hairColor == null) {
			if (other.hairColor != null)
				return false;
		} else if (!hairColor.equals(other.hairColor))
			return false;
		if (hairType != other.hairType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	
	
}
