package com.grantbroadwater.animal;

public class DogBreed extends Breed {

	public DogBreed() {
		super();
	}

	public DogBreed(String name, WeightRange weight, String hairColor, HairType hairType) {
		super(name, weight, hairColor, hairType);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
