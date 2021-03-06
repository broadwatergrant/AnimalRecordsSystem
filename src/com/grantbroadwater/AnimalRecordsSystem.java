package com.grantbroadwater;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.grantbroadwater.animal.Animal;
import com.grantbroadwater.animal.AnimalType;
import com.grantbroadwater.animal.Animals;
import com.grantbroadwater.gui.ARSFrame;
import com.grantbroadwater.gui.HomePanel;
import com.grantbroadwater.gui.SetUpPanel;
import com.grantbroadwater.gui.SignInPanel;
import com.grantbroadwater.staff.Staff;
import com.grantbroadwater.staff.StaffMember;
import com.grantbroadwater.util.*;

public class AnimalRecordsSystem {

	public static final String homeDirecotry = 
			System.getProperty("user.home")+"\\Broadwater Software\\Animal Records System";
	
	private static Staff staff;
	private static ARSFrame frame;
	private static StaffMember currentUser;
	private static Animals animals;
	private static HomePanel homePanel;
	
	public static void main(String[] args) throws Exception {
		new Log("Now running AnimalRecordsSystem.");
		
		// Initialize this instance of the animal records system
		init();
		
		// Construct the frame
		frame = new ARSFrame();
		frame.setVisible(true);
		
		// Load Staff Members
		staff = new Staff();
		if(!staff.loadStaff()){
			new Log("Failed to load staff", true);
			JOptionPane.showMessageDialog(null, "Program was not able to find any staff members."
					+"\nCheck the staff file has not been manipulated"
					+"\nor enter new staff members.");
			frame.setMainPanel(new SetUpPanel());
		}else{
			AnimalRecordsSystem.getFrame().setMainPanel(new SignInPanel());
		}
		
		// Initialize Animals
		animals = new Animals();
		
		// Home Panel
		homePanel = new HomePanel(AnimalType.CAT);
		
		new Log("Main Thread Closing");
	}
	
	// Initialize the animal records system
	private static void init(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		File homeDir = new File(homeDirecotry);
		if(!homeDir.exists())
			homeDir.mkdirs();
	}
	
	public static StaffMember[] getStaffArray(){
		return staff.getStaffArray();
	}
	
	public static Staff getStaff(){
		return staff;
	}
	
	public static StaffMember getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(StaffMember currentUser) {
		AnimalRecordsSystem.currentUser = currentUser;
	}

	public static void signUserIn(StaffMember currentUser){
		setCurrentUser(currentUser);
		presentHomePanel(AnimalType.CAT);
	}
	
	public static void presentHomePanel(){
		frame.setTitle(currentUser.getName());
		homePanel = new HomePanel();
		homePanel.prepAndShow();
	}
	
	public static void presentHomePanel(Animal a){
		frame.setTitle(currentUser.getName());
		homePanel = new HomePanel(a);
		homePanel.prepAndShow();
	}
	
	public static void presentHomePanel(AnimalType a){
		frame.setTitle(currentUser.getName());
		homePanel = new HomePanel(a);
		homePanel.prepAndShow();
	}
	
	public static HomePanel getHomePanel(){
		return homePanel;
	}
	
	public static ARSFrame getFrame(){
		return frame;
	}

	public static Animals getAnimals() {
		return animals;
	}
}
