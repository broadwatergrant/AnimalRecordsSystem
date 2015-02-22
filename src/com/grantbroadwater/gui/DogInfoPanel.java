package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.grantbroadwater.animal.Animal;
import com.grantbroadwater.animal.DogBreed;
import com.grantbroadwater.animal.HairType;
import com.grantbroadwater.animal.Sex;
import com.grantbroadwater.animal.WeightRange;

public class DogInfoPanel extends SpecificInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField breedNameTextField;
	private JTextField wrLowTextField;
	private JComboBox<HairType> hairTypeComboBox;
	private JTextField hairColorTextField;
	private JTextField wrHighTextField;
	private JComboBox<Sex> sexComboBox;
	private JComboBox<Boolean> fleaComboBox;
	private JTextField fleaTestTextField;
	private JComboBox<String> heartwormComboBox;
	private JTextField firstHeartwormTextField;
	private JTextField resetHeartwormTextField;
	private JCheckBox rabiesCheckBox;
	private JTextField rabiesTextField;
	private JCheckBox distemperCheckBox;
	private JTextField distemperTextField;
	private JCheckBox bordetellaCheckBox;
	private JTextField bordetellaTextField;
	private JComboBox<Boolean> spayedNeuteredComboBox;
	private JTextField spayedNeuteredTextField;
	private JCheckBox isQuar;
	
	public DogInfoPanel() {
		super();
		
		int w = 125;
		
		JLabel title = new JLabel("Dog Information");
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
		
		// Breed Name Text Field
		breedNameTextField = new JTextField();
		breedNameTextField.setName("Breed");
		breedNameTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		breedNameTextField.setLocation(10, 85);
		breedNameTextField.setSize(w, 20);
		add(breedNameTextField);
		
		// Weight Range Label
		JLabel lblWR = new JLabel("Weight Range:");
		lblWR.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblWR.setLocation(10, 105);
		lblWR.setSize(w, 20);
		add(lblWR);
		
		// Weight Range Low Text Field
		wrLowTextField = new JTextField();
		wrLowTextField.setName("Weight Range (Low)");
		wrLowTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		wrLowTextField.setLocation(10, 125);
		wrLowTextField.setSize(57, 20);
		add(wrLowTextField);
		
		// Dash Label
		JLabel lblDash = new JLabel("-");
		lblDash.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblDash.setLocation(69, 125);
		lblDash.setSize(6, 20);
		add(lblDash);
		
		// Weight Range High Text Field
		wrHighTextField = new JTextField();
		wrHighTextField.setName("Weight Range (High)");
		wrHighTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		wrHighTextField.setLocation(77, 125);
		wrHighTextField.setSize(57, 20);
		add(wrHighTextField);
		
		// Hair Type Label
		JLabel lblHairType = new JLabel("Hair Type:");
		lblHairType.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHairType.setLocation(10, 145);
		lblHairType.setSize(w, 20);
		add(lblHairType);
		
		// Hair Type Combo Box
		HairType[] hairTypes = {HairType.SHORT, HairType.LONG};
		hairTypeComboBox = new JComboBox<HairType>(hairTypes);
		hairTypeComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		hairTypeComboBox.setLocation(10, 165);
		hairTypeComboBox.setSize(w, 20);
		add(hairTypeComboBox);
		
		// Hair Color Label
		JLabel lblHairColor = new JLabel("Hair Color:");
		lblHairColor.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHairColor.setLocation(10, 185);
		lblHairColor.setSize(w, 20);
		add(lblHairColor);
		
		// Hair Color Text Field
		hairColorTextField = new JTextField();
		hairColorTextField.setName("Hair Color");
		hairColorTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		hairColorTextField.setLocation(10, 205);
		hairColorTextField.setSize(w, 20);
		add(hairColorTextField);
		
		// Sex Label
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblSex.setLocation(10, 225);
		lblSex.setSize(w, 20);
		add(lblSex);
		
		// Sex Combo Box
		Sex[] sexes = {Sex.MALE, Sex.FEMALE};
		sexComboBox = new JComboBox<Sex>(sexes);
		sexComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		sexComboBox.setLocation(10, 245);
		sexComboBox.setSize(w, 20);
		add(sexComboBox);
		
		// Flea Tested Label
		JLabel lblFleaTest = new JLabel("Flea Tested:");
		lblFleaTest.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblFleaTest.setLocation(145, 65);
		lblFleaTest.setSize(w, 20);
		add(lblFleaTest);
		
		// Flea Tested Combo Box
		Boolean[] bValues = {true, false};
		fleaComboBox = new JComboBox<Boolean>(bValues);
		fleaComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		fleaComboBox.setLocation(145, 85);
		fleaComboBox.setSize(w, 20);
		fleaComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				fleaTestTextField.setEnabled((Boolean)fleaComboBox.getSelectedItem());
				fleaTestTextField.setText("mm/dd/yyyy");
			}
		});
		add(fleaComboBox);
		
		// Flea Date Label
		JLabel lblFleaDate = new JLabel("First Treatment:");
		lblFleaDate.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblFleaDate.setLocation(145, 105);
		lblFleaDate.setSize(w, 20);
		add(lblFleaDate);
		
		// Flea Date Text Field
		fleaTestTextField = new JTextField("mm/dd/yyyy");
		fleaTestTextField.setName("Flea Test Date");
		fleaTestTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		fleaTestTextField.setLocation(145, 125);
		fleaTestTextField.setSize(w, 20);
		add(fleaTestTextField);
		
		// HeartWorm Label
		JLabel lblHartworm = new JLabel("Heartworm Results:");
		lblHartworm.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHartworm.setLocation(145, 145);
		lblHartworm.setSize(w, 20);
		add(lblHartworm);
		
		// Heart worm Combo Box
		String[] hwValues = {"Positive", "Negative"};
		heartwormComboBox = new JComboBox<String>(hwValues);
		heartwormComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		heartwormComboBox.setLocation(145, 165);
		heartwormComboBox.setSize(w, 20);
		heartwormComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(heartwormComboBox.getSelectedItem().equals("Positive")){
					firstHeartwormTextField.setEnabled(true);
					firstHeartwormTextField.setText("mm/dd/yyyy");
					resetHeartwormTextField.setEnabled(true);
					resetHeartwormTextField.setText("mm/dd/yyyy");
				}else if(heartwormComboBox.getSelectedItem().equals("Negative")){
					firstHeartwormTextField.setEnabled(false);
					firstHeartwormTextField.setText("mm/dd/yyyy");
					resetHeartwormTextField.setEnabled(false);
					resetHeartwormTextField.setText("mm/dd/yyyy");
				}
			}
		});
		add(heartwormComboBox);
		
		// Treatment Begins Label
		JLabel lblHartwormBegins = new JLabel("Begin Treatement:");
		lblHartwormBegins.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHartwormBegins.setLocation(145, 185);
		lblHartwormBegins.setSize(w, 20);
		add(lblHartwormBegins);
		
		// Treatment Begins Text Field
		firstHeartwormTextField = new JTextField("mm/dd/yyyy");
		firstHeartwormTextField.setName("Heart Worm Starting Date");
		firstHeartwormTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		firstHeartwormTextField.setLocation(145, 205);
		firstHeartwormTextField.setSize(w, 20);
		add(firstHeartwormTextField);
		
		// Treatment Reset Label
		JLabel lblReset = new JLabel("Reset Date:");
		lblReset.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblReset.setLocation(145, 225);
		lblReset.setSize(w, 20);
		add(lblReset);
		
		// Treatment Reset Text Field
		resetHeartwormTextField = new JTextField("mm/dd/yyyy");
		resetHeartwormTextField.setName("Heart Worm Reset Date");
		resetHeartwormTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		resetHeartwormTextField.setLocation(145, 245);
		resetHeartwormTextField.setSize(w, 20);
		add(resetHeartwormTextField);
		
		// Rabies Check Box
		rabiesCheckBox = new JCheckBox("Rabies Vaccinated:");
		rabiesCheckBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		rabiesCheckBox.setLocation(280, 65);
		rabiesCheckBox.setSize(w+5, 20);
		rabiesCheckBox.setBackground(Color.WHITE);
		add(rabiesCheckBox);
		
		// Rabies Text Field
		rabiesTextField = new JTextField("mm/dd/yyyy");
		rabiesTextField.setName("Rabies Date");
		rabiesTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		rabiesTextField.setLocation(280, 85);
		rabiesTextField.setSize(w, 20);
		add(rabiesTextField);
		
		// Distemper Check Box
		distemperCheckBox= new JCheckBox("Distemper Vac:");
		distemperCheckBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		distemperCheckBox.setLocation(280, 105);
		distemperCheckBox.setSize(w, 20);
		distemperCheckBox.setBackground(Color.WHITE);
		add(distemperCheckBox);
		
		// Distemper Text Field
		distemperTextField = new JTextField("mm/dd/yyyy");
		distemperTextField.setName("Distemper Date");
		distemperTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		distemperTextField.setLocation(280, 125);
		distemperTextField.setSize(w, 20);
		add(distemperTextField);
		
		// Bordetella Check Box
		bordetellaCheckBox= new JCheckBox("Bordetella Vac:");
		bordetellaCheckBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		bordetellaCheckBox.setLocation(280, 145);
		bordetellaCheckBox.setSize(w, 20);
		bordetellaCheckBox.setBackground(Color.WHITE);
		add(bordetellaCheckBox);
		
		// Bordetella Text Field
		bordetellaTextField = new JTextField("mm/dd/yyyy");
		bordetellaTextField.setName("Bordetella Date");
		bordetellaTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		bordetellaTextField.setLocation(280, 165);
		bordetellaTextField.setSize(w, 20);
		add(bordetellaTextField);
		

		// Spayed / Neutered Label
		JLabel lblSpayedNeutered = new JLabel("Spayed / Neutered:");
		lblSpayedNeutered.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		lblSpayedNeutered.setLocation(280, 185);
		lblSpayedNeutered.setSize(w, 20);
		add(lblSpayedNeutered);
		
		// Spayed / Neutered Combo Box
		spayedNeuteredComboBox = new JComboBox<Boolean>(bValues);
		spayedNeuteredComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		spayedNeuteredComboBox.setLocation(280, 205);
		spayedNeuteredComboBox.setSize(w, 20);
		spayedNeuteredComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				spayedNeuteredTextField.setEnabled(!(Boolean)spayedNeuteredComboBox.getSelectedItem());
				spayedNeuteredTextField.setText("mm/dd/yyyy");
			}
		});
		add(spayedNeuteredComboBox);
		
		// Spayed / Neutered Date Label
		JLabel lblSNDate = new JLabel("Procedure Date:");
		lblSNDate.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		lblSNDate.setLocation(280, 225);
		lblSNDate.setSize(w, 20);
		add(lblSNDate);
		
		// Spayed / Neutered Date Text Field
		spayedNeuteredTextField = new JTextField("mm/dd/yyyy");
		spayedNeuteredTextField.setName("Spayed / Neutered Date");
		spayedNeuteredTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		spayedNeuteredTextField.setLocation(280, 245);
		spayedNeuteredTextField.setSize(w, 20);
		spayedNeuteredTextField.setEnabled(false);
		add(spayedNeuteredTextField);
		
		isQuar = new JCheckBox("Is in Quarantine");
		isQuar.setBackground(Color.WHITE);
		isQuar.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		isQuar.setLocation(145, 265);
		isQuar.setSize(w, 20);
		add(isQuar);
	}
	
	public DogBreed getBreed(){
		return new DogBreed(breedNameTextField.getText(),
				new WeightRange(Double.parseDouble(wrLowTextField.getText()), Double.parseDouble(wrHighTextField.getText())),
				hairColorTextField.getText(),
				(HairType)hairTypeComboBox.getSelectedItem());
	}
	
	public void setBreed(DogBreed breed){
		breedNameTextField.setText(breed.getName());
		wrLowTextField.setText(""+breed.getWeight().getLow());
		wrHighTextField.setText(""+breed.getWeight().getHigh());
		hairColorTextField.setText(breed.getHairColor());
		hairTypeComboBox.setSelectedItem(breed.getHairType());
	}
	
	public Sex getSex(){
		return (Sex)sexComboBox.getSelectedItem();
	}
	
	public void setSex(Sex sex){
		sexComboBox.setSelectedItem(sex);
	}
	
	public boolean getFleaTested(){
		return (boolean)fleaComboBox.getSelectedItem();
	}

	public void setFleaTested(boolean value){
		fleaComboBox.setSelectedItem(value);
	}
	
	public Date getFleaTestDate(){
		return Animal.parseDate(fleaTestTextField.getText());
	}
	
	public void setFleaTestDate(Date date){
		fleaTestTextField.setText(Animal.printDate(date));
	}
	
	public boolean getHeartwormTested(){
		return heartwormComboBox.getSelectedItem().equals("Positive") ? true : false;
	}
	
	public void setHeartwormTested(boolean value){
		if(value)
			heartwormComboBox.setSelectedItem("Positive");
		else
			heartwormComboBox.setSelectedItem("Negative");
	}
	
	public Date getFirstHeartwormTreatment(){
		return Animal.parseDate(firstHeartwormTextField.getText());
	}
	
	public void setFirstHeartwormTreatment(Date date){
		firstHeartwormTextField.setText(Animal.printDate(date));
	}
	
	public Date getResetHeartwormTreatment(){
		return Animal.parseDate(resetHeartwormTextField.getText());
	}
	
	public void setResetHeartwormTreatment(Date date){
		resetHeartwormTextField.setText(Animal.printDate(date));
	}
	
	public boolean getRabiesVaccinated(){
		return rabiesCheckBox.isSelected();
	}
	
	public void setRabiesVaccinated(boolean value){
		rabiesCheckBox.setSelected(value);
	}
	
	public Date getRabiesDate(){
		return Animal.parseDate(rabiesTextField.getText());
	}
	
	public void setRabiesDate(Date date){
		rabiesTextField.setText(Animal.printDate(date));
	}
	
	public boolean getDistemperVaccinated(){
		return distemperCheckBox.isSelected();
	}
	
	public void setDistemperVaccinated(boolean value){
		distemperCheckBox.setSelected(value);
	}
	
	public Date getDistemperDate(){
		return Animal.parseDate(distemperTextField.getText());
	}
	
	public void setDistemperDate(Date date){
		distemperTextField.setText(Animal.printDate(date));
	}
	
	public boolean getBordetellaVaccinated(){
		return bordetellaCheckBox.isSelected();
	}
	
	public void setBordetellaVaccinated(boolean value){
		bordetellaCheckBox.setSelected(value);
	}
	
	public Date getBordetellaDate(){
		return Animal.parseDate(bordetellaTextField.getText());
	}
	
	public void setBordetellaDate(Date date){
		bordetellaTextField.setText(Animal.printDate(date));
	}
	
	public boolean getSpayedNeutered(){
		return (boolean)spayedNeuteredComboBox.getSelectedItem();
	}
	
	public void setSpayedNeutered(boolean value){
		spayedNeuteredComboBox.setSelectedItem(value);
	}
	
	public Date getSpayedNeuteredDate(){
		return Animal.parseDate(spayedNeuteredTextField.getText());
	}
	
	public void setSpayedNeuteredDate(Date date){
		bordetellaTextField.setText(Animal.printDate(date));
	}
	
	public boolean isQuarentined(){
		return isQuar.isSelected();
	}
	
	public void setQuarentined(boolean value){
		isQuar.setSelected(value);
	}

	@Override
	public boolean allFieldsReady() {
		
		// Breed Name Text Field
		if(breedNameTextField.getText().equals(""))
			return showErrorDialog(breedNameTextField);
		
		// Weight Range Low Text Field
		try {
			Double.parseDouble(wrLowTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(wrLowTextField);
		}
		
		// Weight Range High Text Field
		try {
			Double.parseDouble(wrHighTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(wrHighTextField);
		}
		
		// Hair Color Text Field
		if(hairColorTextField.getText().equals(""))
			return showErrorDialog(hairColorTextField);
		
		// Flea Test Date
		try {
			Animal.parseDate(fleaTestTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(fleaTestTextField);
		}
		
		// First Heartworm Text Field
		if(heartwormComboBox.getSelectedItem().equals("Positive")){
			try {
				Animal.parseDate(firstHeartwormTextField.getText());
			} catch (Exception e) {
				return showErrorDialog(firstHeartwormTextField);
			}
		
			// Reset Heartworm Text Field
			try {
				Animal.parseDate(resetHeartwormTextField.getText());
			} catch (Exception e) {
				return showErrorDialog(resetHeartwormTextField);
			}
		}
		
		// Rabies Date Text Field
		try {
			Animal.parseDate(rabiesTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(rabiesTextField);
		}
		
		// Distemper Date Text Field
		try {
			Animal.parseDate(distemperTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(distemperTextField);
		}
		
		// Bordetella Date Text Field
		try {
			Animal.parseDate(bordetellaTextField.getText());
		} catch (Exception e) {
			return showErrorDialog(bordetellaTextField);
		}
		
		// Spayed / Neutered Text Field
		if(spayedNeuteredComboBox.getSelectedItem().equals(false)){
			try {
				Animal.parseDate(spayedNeuteredTextField.getText());
			} catch (Exception e) {
				return showErrorDialog(spayedNeuteredTextField);
			}
		}
		
		return true;
	}
	
	private boolean showErrorDialog(Component comp){
		JOptionPane.showMessageDialog(null, comp.getName()+" is not correctly filled");
		return false;
	}
}
