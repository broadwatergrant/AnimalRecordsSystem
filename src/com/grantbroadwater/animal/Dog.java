package com.grantbroadwater.animal;

import java.util.Date;

public class Dog extends Animal {
	private DogBreed breed;
	private Sex sex;
	private boolean spayedNeutered;
	private Date spayedNeuterDate;
	private boolean fleaTest;
	private Date firstFleaTreatment;
	private boolean heartwormTest;
	private Date beginHeartwormDate;
	private Date resetHeartwormDate;
	private boolean rabiesVaccination;
	private boolean distemperVaccination;
	private boolean bordetellaVaccination;
	
	public Dog() {
		super();		
		setBreed(new DogBreed());
		setSex(Sex.UNDEFINED);
		setFleaTested(false);
		setHeartwormTested(false);
		setRabiesVaccinated(false);
		setDistemperVaccinated(false);
		setBordetellaVaccinated(false);
	}

	public Dog(String name, int age, Date dob, Date doa, Chip chip, String relinquishingParty,
			int cageNumber, String caseNumber, DogBreed breed, Sex sex, boolean spayedNeutered, boolean fleaTest, boolean heartwormTest,
			boolean rabiesVaccination, boolean distemperVaccination, boolean bordetellaVaccination) {
		
		super(name, AnimalType.DOG, age, dob, doa, chip, relinquishingParty, cageNumber, caseNumber);
		
		setBreed(breed);
		setSex(sex);
		setFleaTested(fleaTest);
		setHeartwormTested(heartwormTest);
		setRabiesVaccinated(rabiesVaccination);
		setDistemperVaccinated(distemperVaccination);
		setBordetellaVaccinated(bordetellaVaccination);
	}
	
	public DogBreed getBreed(){
		return this.breed;
	}
	public void setBreed(DogBreed breed){
		this.breed = breed;
	}
	
	public Sex getSex(){
		return this.sex;
	}
	public void setSex(Sex sex){
		this.sex = sex;
	}
	
	public boolean isSpayedNeutered(){
		return this.spayedNeutered;
	}
	public void setSpayedNeutered(boolean isSpayedNeutered){
		this.spayedNeutered = isSpayedNeutered;
	}
	
	public Date getSpayedNeuteredDate(){
		return this.spayedNeuterDate;
	}
	public void setSpayedNeuteredDate(Date spayedNeuteredDate){
		this.spayedNeuterDate = spayedNeuteredDate;
	}
	
	public boolean isFleaTested(){
		return this.fleaTest;
	}
	public void setFleaTested(boolean isFleaTested){
		this.fleaTest = isFleaTested;
	}
	
	public Date getFirstFleaTreatment(){
		return this.firstFleaTreatment;
	}
	public void setFirstFleaTreatment(Date firstFleaTreatment){
		this.firstFleaTreatment = firstFleaTreatment;
	}
	
	public boolean isHeartwormTested(){
		return this.heartwormTest;
	}
	public void setHeartwormTested(boolean isHeartwormTested){
		this.heartwormTest = isHeartwormTested;
	}	
	
	public Date getBeginHeartwormDate() {
		return beginHeartwormDate;
	}

	public void setBeginHeartwormDate(Date beginHeartwormDate) {
		this.beginHeartwormDate = beginHeartwormDate;
	}

	public Date getResetHeartwormDate() {
		return resetHeartwormDate;
	}

	public void setResetHeartwormDate(Date resetHeartwormDate) {
		this.resetHeartwormDate = resetHeartwormDate;
	}

	public boolean isRabiesVaccinated(){
		return this.rabiesVaccination;
	}
	public void setRabiesVaccinated(boolean isRabiesVaccinated){
		this.rabiesVaccination = isRabiesVaccinated;
	}
	
	public boolean isDistemperVaccinated(){
		return this.distemperVaccination;
	}
	public void setDistemperVaccinated(boolean isDistemperVaccinated){
		this.distemperVaccination = isDistemperVaccinated;
	}
	
	public boolean isBordetellaVaccinated(){
		return this.bordetellaVaccination;
	}
	public void setBordetellaVaccinated(boolean isBordetellaVaccinated){
		this.bordetellaVaccination = isBordetellaVaccinated;
	}
	
	@Override
	public String toString(){
		return this.getBreed()+" dog; "+this.getName();
	}
	
	@Override
	public boolean equals(Object o){
		@SuppressWarnings("unused")
		Dog d = new Dog();
		if(o instanceof Dog)
			d = (Dog)o;
		else
			return false;
		
		// TODO Compare all instance variables between (this : Dog) and (d : Dog)
		return false;
	}
	
}
