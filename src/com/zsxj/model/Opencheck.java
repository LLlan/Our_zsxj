package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Opencheck extends DataModel{ 
	public int oc_ID; 
	public String oc_ProjectNO; 
	public String oc_ENO; 
	public String oc_BusinessType; 
	public String oc_CustInfo; 
	public String users_ID; 
 
	public Opencheck(int oC_ID) { 
		super(); 
		this.oc_ID = oC_ID; 
	} 
 
	public Opencheck() { 
		super(); 
	}

	public int getOc_ID() {
		return oc_ID;
	}

	public void setOc_ID(int oc_ID) {
		this.oc_ID = oc_ID;
	}

	public String getOc_ProjectNO() {
		return oc_ProjectNO;
	}

	public void setOc_ProjectNO(String oc_ProjectNO) {
		this.oc_ProjectNO = oc_ProjectNO;
	}

	public String getOc_ENO() {
		return oc_ENO;
	}

	public void setOc_ENO(String oc_ENO) {
		this.oc_ENO = oc_ENO;
	}

	public String getOc_BusinessType() {
		return oc_BusinessType;
	}

	public void setOc_BusinessType(String oc_BusinessType) {
		this.oc_BusinessType = oc_BusinessType;
	}

	public String getOc_CustInfo() {
		return oc_CustInfo;
	}

	public void setOc_CustInfo(String oc_CustInfo) {
		this.oc_CustInfo = oc_CustInfo;
	}

	public String getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(String users_ID) {
		this.users_ID = users_ID;
	}

	
	
 
 
} 
