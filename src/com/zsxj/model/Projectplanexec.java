package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Projectplanexec extends DataModel{ 
	public int ppe_ID; 
	public String ppe_Date; 
	public String ppe_RealAddress; 
	public String ppe_RealContent; 
	public int pp_ID; 
	public int users_ID; 
 
	public Projectplanexec(int pPE_ID) { 
		super(); 
		this.ppe_ID = pPE_ID; 
	} 
 
	public Projectplanexec() { 
		super(); 
	}

	public int getPpe_ID() {
		return ppe_ID;
	}

	public void setPpe_ID(int ppe_ID) {
		this.ppe_ID = ppe_ID;
	}

	public String getPpe_Date() {
		return ppe_Date;
	}

	public void setPpe_Date(String ppe_Date) {
		this.ppe_Date = ppe_Date;
	}

	public String getPpe_RealAddress() {
		return ppe_RealAddress;
	}

	public void setPpe_RealAddress(String ppe_RealAddress) {
		this.ppe_RealAddress = ppe_RealAddress;
	}

	public String getPpe_RealContent() {
		return ppe_RealContent;
	}

	public void setPpe_RealContent(String ppe_RealContent) {
		this.ppe_RealContent = ppe_RealContent;
	}

	public int getPp_ID() {
		return pp_ID;
	}

	public void setPp_ID(int pp_ID) {
		this.pp_ID = pp_ID;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	} 
 
	
 
 
} 
