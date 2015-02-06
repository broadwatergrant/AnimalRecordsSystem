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
			int cageNumber, String caseNumber, CatBreed breed, Sex sex, boolean fleaTest, boolean declawed,
			boolean felineLeukemiaTest, boolean rabiesVaccine) {
		
		super(name, AnimalType.CAT, age, dob, doa, chip, relinquishingParty,	cageNumber, caseNumber);
		
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
	public String toString(){
		return this.getBreed()+" cat; "+this.getName();
	}
	
	@Override
	public boolean equals(Object o){
		@SuppressWarnings("unused")
		Cat c = new Cat();
		if(o instanceof Cat)
			c = (Cat)o;
		else
			return false;
		
		// TODO Compare all instance variables between (this : Cat) and (d : Cat)
		return false;
		
	}

}
