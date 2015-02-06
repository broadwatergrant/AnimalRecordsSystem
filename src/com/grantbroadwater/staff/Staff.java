package com.grantbroadwater.staff;

import java.util.*;

public class Staff {
	private HashMap<String, StaffMember> staffList;	
	
	public Staff() {
		staffList = new HashMap<String, StaffMember>();
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
	
	public StaffMember getStaffMemberWithName(String name){
		for(String key : staffList.keySet()){
			if (getStaffMemberWithPin(key).getName().equals(name))
				return getStaffMemberWithPin(key);
		}
		return null;
	}
	
}
