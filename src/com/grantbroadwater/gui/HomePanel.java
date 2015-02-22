package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.animal.Animal;
import com.grantbroadwater.animal.AnimalType;
import com.grantbroadwater.animal.Animals;
import com.grantbroadwater.animal.Chip;
import com.grantbroadwater.animal.Dog;
import com.grantbroadwater.util.Log;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String newPrompt = "Create New Animal";

	private JComboBox<String> animalComboBox;
	private JButton enter;
	private BasicInfoPanel basicInfoPanel;
	private SpecificInfoPanel specificInfoPanel;
	private JButton saveButton;
	private JButton adoptButton;
	
	private boolean toOverwriteAnimal;
	private Animal animalToOverwrite;
	
	public HomePanel() {
		super(null);
		
		// Panel
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Title Label
		JLabel title = new JLabel("Animal Records System");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 32));
		title.setSize(800, 50);
		title.setLocation(250,25);
		add(title);
		
		// Enter button
		enter = new JButton("Enter");
		enter.setFont(new Font(enter.getFont().getName(), Font.PLAIN, 16));
		enter.setLocation(475, 100);
		enter.setSize(100, 30);
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformedOnComboBox();
			}
		});
		add(enter);
		
		toOverwriteAnimal = false;
		animalToOverwrite = null;
		
		// Basic Info Panel
		basicInfoPanel = new BasicInfoPanel();
		basicInfoPanel.setLocation(10, 200);
		basicInfoPanel.setSize(325, 325);
		add(basicInfoPanel);
		
		// Specific Info Panel
		specificInfoPanel = new DogInfoPanel();
		specificInfoPanel.setLocation(350, 200);
		specificInfoPanel.setSize(440, 325);
		add(specificInfoPanel);
		
		// Save Button
		saveButton = new JButton("Save");
		saveButton.setFont(new Font(enter.getFont().getName(), Font.PLAIN, 16));
		saveButton.setLocation(675, 550);
		saveButton.setSize(100, 30);
		saveButton.addActionListener(new ActionListener(){@Override
			public void actionPerformed(ActionEvent e) {
				if(allFieldsReady())
					saveAnimalFromGUI();
			}
		});
		add(saveButton);
		
		// Adopt Button
		adoptButton = new JButton("Adopt");
		adoptButton.setFont(new Font(enter.getFont().getName(), Font.PLAIN, 16));
		adoptButton.setLocation(550, 550);
		adoptButton.setSize(100, 30);
		adoptButton.addActionListener(new ActionListener(){@Override
			public void actionPerformed(ActionEvent e) {
				if(allFieldsReady())
					adoptAnimalFromGUI();
			}
		});
		add(adoptButton);
	}
	
	public void prep(){
		// Frame
		AnimalRecordsSystem.getFrame().showMenuBar();
		
		// Animal Combo Box
		if(animalComboBox != null)
			remove(animalComboBox);
		animalComboBox = new JComboBox<String>(prependArray(AnimalRecordsSystem.getAnimals().getAllCurrentCaseNumbers(), newPrompt));
		animalComboBox.setEditable(true);
		animalComboBox.setFont(new Font(animalComboBox.getFont().getName(), Font.PLAIN, 16));
		animalComboBox.setLocation(250, 100);
		animalComboBox.setSize(200, 30);
		animalComboBox.setSelectedItem(newPrompt);
		animalComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformedOnComboBox();
			}
		});
		add(animalComboBox);
	}
	
	public void prepAndShow(){
		this.prep();
		AnimalRecordsSystem.getFrame().setMainPanel(this);
	}
	
	private void actionPerformedOnComboBox(){
		if(animalComboBox.getSelectedItem().equals(newPrompt)){
			toOverwriteAnimal = false;
			animalToOverwrite = null;
			clearAllFields();
		}else{
			toOverwriteAnimal = true;
			animalToOverwrite = AnimalRecordsSystem.getAnimals().getAnimalWithCaseNumber((String)animalComboBox.getSelectedItem());
			if(animalToOverwrite != null)
				setAllFields();
			else
				clearAllFields();
		}
	}
	
	protected void setSpecificInfoPanel(SpecificInfoPanel panel){
		this.specificInfoPanel = panel;
		AnimalRecordsSystem.getFrame().updateGraphics();
	}
	
	private String[] prependArray(String[] array, String message){
		String[] result = new String[array.length + 1];
		result[0] = message;
		
		for(int i=1; i<result.length; i++)
			result[i] = array[i-1];
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	private void clearAllFields(){
		for(Component c : basicInfoPanel.getComponents()){
			if(c instanceof JTextField){
				if(c.getName().toLowerCase().indexOf("date") != -1)
					((JTextField)c).setText("mm/dd/yyyy");
				else
					((JTextField)c).setText("");
			}else if(c instanceof JComboBox){
				((JComboBox)c).setSelectedIndex(0);
			}
			c.setBackground(Color.WHITE);
		}
		for(Component c : specificInfoPanel.getComponents()){
			if(c instanceof JTextField){
				if(c.getName().toLowerCase().indexOf("date") != -1)
					((JTextField)c).setText("mm/dd/yyyy");
				else
					((JTextField)c).setText("");
			}else if(c instanceof JComboBox){
				((JComboBox)c).setSelectedIndex(0);
			}else if(c instanceof JCheckBox){
				((JCheckBox)c).setSelected(false);
			}
			c.setBackground(Color.WHITE);
		}
		new Log("Cleared");
	}
	
	private void setAllFields(){
		new Log("Fill fields with "+animalToOverwrite.getName()+"'s properties");
		
		basicInfoPanel.setName(animalToOverwrite.getName());
		basicInfoPanel.setAge(animalToOverwrite.getAge());
		basicInfoPanel.setDateOfBirth(animalToOverwrite.getDateOfBirth());
		basicInfoPanel.setDateOfArrival(animalToOverwrite.getDateOfArrival());
		basicInfoPanel.setRelinquishingParty(animalToOverwrite.getRelinquishingParty());
		basicInfoPanel.setCageNumber(animalToOverwrite.getCageNumber());
		basicInfoPanel.setChippped(animalToOverwrite.getChip().isChipped());
		basicInfoPanel.setChipNumber(animalToOverwrite.getChip().getChipNumber());
		if(animalToOverwrite.getChip().isChipped()){
			basicInfoPanel.setChipDate(animalToOverwrite.getChip().getContactDate());
			basicInfoPanel.setChipOwner(animalToOverwrite.getChip().getOwner());
		}else{
			basicInfoPanel.setChipDate(animalToOverwrite.getChip().getImplantDate());
		}
		
		
		switch(animalToOverwrite.getType()){
		case DOG:
			fillFromDog();
			break;
		case CAT:
			fillFromCat();
			break;
		case OTHER:
			fillFromOther();
			break;
		default:
			break;
		}
	}
	
	private void fillFromDog(){
		DogInfoPanel DIP = (DogInfoPanel)specificInfoPanel;
		Dog d = (Dog)animalToOverwrite;
		DIP.setBreed(d.getBreed());
		DIP.setSex(d.getSex());
		DIP.setFleaTested(d.isFleaTested());
		if(d.isFleaTested())
			DIP.setFleaTestDate(d.getFirstFleaTreatment());
		DIP.setHeartwormTested(d.isHeartwormTested());
		if(d.isHeartwormTested()){
			DIP.setFirstHeartwormTreatment(d.getBeginHeartwormDate());
			DIP.setResetHeartwormTreatment(d.getResetHeartwormDate());
		}
		DIP.setRabiesVaccinated(d.isRabiesVaccinated());
		DIP.setRabiesDate(d.getRabiesDate());
		DIP.setDistemperVaccinated(d.isDistemperVaccinated());
		DIP.setDistemperDate(d.getDistemperDate());
		DIP.setBordetellaVaccinated(d.isBordetellaVaccinated());
		DIP.setBordetellaDate(d.getBordetellaDate());
		DIP.setSpayedNeutered(d.isSpayedNeutered());
		if(!d.isSpayedNeutered())
			DIP.setSpayedNeuteredDate(d.getSpayedNeuteredDate());
		DIP.setQuarentined(d.isQuarantined());
	}
	
	
	private void fillFromCat(){
		
	}
	
	private void fillFromOther(){
		
	}
	
	private boolean allFieldsReady(){
		return basicInfoPanel.allFieldsReady() && specificInfoPanel.allFieldsReady();
	}
	
	private void adoptAnimalFromGUI(){
		if(!allFieldsReady())
			return;
		
		switch(basicInfoPanel.getType()){
		case DOG:
			AnimalRecordsSystem.getAnimals().moveToPast(getDogFromGUI());
			break;
		case CAT:
			
			break;
		case OTHER:
			
			break;
		default:
			break;
		}
		AnimalRecordsSystem.getAnimals().saveAnimals();
		AnimalRecordsSystem.presentHomePanel();
	}
	
	private void saveAnimalFromGUI(){
		Animals animals = AnimalRecordsSystem.getAnimals();
		switch(basicInfoPanel.getType()){
		case DOG:
			if(toOverwriteAnimal)
				animals.replace(animalToOverwrite, getDogFromGUI());
			else
				animals.addCurrentAnimal(getDogFromGUI());
			break;
		case CAT:
			
			break;
		case OTHER:
			
			break;
		default:
			return;
		}
		AnimalRecordsSystem.getAnimals().saveAnimals();
		AnimalRecordsSystem.presentHomePanel();
	}

	private Dog getDogFromGUI(){
		Dog d = new Dog();
		
		// Animal General
		d.setName(basicInfoPanel.getName());
		d.setType(AnimalType.DOG);
		d.setAge(basicInfoPanel.getAge());
		d.setDateOfBirth(basicInfoPanel.getDateOfBirth());
		d.setDateOfArrival(basicInfoPanel.getDateOfArrival());
		d.setRelinquishingParty(basicInfoPanel.getRelinquishingParty());
		d.setCageNumber(basicInfoPanel.getCageNumber());
		d.setQuarantined(true);
		if(basicInfoPanel.getChipped())
			d.setChip(new Chip(basicInfoPanel.getChipOwner(), basicInfoPanel.getChipNumber(), basicInfoPanel.getChipDate()));
		else
			d.setChip(new Chip(basicInfoPanel.getChipNumber(), basicInfoPanel.getChipDate()));
		
		// Dog Specific
		DogInfoPanel DIP = (DogInfoPanel)specificInfoPanel;
		d.setBreed(DIP.getBreed());
		d.setSex(DIP.getSex());
		d.setFleaTested(DIP.getFleaTested());
		if(d.isFleaTested())
			d.setFirstFleaTreatment(DIP.getFleaTestDate());
		d.setHeartwormTested(DIP.getHeartwormTested());
		if(d.isHeartwormTested()){
			d.setBeginHeartwormDate(DIP.getFirstHeartwormTreatment());
			d.setResetHeartwormDate(DIP.getResetHeartwormTreatment());
		}
		d.setRabiesVaccinated(DIP.getRabiesVaccinated());
		d.setRabiesDate(DIP.getRabiesDate());
		d.setDistemperVaccinated(DIP.getDistemperVaccinated());
		d.setDistemperDate(DIP.getDistemperDate());
		d.setBordetellaVaccinated(DIP.getBordetellaVaccinated());
		d.setBordetellaDate(DIP.getBordetellaDate());
		d.setSpayedNeutered(DIP.getSpayedNeutered());
		if(!d.isSpayedNeutered())
			d.setSpayedNeuteredDate(DIP.getSpayedNeuteredDate());
	
		d.setQuarantined(DIP.isQuarentined());
		
		if(!toOverwriteAnimal){
			d.generateCaseNumber();
		}else{
			d.setCaseNumber((String)animalComboBox.getSelectedItem());
		}
		
		if((d.getCaseNumber().charAt(0) == 'Q' && !d.isQuarantined())
				|| (d.getCaseNumber().charAt(0) != 'Q' && d.isQuarantined())){
			String pre = (d.isQuarantined()) ? "Q" : "";
			d.setCaseNumber(pre + d.getCaseNumber().replace("Q", ""));
		}
			
		return d;
	}
	
}
