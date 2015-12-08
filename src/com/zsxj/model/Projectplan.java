package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Projectplan extends DataModel{ 
	public int pp_ID; 
	public String pp_ProjectName; 
	public String pp_ProjectNo; 
	public String pp_ExecComName; 
	public String pp_Content; 
	public String pp_BOMList; 
	public String pp_StartDate; 
	public String pp_EndDate; 
	public int users_ID; 
 
	public Projectplan(int pP_ID) { 
		super(); 
		this.pp_ID = pP_ID; 
	} 
 
	public Projectplan() { 
		super(); 
	}

	public int getPp_ID() {
		return pp_ID;
	}

	public void setPp_ID(int pp_ID) {
		this.pp_ID = pp_ID;
	}

	public String getPp_ProjectName() {
		return pp_ProjectName;
	}

	public void setPp_ProjectName(String pp_ProjectName) {
		this.pp_ProjectName = pp_ProjectName;
	}

	public String getPp_ProjectNo() {
		return pp_ProjectNo;
	}

	public void setPp_ProjectNo(String pp_ProjectNo) {
		this.pp_ProjectNo = pp_ProjectNo;
	}

	public String getPp_ExecComName() {
		return pp_ExecComName;
	}

	public void setPp_ExecComName(String pp_ExecComName) {
		this.pp_ExecComName = pp_ExecComName;
	}

	public String getPp_Content() {
		return pp_Content;
	}

	public void setPp_Content(String pp_Content) {
		this.pp_Content = pp_Content;
	}

	public String getPp_BOMList() {
		return pp_BOMList;
	}

	public void setPp_BOMList(String pp_BOMList) {
		this.pp_BOMList = pp_BOMList;
	}

	public String getPp_StartDate() {
		return pp_StartDate;
	}

	public void setPp_StartDate(String pp_StartDate) {
		this.pp_StartDate = pp_StartDate;
	}

	public String getPp_EndDate() {
		return pp_EndDate;
	}

	public void setPp_EndDate(String pp_EndDate) {
		this.pp_EndDate = pp_EndDate;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	} 
 
	
 
} 
