package com.grantbroadwater.gui;

import java.awt.*;
import java.awt.event.*;

public class ARSMenuBar extends MenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu ars, manage;
	private MenuItem exit, mStaff, mAnimals;

	public ARSMenuBar() throws HeadlessException {
		super();
		
		// Menu Items
		exit = new MenuItem("Exit Application");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ARSFrame.terminate();
			}
		});
				
		mStaff = new MenuItem("Manage Staff");
		mAnimals = new MenuItem("Manage Animals");
				
		// Menus
		ars = new Menu("Animal Records System");
		ars.add(exit);
		manage = new Menu("Manage");		
		manage.add(mStaff);
		manage.add(mAnimals);
				
		add(ars);
		add(manage);
		
	}

}
