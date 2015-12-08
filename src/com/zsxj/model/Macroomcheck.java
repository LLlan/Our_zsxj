package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Macroomcheck extends DataModel{ 
	public int mrc_ID; 
	public String mrc_Address; 
	public String users_ID; 
	public String pic_Name;
 
	public Macroomcheck(int mrc_ID) { 
		super(); 
		this.mrc_ID = mrc_ID; 
	} 
 
	public Macroomcheck() { 
		super(); 
	}

	public int getMrc_ID() {
		return mrc_ID;
	}

	public void setMrc_ID(int mrc_ID) {
		this.mrc_ID = mrc_ID;
	}

	public String getMrc_Address() {
		return mrc_Address;
	}

	public void setMrc_Address(String mrc_Address) {
		this.mrc_Address = mrc_Address;
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
