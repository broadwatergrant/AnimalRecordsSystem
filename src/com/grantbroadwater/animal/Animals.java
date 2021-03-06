package com.grantbroadwater.animal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.util.Log;

public class Animals {

	private static final String FILEPATH = 
			AnimalRecordsSystem.homeDirecotry+"\\.animals";
	private File animalFile;
	
	private ArrayList<Animal> current;
	private ArrayList<Animal> past;

	public Animals() throws IOException{
		setCurrent(new ArrayList<Animal>());
		setPast(new ArrayList<Animal>());
		animalFile = new File(FILEPATH);
		if(!animalFile.exists()){
			animalFile.createNewFile();
			new Log("Staff File Created: "+animalFile.getAbsolutePath());
		}else{
			loadAnimals();
		}
	}
	
	public void clear(){
		current.clear();
		past.clear();
	}
	
	public void replace(Animal a, Animal b){
		for(int i=0; i<current.size(); i++){
			if(current.get(i).equals(a)){
				current.set(i, b);
				return;
			}
		}
		for(int i=0; i<past.size(); i++){
			if(past.get(i).equals(a)){
				past.set(i, b);
				return;
			}
		}
		throw new IllegalArgumentException("No referance to "+a.getName());
	}
	
	public void addToAppropriateList(Animal a){
		if(a.isCurrent())
			addCurrentAnimal(a);
		else
			addPastAnimal(a);
	}
	
