package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.grantbroadwater.AnimalRecordsSystem;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String newPrompt = "Create New Animal";

	private JComboBox<String> animalComboBox;
	private BasicInfoPanel basicInfoPanel;
	private SpecificInfoPanel specificInfoPanel;
	
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
		JButton enter = new JButton("Enter");
		enter.setFont(new Font(enter.getFont().getName(), Font.PLAIN, 16));
		enter.setLocation(475, 100);
		enter.setSize(100, 30);
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Enter event handler
			}
		});
		add(enter);
		
		
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
		// TODO: Event Handler
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

}
