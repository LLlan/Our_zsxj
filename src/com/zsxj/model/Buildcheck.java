package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Buildcheck extends DataModel{ 
	public int bc_ID; 
	public String bc_Address; 
	public String bc_Project; 
	public String bc_ProjectDesc; 
	public String users_ID; 
	public String pic_Name; 
 
	public Buildcheck(int bC_ID) { 
		super(); 
		this.bc_ID = bC_ID; 
	} 
 
	public Buildcheck() { 
		super(); 
	} 
 
	
	public int getBc_ID() {
		return bc_ID;
	}

	public void setBc_ID(int bc_ID) {
		this.bc_ID = bc_ID;
	}

	public String getBc_Address() {
		return bc_Address;
	}

	public void setBc_Address(String bc_Address) {
		this.bc_Address = bc_Address;
	}

	public String getBc_Project() {
		return bc_Project;
	}

	public void setBc_Project(String bc_Project) {
		this.bc_Project = bc_Project;
	}

	public String getBc_ProjectDesc() {
		return bc_ProjectDesc;
	}

	public void setBc_ProjectDesc(String bc_ProjectDesc) {
		this.bc_ProjectDesc = bc_ProjectDesc;
	}

	public String getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(String users_ID) {
		this.users_ID = users_ID;
	}

	public String getPic_Name() {
		return pic_Name;
	}

	public void setPic_Name(String pic_Name) {
		this.pic_Name = pic_Name;
	} 
	
	
 
 
} 
