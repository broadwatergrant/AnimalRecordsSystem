package com.grantbroadwater.animal;

public class CatBreed extends Breed {

	public CatBreed() {
		super();
	}

	public CatBreed(String name, WeightRange weight, String hairColor, HairType hairType) {
		super(name, weight, hairColor, hairType);
	}

	@Override
	public boolean equals(Object o) {
		CatBreed breed = new CatBreed();
		if(o instanceof CatBreed)
			breed = (CatBreed)o;
		else
			return false;
		
		return (this.getName().equals(breed.getName())&&
				this.getWeight().equals(breed.getWeight())&&
				this.getHairColor().equals(breed.getHairColor())&&
				this.getHairType().equals(breed.getHairType()));
	}

}
