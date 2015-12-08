package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Workplan extends DataModel{ 
	public int wp_ID; 
	public int wp_IsTemp; 
	public String wp_Date; 
	public String wp_Address; 
	public String wp_Content; 
	public int users_ID; 
 
	
 
	public Workplan(int wp_ID) {
		super();
		this.wp_ID = wp_ID;
	}

	public Workplan() { 
		super(); 
	} 
 
	public int getWp_ID() {
		return wp_ID;
	}

	public int getWp_IsTemp() {
		return wp_IsTemp;
	}

	public void setWp_IsTemp(int wp_IsTemp) {
		this.wp_IsTemp = wp_IsTemp;
	}

	public String getWp_Date() {
		return wp_Date;
	}

	public void setWp_Date(String wp_Date) {
		this.wp_Date = wp_Date;
	}

	public String getWp_Address() {
		return wp_Address;
	}

	public void setWp_Address(String wp_Address) {
		this.wp_Address = wp_Address;
	}

	public String getWp_Content() {
		return wp_Content;
	}

	public void setWp_Content(String wp_Content) {
		this.wp_Content = wp_Content;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	}

	public void setWp_ID(int wp_ID) {
		this.wp_ID = wp_ID;
	}

	
 
} 
