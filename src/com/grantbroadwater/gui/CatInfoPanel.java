package com.grantbroadwater.gui;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	}
	
	@Override
	public boolean allFieldsReady() {
		// TODO Auto-generated method stub
		return false;
	}

}
