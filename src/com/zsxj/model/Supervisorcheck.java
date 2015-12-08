package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Supervisorcheck extends DataModel{ 
	public int sc_ID; 
	public String sc_Address; 
	public String sc_ProjectName; 
	public String sc_ProjectDesc; 
	public String users_ID; 
	public String pic_Name;
 
	public Supervisorcheck(int sC_ID) { 
		super(); 
		this.sc_ID = sC_ID; 
	} 
 
	public Supervisorcheck() { 
		super(); 
	}

	public int getSc_ID() {
		return sc_ID;
	}

	public void setSc_ID(int sc_ID) {
		this.sc_ID = sc_ID;
	}

	public String getSc_Address() {
		return sc_Address;
	}

	public void setSc_Address(String sc_Address) {
		this.sc_Address = sc_Address;
	}

	public String getSc_ProjectName() {
		return sc_ProjectName;
	}

	public void setSc_ProjectName(String sc_ProjectName) {
		this.sc_ProjectName = sc_ProjectName;
	}

	public String getSc_ProjectDesc() {
		return sc_ProjectDesc;
	}

	public void setSc_ProjectDesc(String sc_ProjectDesc) {
		this.sc_ProjectDesc = sc_ProjectDesc;
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
