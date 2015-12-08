package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Adormcheck extends DataModel{ 
	public int ac_ID; 
	public String ac_CusName; 
	public String ac_Address; 
	public String ac_AccountNum; 
	public String ac_HealthData; 
	public String users_ID; 
	public String pic_Name; 
 
	public Adormcheck(int aC_ID) { 
		super(); 
		this.ac_ID = aC_ID; 
	} 
 
	public Adormcheck() { 
		super(); 
	}

	public int getAc_ID() {
		return ac_ID;
	}

	public void setAc_ID(int ac_ID) {
		this.ac_ID = ac_ID;
	}

	public String getAc_CusName() {
		return ac_CusName;
	}

	public void setAc_CusName(String ac_CusName) {
		this.ac_CusName = ac_CusName;
	}

	public String getAc_Address() {
		return ac_Address;
	}

	public void setAc_Address(String ac_Address) {
		this.ac_Address = ac_Address;
	}

	public String getAc_AccountNum() {
		return ac_AccountNum;
	}

	public void setAc_AccountNum(String ac_AccountNum) {
		this.ac_AccountNum = ac_AccountNum;
	}

	public String getAc_HealthData() {
		return ac_HealthData;
	}

	public void setAc_HealthData(String ac_HealthData) {
		this.ac_HealthData = ac_HealthData;
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