	public void loadAnimals(){
		try {
			Scanner scan = new Scanner(animalFile, "UTF-8");
			scan.useDelimiter(";");
			this.clear();
			while(scan.hasNext()){
				String s = scan.next();
				// TODO: DELETE
				new Log(s);
				Animal a = parseAnimal(s);
				new Log(a.toString());
				addToAppropriateList(a);
			}
			scan.close();
			new Log(getAll().size()+" animals loaded.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAnimals(){
		try {
			PrintWriter writer = new PrintWriter(animalFile, "UTF-8");
			int count = 0;
			
			for(Animal a : getAll()){
				// TODO: Confirm correctiveness
				if(count == getAll().size()-1)
					writer.print(a.getStringRepresentation());
				else
					writer.println(a.getStringRepresentation());
				count++;
			}
			
			writer.close();
			new Log(getAll().size()+" animals saved.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Animal parseAnimal(String representation){
		String[] parts = representation.split("~");
		String type = parts[0];
		
		if(type.equalsIgnoreCase("Dog"))
			return parseDog(parts);
		else if(type.equalsIgnoreCase("Cat"))
			return parseCat(parts);
		else if(type.equalsIgnoreCase("Other"))
			return parseOther(parts);
		
		return null;
	}
	
	public Dog parseDog(String[] parts){
		Dog result = new Dog();
		
		result = (Dog)addGenericTypes(result, parts);
		result.setType(AnimalType.DOG);
		
		result.setBreed((DogBreed)Breed.parseBreed(parts[9]));
		if(parts[10].equalsIgnoreCase("Male"))
			result.setSex(Sex.MALE);
		else if(parts[10].equalsIgnoreCase("Female"))
			result.setSex(Sex.FEMALE);
		result.setFleaTested(Boolean.parseBoolean(parts[11]));
		result.setFirstFleaTreatment(Animal.parseDate(parts[12]));
		result.setHeartwormTested(Boolean.parseBoolean(parts[13]));
		result.setBeginHeartwormDate(Animal.parseDate(parts[14]));
		result.setResetHeartwormDate(Animal.parseDate(parts[15]));
		result.setRabiesVaccinated(Boolean.parseBoolean(parts[16]));
		result.setDistemperVaccinated(Boolean.parseBoolean(parts[17]));
		result.setBordetellaVaccinated(Boolean.parseBoolean(parts[18]));
		result.setCurrent(Boolean.parseBoolean(parts[19]));
		result.setSpayedNeutered(Boolean.parseBoolean(parts[20]));
		result.setSpayedNeuteredDate(Animal.parseDate(parts[21]));
		result.setRabiesDate(Animal.parseDate(parts[22]));
		result.setDistemperDate(Animal.parseDate(parts[23]));
		result.setBordetellaDate(Animal.parseDate(parts[24]));
		
		return result;
	}
	
	public Cat parseCat(String[] parts){
		Cat result = new Cat();
		
		result = (Cat)addGenericTypes(result, parts);
		result.setType(AnimalType.CAT);
		
		result.setBreed((CatBreed)Breed.parseBreed(parts[9]));
		if(parts[10].equalsIgnoreCase("Male"))
			result.setSex(Sex.MALE);
		else if(parts[10].equalsIgnoreCase("Female"))
			result.setSex(Sex.FEMALE);
		result.setSpayedNeutered(Boolean.parseBoolean(parts[11]));
		result.setSpayedNeuterDate(Animal.parseDate(parts[12]));
		result.setFleaTested(Boolean.parseBoolean(parts[13]));
		result.setFirstFleaTreatment(Animal.parseDate(parts[14]));
		result.setDeclawed(Boolean.parseBoolean(parts[15]));
		if(parts[16].equalsIgnoreCase("TWO"))
			result.setDecawingType(DeclawingType.TWO);
		else if(parts[16].equalsIgnoreCase("FOUR"))
			result.setDecawingType(DeclawingType.FOUR);
		result.setFelineLeukemiaTested(Boolean.parseBoolean(parts[17]));
		result.setFelineLeukemiaTestDate(Animal.parseDate(parts[18]));
		result.setRabiesVaccinated(Boolean.parseBoolean(parts[19]));
		
		return result;
	}
	
	public Other parseOther(String[] parts){
		Other result = new Other();
		
		result = (Other)addGenericTypes(result, parts);
		result.setType(AnimalType.OTHER);
		
		result.setSpecies(parts[9]);
		result.setWeight(Double.parseDouble(parts[10]));
		result.setAppearance(parts[11]);
		result.setVaccinations(parseList(parts[12]));
		
		return result;
	}
	
	private static ArrayList<String> parseList(String str){
		ArrayList<String> result = new ArrayList<String>();
		
		str = str.replaceAll("[", "").replaceAll("]", "").trim();
		String[] parts = str.split(",");
		
		for(String s : parts){
			result.add(s);
		}
		
		return result;
	}
	
	public static Animal addGenericTypes(Animal a, String[] parts){
		
		a.setName(parts[1]);
		a.setAge(Integer.parseInt(parts[2]));
		a.setDateOfBirth(Animal.parseDate(parts[3]));
		a.setDateOfArrival(Animal.parseDate(parts[4]));
		a.setChip(Chip.parseChip(parts[5]));
		a.setRelinquishingParty(parts[6]);
		a.setCageNumber(Integer.parseInt(parts[7]));
		a.setCaseNumber(parts[8]);
		
		return a;
	}

	public Animal getAnimalWithCaseNumber(String caseNumber){
		for(Animal a : getAll())
			if(a.getCaseNumber().equals(caseNumber))
				return a;
		return null;
	}
	
	public ArrayList<Animal> getCurrent() {
		return current;
	}
	
	public void addCurrentAnimal(Animal a){
		a.setCurrent(true);
		current.add(a);
	}
	
	public ArrayList<Dog> getCurrentDogs(){
		ArrayList<Dog> result = new ArrayList<Dog>();
		
		for(Animal a : current){
			if(a instanceof Dog)
				result.add((Dog)a);
		}
		
		return result;
	}
	
	public ArrayList<Cat> getCurrentCats(){
		ArrayList<Cat> result = new ArrayList<Cat>();
		
		for(Animal a : current){
			if(a instanceof Cat)
				result.add((Cat)a);
		}
		
		return result;
	}
	
	public ArrayList<Other> getCurrentOthers(){
		ArrayList<Other> result = new ArrayList<Other>();
		
		for(Animal a : current){
			if(a instanceof Other)
				result.add((Other)a);
		}
		
		return result;
	}

	private void setCurrent(ArrayList<Animal> current) {
		this.current = current;
	}

	public void moveToPast(Animal adoptedAnimal){
		ArrayList<Animal> newCurrent = new ArrayList<Animal>();
		
		for(Animal a : current)
			if(!a.getCaseNumber().equals(adoptedAnimal.getCaseNumber()))
				newCurrent.add(a);
		
		setCurrent(newCurrent);
		addPastAnimal(adoptedAnimal);
	}
	
	public ArrayList<Animal> getPast() {
		return past;
	}
	
	public void addPastAnimal(Animal a){
		a.setCurrent(false);
		past.add(a);
	}
	
	public ArrayList<Dog> getPastDogs(){
		ArrayList<Dog> result = new ArrayList<Dog>();
		
		for(Animal a : past){
			if(a instanceof Dog)
				result.add((Dog)a);
		}
		
		return result;
	}
	
	public ArrayList<Cat> getPastCats(){
		ArrayList<Cat> result = new ArrayList<Cat>();
		
		for(Animal a : past){
			if(a instanceof Cat)
				result.add((Cat)a);
		}
		
		return result;
	}
	
	public ArrayList<Other> getPastOthers(){
		ArrayList<Other> result = new ArrayList<Other>();
		
		for(Animal a : past){
			if(a instanceof Other)
				result.add((Other)a);
		}
		
		return result;
	}

	private void setPast(ArrayList<Animal> past) {
		this.past = past;
	}
	
	public ArrayList<Animal> getAll(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		
		for(Animal a : current)
			result.add(a);
		
		for(Animal a : past)
			result.add(a);
		
		return result;
	}
	
	public ArrayList<Dog> getAllDogs(){
		ArrayList<Dog> result = new ArrayList<Dog>();
		
		for(Animal a : current)
			if(a instanceof Dog)
				result.add((Dog)a);
		
		for(Animal a : past)
			if(a instanceof Dog)	
				result.add((Dog)a);
		
		return result;
	}
	
	public ArrayList<Cat> getAllCats(){
		ArrayList<Cat> result = new ArrayList<Cat>();
		
		for(Animal a : current)
			if(a instanceof Cat)
				result.add((Cat)a);
		
		for(Animal a : past)
			if(a instanceof Cat)	
				result.add((Cat)a);
		
		return result;
	}
	
	public ArrayList<Other> getAllOthers(){
		ArrayList<Other> result = new ArrayList<Other>();
		
		for(Animal a : current)
			if(a instanceof Other)
				result.add((Other)a);
		
		for(Animal a : past)
			if(a instanceof Other)	
				result.add((Other)a);
		
		return result;
	}
	
	/* ----- */
	
	public String[] getAllCurrentCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Animal a : getCurrent())
			list.add(a.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getCurrentDogCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Dog d : getCurrentDogs())
			list.add(d.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getCurrentCatCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Cat c : getCurrentCats())
			list.add(c.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getCurrentOtherCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Other o : getCurrentOthers())
			list.add(o.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	/* ----- */
	
	public String[] getAllPastCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Animal a : getPast())
			list.add(a.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getPastDogCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Dog d : getPastDogs())
			list.add(d.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getPastCatCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Cat c : getPastCats())
			list.add(c.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getPastOtherCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Other o : getPastOthers())
			list.add(o.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	/* ----- */
	
	public String[] getAllCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Animal a : getAll())
			list.add(a.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getAllDogCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Dog d : getAllDogs())
			list.add(d.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getAllCatCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Cat c : getAllCats())
			list.add(c.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
	public String[] getAllOtherCaseNumbers(){
		ArrayList<String> list = new ArrayList<String>();
		
		for(Other o : getAllOthers())
			list.add(o.getCaseNumber());
		
		return list.toArray(new String[list.size()]);
	}
	
}
