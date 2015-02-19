package com.grantbroadwater;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.grantbroadwater.animal.Animals;
import com.grantbroadwater.animal.Chip;
import com.grantbroadwater.animal.Dog;
import com.grantbroadwater.animal.DogBreed;
import com.grantbroadwater.animal.HairType;
import com.grantbroadwater.animal.Sex;
import com.grantbroadwater.animal.WeightRange;
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
	
	
	@SuppressWarnings("deprecation")
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
		homePanel = new HomePanel();
		
		Dog d = new Dog("Doug", 23, new Date(1999, 1, 1), new Date(), new Chip(), "Broads", 457, new DogBreed("Retreiver", new WeightRange(20, 30), "Golden", HairType.SHORT), Sex.MALE, true, true, true, true, true, true);
		System.out.println(d.getStringRepresentation());
		animals.addCurrentAnimal(d);
		System.out.println(animals.getAll().size());
		animals.saveAnimals();
		animals.clear();
		animals.loadAnimals();
		System.out.println(animals.getCurrentDogs().get(0).getStringRepresentation());
		System.out.println(Arrays.toString(animals.getAll().toArray()));
		
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
		presentHomePanel();
	}
	
	public static void presentHomePanel(){
		homePanel.prep();
		frame.setTitle(currentUser.getName());
		frame.setMainPanel(homePanel);
	}
	
	public static ARSFrame getFrame(){
		return frame;
	}

	public static Animals getAnimals() {
		return animals;
	}
}
