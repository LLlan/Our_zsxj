package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Hindercheck extends DataModel{ 
	public int hc_ID; 
	public String hc_Address; 
	public String hc_Desc; 
	public String hc_Process; 
	public String hc_ProcessUserID;
	
	public Hindercheck() {
		super();
	}
	
	public Hindercheck(int hc_ID) {
		super();
		this.hc_ID = hc_ID;
	}
	
	public int getHc_ID() {
		return hc_ID;
	}
	public void setHc_ID(int hc_ID) {
		this.hc_ID = hc_ID;
	}
	public String getHc_Address() {
		return hc_Address;
	}
	public void setHc_Address(String hc_Address) {
		this.hc_Address = hc_Address;
	}
	public String getHc_Desc() {
		return hc_Desc;
	}
	public void setHc_Desc(String hc_Desc) {
		this.hc_Desc = hc_Desc;
	}
	public String getHc_Process() {
		return hc_Process;
	}
	public void setHc_Process(String hc_Process) {
		this.hc_Process = hc_Process;
	}

	public String getHc_ProcessUserID() {
		return hc_ProcessUserID;
	}

	public void setHc_ProcessUserID(String hc_ProcessUserID) {
		this.hc_ProcessUserID = hc_ProcessUserID;
	}
	
	
 
	
 
 
} 
