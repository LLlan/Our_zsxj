package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Wrokplanexec extends DataModel{ 
	public int wpe_ID; 
	public String wpe_Date; 
	public String wpe_RealAddress; 
	public String wpe_RealContent; 
	public int users_ID; 
	public int wp_ID; 
 
	public Wrokplanexec(int wPE_ID) { 
		super(); 
		this.wpe_ID = wPE_ID; 
	} 
 
	public Wrokplanexec() { 
		super(); 
	}

	public int getWpe_ID() {
		return wpe_ID;
	}

	public void setWpe_ID(int wpe_ID) {
		this.wpe_ID = wpe_ID;
	}

	public String getWpe_Date() {
		return wpe_Date;
	}

	public void setWpe_Date(String wpe_Date) {
		this.wpe_Date = wpe_Date;
	}

	public String getWpe_RealAddress() {
		return wpe_RealAddress;
	}

	public void setWpe_RealAddress(String wpe_RealAddress) {
		this.wpe_RealAddress = wpe_RealAddress;
	}

	public String getWpe_RealContent() {
		return wpe_RealContent;
	}

	public void setWpe_RealContent(String wpe_RealContent) {
		this.wpe_RealContent = wpe_RealContent;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	}

	public int getWp_ID() {
		return wp_ID;
	}

	public void setWp_ID(int wp_ID) {
		this.wp_ID = wp_ID;
	} 
 
	
 
 
} 
