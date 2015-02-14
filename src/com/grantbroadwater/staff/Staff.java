package com.grantbroadwater.staff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.util.Log;

public class Staff {
	private static final String FILEPATH = 
			AnimalRecordsSystem.homeDirecotry+"\\.staff";

	private HashMap<String, StaffMember> staffList;
	private File staffFile;
	
	
	public Staff() throws IOException {
		staffList = new HashMap<String, StaffMember>();
		staffFile = new File(FILEPATH);
		if(!staffFile.exists()){
			staffFile.createNewFile();
			new Log("Staff File Created: "+staffFile.getAbsolutePath());
		}
	}
	
	public boolean loadStaff(){
		try {
			Scanner scan = new Scanner(staffFile, "UTF-8");
			scan.useDelimiter(";");
			staffList.clear();
			while(scan.hasNext()){
				String staffString = scan.next();
				String[] s = staffString.split(":");
				this.add(new StaffMember(
						s[0], s[1], s[2], Boolean.parseBoolean(s[3])
						));
			}
			scan.close();
			new Log(staffList.size()+" staff members loaded.");
			return staffList.size()>0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean saveStaff(){
		try {
			PrintWriter writer = new PrintWriter(staffFile, "UTF-8");
			
			for(StaffMember s : staffList.values()){
				writer.print(s.toStringForSave());
			}
			
			writer.close();
			new Log(staffList.size()+" staff members saved.");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public StaffMember[] getStaffArray(){
		return staffList.values().toArray(new StaffMember[staffList.size()]);
	}
	
	public Set<String> getKeySet(){
		return this.staffList.keySet();
	}
	
	public void add(StaffMember staffMember){
		staffList.put(staffMember.getPin(), staffMember);
	}
	
	public void remove(StaffMember staffMember){
		staffList.remove(staffMember.getPin());
	}
	
	public StaffMember getStaffMemberWithPin(String pin){
		return staffList.get(pin);
	}
	
	public StaffMember getStaffMemberWithName(String firstName, String lastName){
		String name = firstName+" "+lastName;
		for(String key : staffList.keySet()){
			if (getStaffMemberWithPin(key).getName().equals(name))
				return getStaffMemberWithPin(key);
		}
		return null;
	}
	
}
