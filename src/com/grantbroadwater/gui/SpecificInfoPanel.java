package com.grantbroadwater.gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class SpecificInfoPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecificInfoPanel(){
		super();
		
		// Panel
		setLayout(null);
		setBackground(Color.WHITE);	
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public abstract boolean allFieldsReady();
}
