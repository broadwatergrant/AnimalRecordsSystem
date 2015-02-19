package com.grantbroadwater.animal;

import java.util.Date;

public class Cat extends Animal {
	private CatBreed breed;
	private Sex sex;
	private boolean spayedNeutered;
	private Date spayedNeuterDate;
	private boolean fleaTest;
	private Date firstFleaTreatment;
	private boolean declawed;
	private DeclawingType decawingType;
	private boolean felineLeukemiaTest;
	private Date felineLeukemiaTestDate;
	private boolean rabiesVaccine;

	public Cat() {
		super();
		setBreed(new CatBreed());
		setSex(Sex.UNDEFINED);
		setFleaTested(false);
		setDeclawed(false);
		setFelineLeukemiaTested(false);
		setRabiesVaccinated(false);
	}

	public Cat(String name, int age, Date dob, Date doa, Chip chip, String relinquishingParty,
			int cageNumber, CatBreed breed, Sex sex, boolean fleaTest, boolean declawed,
			boolean felineLeukemiaTest, boolean rabiesVaccine) {
		
		super(name, AnimalType.CAT, age, dob, doa, chip, relinquishingParty, cageNumber);
		
		setBreed(breed);
		setSex(sex);
		setFleaTested(fleaTest);
		setDeclawed(declawed);
		setFelineLeukemiaTested(felineLeukemiaTest);
		setRabiesVaccinated(rabiesVaccine);
	}
	
	public CatBreed getBreed(){
		return this.breed;
	}
	public void setBreed(CatBreed breed){
		this.breed = breed;
	}
	
	public Sex getSex(){
		return this.sex;
	}
	public void setSex(Sex sex){
		this.sex = sex;
	}
	
	public boolean isSpayedNeutered() {
		return spayedNeutered;
	}

	public void setSpayedNeutered(boolean spayedNeutered) {
		this.spayedNeutered = spayedNeutered;
	}

	public Date getSpayedNeuterDate() {
		return spayedNeuterDate;
	}

	public void setSpayedNeuterDate(Date spayedNeuterDate) {
		this.spayedNeuterDate = spayedNeuterDate;
	}

	public boolean isFleaTested(){
		return this.fleaTest;
	}
	public void setFleaTested(boolean isFleaTested){
		this.fleaTest = isFleaTested;
	}
	
	public Date getFirstFleaTreatment() {
		return firstFleaTreatment;
	}

	public void setFirstFleaTreatment(Date firstFleaTreatment) {
		this.firstFleaTreatment = firstFleaTreatment;
	}

	public boolean isDeclawed(){
		return this.declawed;
	}
	public void setDeclawed(boolean isDeclawed){
		this.declawed = isDeclawed;
	}
	
	public DeclawingType getDecawingType() {
		return decawingType;
	}

	public void setDecawingType(DeclawingType decawingType) {
		this.decawingType = decawingType;
	}

	public boolean isFelineLeukemiaTested(){
		return this.felineLeukemiaTest;
	}
	public void setFelineLeukemiaTested(boolean isFelineLeukemiaTested){
		this.felineLeukemiaTest = isFelineLeukemiaTested;
	}
	
	public Date getFelineLeukemiaTestDate() {
		return felineLeukemiaTestDate;
	}

	public void setFelineLeukemiaTestDate(Date felineLeukemiaTestDate) {
		this.felineLeukemiaTestDate = felineLeukemiaTestDate;
	}

	public boolean isRabiesVaccinated(){
		return this.rabiesVaccine;
	}
	public void setRabiesVaccinated(boolean isRabiesVaccinated){
		this.rabiesVaccine = isRabiesVaccinated;
	}
	
	@Override
	public String getStringRepresentation(){
		String result = super.getStringRepresentation();
		
		result += this.getBreed().stringRepresentation()+"~";
		result += this.getSex()+"~";
		result += this.isSpayedNeutered()+"~";
		result += printDate(getSpayedNeuterDate())+"~";
		result += this.isFleaTested()+"~";
		result += printDate(getFirstFleaTreatment())+"~";
		result += this.isDeclawed()+"~";
		result += this.getDecawingType()+"~";
		result += this.isFelineLeukemiaTested()+"~";
		result += printDate(getFelineLeukemiaTestDate())+"~";
		result += this.isRabiesVaccinated()+"~";
		result += this.isCurrent();
		
		return result+";";
	}
	
	@Override
	public String toString(){
		return this.getBreed()+" cat: "+this.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result
				+ ((decawingType == null) ? 0 : decawingType.hashCode());
		result = prime * result + (declawed ? 1231 : 1237);
		result = prime * result + (felineLeukemiaTest ? 1231 : 1237);
		result = prime
				* result
				+ ((felineLeukemiaTestDate == null) ? 0
						: felineLeukemiaTestDate.hashCode());
		result = prime
				* result
				+ ((firstFleaTreatment == null) ? 0 : firstFleaTreatment
						.hashCode());
		result = prime * result + (fleaTest ? 1231 : 1237);
		result = prime * result + (rabiesVaccine ? 1231 : 1237);
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime
				* result
				+ ((spayedNeuterDate == null) ? 0 : spayedNeuterDate.hashCode());
		result = prime * result + (spayedNeutered ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (decawingType != other.decawingType)
			return false;
		if (declawed != other.declawed)
			return false;
		if (felineLeukemiaTest != other.felineLeukemiaTest)
			return false;
		if (felineLeukemiaTestDate == null) {
			if (other.felineLeukemiaTestDate != null)
				return false;
		} else if (!felineLeukemiaTestDate.equals(other.felineLeukemiaTestDate))
			return false;
		if (firstFleaTreatment == null) {
			if (other.firstFleaTreatment != null)
				return false;
		} else if (!firstFleaTreatment.equals(other.firstFleaTreatment))
			return false;
		if (fleaTest != other.fleaTest)
			return false;
		if (rabiesVaccine != other.rabiesVaccine)
			return false;
		if (sex != other.sex)
			return false;
		if (spayedNeuterDate == null) {
			if (other.spayedNeuterDate != null)
				return false;
		} else if (!spayedNeuterDate.equals(other.spayedNeuterDate))
			return false;
		if (spayedNeutered != other.spayedNeutered)
			return false;
		return true;
	}
	
	

}
