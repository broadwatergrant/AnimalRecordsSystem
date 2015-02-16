package com.grantbroadwater;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.grantbroadwater.animal.Chip;
import com.grantbroadwater.animal.Dog;
import com.grantbroadwater.animal.DogBreed;
import com.grantbroadwater.animal.HairType;
import com.grantbroadwater.animal.Sex;
import com.grantbroadwater.animal.WeightRange;
import com.grantbroadwater.gui.ARSFrame;
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
	
	
	public static void main(String[] args) throws Exception {
		new Log("Now running AnimalRecordsSystem.");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		init();
		frame = new ARSFrame();
		frame.setVisible(true);
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
		
		@SuppressWarnings("deprecation")
		Dog d = new Dog("Doug", 5, new java.util.Date(1999, 1, 1), new java.util.Date(2015, 1, 1), new Chip(), "Broadwaters", 55, new DogBreed("Retreiver", new WeightRange(60, 100), "Golden", HairType.LONG), Sex.MALE, true, true, true, true, true, true);
		System.out.println(d);
		System.out.println(d.getCaseNumber());
		
		new Log("Now closing AnimalRecordsSystem.");
	}
	
	private static void init(){
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
		JOptionPane.showMessageDialog(null, currentUser+" succesfully signed in");
		// TODO: Present HomePanel
	}
	
	public static ARSFrame getFrame(){
		return frame;
	}

}
