package com.grantbroadwater.gui;

import javax.swing.JPanel;

import com.grantbroadwater.animal.Animal;

public class AnimalEditPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Animal animal;
	
	public AnimalEditPanel(Animal animal){
		super(null);
		
		
		
		if(animal != null)
			populateFields(animal);
	}
	
	public void populateFields(Animal animal){
		this.setAnimal(animal);
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
