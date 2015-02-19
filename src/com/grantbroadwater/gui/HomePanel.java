package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
		
	}
	
	public void prep(){
		// Frame
		AnimalRecordsSystem.getFrame().showMenuBar();
		
		// Animal Combo Box
		if(animalComboBox != null)
			remove(animalComboBox);
		animalComboBox = new JComboBox<String>(prependArray(AnimalRecordsSystem.getAnimals().getAllCurrentCaseNumbers(), newPrompt));
		animalComboBox.setFont(new Font(animalComboBox.getFont().getName(), Font.PLAIN, 16));
		animalComboBox.setLocation(200, 100);
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
		
	}
	
	private String[] prependArray(String[] array, String message){
		String[] result = new String[array.length + 1];
		result[0] = message;
		
		for(int i=1; i<result.length; i++)
			result[i] = array[i-1];
		
		return result;
	}

}
