package com.grantbroadwater.animal;

public class DogBreed extends Breed {

	public DogBreed() {
		super();
	}

	public DogBreed(String name, WeightRange weight, String hairColor, HairType hairType) {
		super(name, weight, hairColor, hairType);
	}

	@Override
	public boolean equals(Object o) {
		DogBreed breed = new DogBreed();
		if(o instanceof DogBreed)
			breed = (DogBreed)o;
		else
			return false;
		
		return (this.getName().equals(breed.getName())&&
				this.getWeight().equals(breed.getWeight())&&
				this.getHairColor().equals(breed.getHairColor())&&
				this.getHairType().equals(breed.getHairType()));
	}

}
