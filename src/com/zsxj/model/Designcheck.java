package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Designcheck extends DataModel{ 
	public int dc_id; 
	public String dc_Date; 
	public String dc_Project; 
	public String dc_Content; 
	public String users_ID; 
 
	public Designcheck(int dC_id) { 
		super(); 
		this.dc_id = dC_id; 
	} 
 
	public Designcheck() { 
		super(); 
	}

	public int getDc_id() {
		return dc_id;
	}

	public void setDc_id(int dc_id) {
		this.dc_id = dc_id;
	}

	public String getDc_Date() {
		return dc_Date;
	}

	public void setDc_Date(String dc_Date) {
		this.dc_Date = dc_Date;
	}

	public String getDc_Project() {
		return dc_Project;
	}

	public void setDc_Project(String dc_Project) {
		this.dc_Project = dc_Project;
	}

	public String getDc_Content() {
		return dc_Content;
	}

	public void setDc_Content(String dc_Content) {
		this.dc_Content = dc_Content;
	}

	public String getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(String users_ID) {
		this.users_ID = users_ID;
	} 
 
	
 
	
 
 
} 
