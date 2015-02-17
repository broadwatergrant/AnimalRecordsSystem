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
			int cageNumber, DogBreed breed, Sex sex, boolean spayedNeutered, boolean fleaTest, boolean heartwormTest,
			boolean rabiesVaccination, boolean distemperVaccination, boolean bordetellaVaccination) {
		
		super(name, AnimalType.DOG, age, dob, doa, chip, relinquishingParty, cageNumber);
		
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
	public String getStringRepresentation(){
		String result = super.getStringRepresentation();
	
		result += this.getBreed().stringRepresentation()+":";
		result += this.getSex()+":";
		result += this.isFleaTested()+":";
		result += this.getFirstFleaTreatment()+":";
		result += this.isHeartwormTested()+":";
		result += this.getBeginHeartwormDate()+":";
		result += this.getResetHeartwormDate()+":";
		result += this.isRabiesVaccinated()+":";
		result += this.isDistemperVaccinated()+":";
		result += this.isBordetellaVaccinated()+":";
		result += this.isCurrent()+":";
		result += this.isSpayedNeutered()+":";
		result += this.getSpayedNeuteredDate();
		
		return result+";";
	}
	
	@Override
	public String toString(){
		return this.getBreed()+" dog: "+this.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((beginHeartwormDate == null) ? 0 : beginHeartwormDate
						.hashCode());
		result = prime * result + (bordetellaVaccination ? 1231 : 1237);
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + (distemperVaccination ? 1231 : 1237);
		result = prime
				* result
				+ ((firstFleaTreatment == null) ? 0 : firstFleaTreatment
						.hashCode());
		result = prime * result + (fleaTest ? 1231 : 1237);
		result = prime * result + (heartwormTest ? 1231 : 1237);
		result = prime * result + (rabiesVaccination ? 1231 : 1237);
		result = prime
				* result
				+ ((resetHeartwormDate == null) ? 0 : resetHeartwormDate
						.hashCode());
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
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
		if (beginHeartwormDate == null) {
			if (other.beginHeartwormDate != null)
				return false;
		} else if (!beginHeartwormDate.equals(other.beginHeartwormDate))
			return false;
		if (bordetellaVaccination != other.bordetellaVaccination)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (distemperVaccination != other.distemperVaccination)
			return false;
		if (firstFleaTreatment == null) {
			if (other.firstFleaTreatment != null)
				return false;
		} else if (!firstFleaTreatment.equals(other.firstFleaTreatment))
			return false;
		if (fleaTest != other.fleaTest)
			return false;
		if (heartwormTest != other.heartwormTest)
			return false;
		if (rabiesVaccination != other.rabiesVaccination)
			return false;
		if (resetHeartwormDate == null) {
			if (other.resetHeartwormDate != null)
				return false;
		} else if (!resetHeartwormDate.equals(other.resetHeartwormDate))
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
