package com.grantbroadwater.gui;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.grantbroadwater.animal.DeclawingType;
import com.grantbroadwater.animal.HairType;
import com.grantbroadwater.animal.Sex;

public class CatInfoPanel extends SpecificInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField breedNameTextField;
	private JTextField wrLowTextField;
	private JTextField wrHighTextField;
	private JComboBox<HairType> hairTypeComboBox;
	private JTextField hairColorTextField;
	private	JComboBox<Sex> sexComboBox;
	private JComboBox<Boolean> spayedNeuteredComboBox;
	private JTextField spayedNeuteredTextField;
	private JComboBox<Boolean> fleaTestComboBox;
	private JTextField fleaTestTextField;
	private JComboBox<Boolean> declawedComboBox;
	private JComboBox<DeclawingType> declawingTypeComboBox;
	private JComboBox<String> leukemiaComboBox;
	private JTextField leukemiaTextField;
	private JCheckBox rabiesVaccinated;
	private JTextField rabiesTextField;
	
	public CatInfoPanel() {
		super();
		
		int w = 125;
		
		JLabel title = new JLabel("Cat Information");
		title.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
		title.setLocation(150, 10);
		title.setSize(300, 40);
		add(title);
		
		// Breed Label
		JLabel lblBreedName = new JLabel("Breed:");
		lblBreedName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblBreedName.setLocation(10, 65);
		lblBreedName.setSize(w, 20);
		add(lblBreedName);
		
	}
	
	@Override
	public boolean allFieldsReady() {
		// TODO Auto-generated method stub
		return false;
	}

}
