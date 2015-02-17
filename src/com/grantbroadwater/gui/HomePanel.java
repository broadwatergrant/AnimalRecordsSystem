package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.grantbroadwater.AnimalRecordsSystem;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	}

}
