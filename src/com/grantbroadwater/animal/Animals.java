package com.grantbroadwater.animal;

import java.util.ArrayList;

public class Animals {

	private ArrayList<Animal> current;
	private ArrayList<Animal> past;

	public Animals(){
		setCurrent(new ArrayList<Animal>());
		setPast(new ArrayList<Animal>());
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
			if(a != adoptedAnimal)
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
	
	public ArrayList<Other> getAllOther(){
		ArrayList<Other> result = new ArrayList<Other>();
		
		for(Animal a : current)
			if(a instanceof Other)
				result.add((Other)a);
		
		for(Animal a : past)
			if(a instanceof Other)	
				result.add((Other)a);
		
		return result;
	}
	
}
