package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.grantbroadwater.animal.Animal;
import com.grantbroadwater.animal.AnimalType;

public class BasicInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<AnimalType> typeComboBox;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField dobTextField;
	private JTextField doaTextField;
	private JTextField partyTextField;
	private JTextField cageTextField;
	private JComboBox<Boolean> chippedComboBox;
	// TODO: Chip
	
	public BasicInfoPanel(){
		super();
		
		// Panel	
		setLayout(null);
		setBackground(Color.WHITE);	
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Main Label
		JLabel lblMain = new JLabel("General Information");
		lblMain.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
		lblMain.setLocation(70, 10);
		lblMain.setSize(300, 40);
		add(lblMain);
		
		// Type Combo Box
		AnimalType[] types = {AnimalType.DOG, AnimalType.CAT, AnimalType.OTHER};
		typeComboBox = new JComboBox<AnimalType>(types);
		typeComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		typeComboBox.setLocation(85, 50);
		typeComboBox.setSize(150, 25);
		typeComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		add(typeComboBox);
		
		// Name Label
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblName.setLocation(10, 85);
		lblName.setSize(150, 20);
		add(lblName);
		
		// Name Text Field
		nameTextField = new JTextField();
		nameTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		nameTextField.setLocation(10, 105);
		nameTextField.setSize(150, 20);
		add(nameTextField);
		
		// Age Label
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblAge.setLocation(10, 125);
		lblAge.setSize(150, 20);
		add(lblAge);
				
		// Age Text Field
		ageTextField = new JTextField();
		ageTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		ageTextField.setLocation(10, 145);
		ageTextField.setSize(150, 20);
		add(ageTextField);
		
		// DOB Label
		JLabel lblDOB = new JLabel("Date of Birth:");
		lblDOB.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblDOB.setLocation(10, 170);
		lblDOB.setSize(150, 20);
		add(lblDOB);
						
		// DOB Text Field
		dobTextField = new JTextField("MM/DD/YYYY");
		dobTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		dobTextField.setLocation(10, 190);
		dobTextField.setSize(150, 20);
		add(dobTextField);
		
		
		// DOA Label
		JLabel lblDOA = new JLabel("Date of Arrival:");
		lblDOA.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblDOA.setLocation(10, 215);
		lblDOA.setSize(150, 20);
		add(lblDOA);
								
		// DOA Text Field
		doaTextField = new JTextField("MM/DD/YYYY");
		doaTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		doaTextField.setLocation(10, 235);
		doaTextField.setSize(150, 20);
		add(doaTextField);
		
		// Relinquishing Party Label
		JLabel lblParty = new JLabel("Relinquishing Party:");
		lblParty.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblParty.setLocation(10, 260);
		lblParty.setSize(150, 20);
		add(lblParty);
						
		// Relinquishing Party Text Field
		partyTextField = new JTextField();
		partyTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		partyTextField.setLocation(10, 280);
		partyTextField.setSize(150, 20);
		add(partyTextField);
		
		// Cage Number Label
		JLabel lblCage = new JLabel("Cage Number:");
		lblCage.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblCage.setLocation(170, 85);
		lblCage.setSize(150, 20);
		add(lblCage);
								
		// Cage Number Text Field
		cageTextField = new JTextField();
		cageTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		cageTextField.setLocation(170, 105);
		cageTextField.setSize(150, 20);
		add(cageTextField);
		
		// Chipped Label
		JLabel lblChipped = new JLabel("Has Micro-Chip:");
		lblChipped.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblChipped.setLocation(170, 125);
		lblChipped.setSize(150, 20);
		add(lblChipped);
		
		// Type Combo Box
		Boolean[] values = {true, false};
		chippedComboBox = new JComboBox<Boolean>(values);
		chippedComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		chippedComboBox.setLocation(170, 145);
		chippedComboBox.setSize(150, 20);
		chippedComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		add(chippedComboBox);
	}
	
	public AnimalType getType(){
		return (AnimalType) typeComboBox.getSelectedItem();
	}
	
	public String getName(){
		return nameTextField.getText();
	}
	
	public int getAge(){
		try {
			return Integer.parseInt(ageTextField.getText());
		} catch (Exception e) {
			return -1;
		}
	}
	
	public java.util.Date getDateOfBirth(){
		try {
			return Animal.parseDate(dobTextField.getText());
		} catch (Exception e) {
			return null;
		}
	}
	
	public java.util.Date getDateOfArrival(){
		try {
			return Animal.parseDate(doaTextField.getText());
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getRelinquishingParty(){
		return this.partyTextField.getText();
	}
	
	public int getCageNumber(){
		try {
			return Integer.parseInt(cageTextField.getText());
		} catch (Exception e) {
			return -1;
		}
	}

}
