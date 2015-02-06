package com.grantbroadwater.animal;

public class CatBreed extends Breed {

	public CatBreed() {
		super();
	}

	public CatBreed(String name, WeightRange weight, String hairColor, HairType hairType) {
		super(name, weight, hairColor, hairType);
	}
	
	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
	
}
