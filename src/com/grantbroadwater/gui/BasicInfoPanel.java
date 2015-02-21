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

import com.grantbroadwater.AnimalRecordsSystem;
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
	// TODO: Chip
	private JComboBox<Boolean> chippedComboBox;
	private JTextField chipNumberTextField;
	private JLabel lblDate;
	private JTextField dateTextField;
	private JLabel lblOwner;
	private JTextField ownerTextField;
	
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
		dobTextField = new JTextField("mm/dd/yyyy");
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
		doaTextField = new JTextField("mm/dd/yyyy");
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
				if(chippedComboBox.getSelectedItem().equals(true)){
					lblDate.setText("Contact Date:");
					dateTextField.setText("mm/dd/yyyy");
					lblOwner.setVisible(true);
					ownerTextField.setVisible(true);
					ownerTextField.setText("");
				}else if(chippedComboBox.getSelectedItem().equals(false)){
					lblDate.setText("Implant Date:");
					dateTextField.setText("mm/dd/yyyy");
					lblOwner.setVisible(false);
					ownerTextField.setVisible(false);
				}
				AnimalRecordsSystem.getFrame().updateGraphics();
			}
		});
		add(chippedComboBox);
		
		// Chip Number label
		JLabel lblChipNumber = new JLabel("Chip Number:");
		lblChipNumber.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblChipNumber.setLocation(170, 170);
		lblChipNumber.setSize(150, 20);
		add(lblChipNumber);
		
		// Chip Number Text Field
		chipNumberTextField = new JTextField();
		chipNumberTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		chipNumberTextField.setLocation(170, 190);
		chipNumberTextField.setSize(150, 20);
		add(chipNumberTextField);
		
		// Date Label
		lblDate = new JLabel("Contact Date:");
		lblDate.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblDate.setLocation(170, 215);
		lblDate.setSize(150, 20);
		add(lblDate);
		
		// Date Text Field
		dateTextField = new JTextField("mm/dd/yyyy");
		dateTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		dateTextField.setLocation(170, 235);
		dateTextField.setSize(150, 20);
		add(dateTextField);
		
		// Owner Label
		lblOwner = new JLabel("Owner:");
		lblOwner.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblOwner.setLocation(170, 260);
		lblOwner.setSize(150, 20);
		add(lblOwner);
		
		// Owner Text Field
		ownerTextField = new JTextField();
		ownerTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		ownerTextField.setLocation(170, 280);
		ownerTextField.setSize(150, 20);
		add(ownerTextField);
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
