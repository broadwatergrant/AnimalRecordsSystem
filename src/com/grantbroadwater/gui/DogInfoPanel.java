package com.grantbroadwater.gui;

import java.awt.Font;

import javax.swing.JLabel;

public class DogInfoPanel extends SpecificInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public DogInfoPanel() {
		super();
		
		JLabel title = new JLabel("Dog Information");
		title.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
		title.setLocation(150, 10);
		title.setSize(300, 40);
		add(title);
		
		// Breed Label
		JLabel lblBreedName = new JLabel("Breed:");
		lblBreedName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblBreedName.setLocation(10, 60);
		lblBreedName.setSize(150, 20);
		add(lblBreedName);
		
	}

}
