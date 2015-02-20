package com.grantbroadwater.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

import com.grantbroadwater.AnimalRecordsSystem;

public class ARSMenuBar extends MenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu ars, manage;
	private MenuItem exit, signOut, mStaff, mAnimals;

	public ARSMenuBar() throws HeadlessException {
		super();
		
		// Menu Items
		exit = new MenuItem("Exit Application");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ARSFrame.terminate();
			}
		});
		
		signOut = new MenuItem("Sign Out");
		signOut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AnimalRecordsSystem.getFrame().setMainPanel(new SignInPanel());
			}
		});
		
		mStaff = new MenuItem("Manage Staff");
		mStaff.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(AnimalRecordsSystem.getCurrentUser().isAdmin())
					AnimalRecordsSystem.getFrame().setMainPanel(new SetUpPanel());
				else
					JOptionPane.showMessageDialog(null, "Insufficient security clearance", "Restricted", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		mAnimals = new MenuItem("Manage Animals");
		mAnimals.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AnimalRecordsSystem.presentHomePanel();
			}
		});
				
		// Menus
		ars = new Menu("Animal Records System");
		ars.add(signOut);
		ars.add(exit);
		manage = new Menu("Manage");		
		manage.add(mStaff);
		manage.add(mAnimals);
				
		add(ars);
		add(manage);
		
	}

}
