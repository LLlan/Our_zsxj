package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Baseusersrole extends DataModel{ 
	public int role_ID; 
	public String role_Name; 
	public int role_OrderBy; 
 
	public Baseusersrole(int role_ID) { 
		super(); 
		this.role_ID = role_ID; 
	} 
 
	public Baseusersrole() { 
		super(); 
	} 
 
	public int getRole_ID() { 
		return role_ID; 
	} 
 
	public void setRole_ID(int role_ID) { 
		this.role_ID = role_ID; 
	} 
 
	public String getRole_Name() { 
		return role_Name; 
	} 
 
	public void setRole_Name(String role_Name) { 
		this.role_Name = role_Name; 
	} 
 
	public int getRole_OrderBy() { 
		return role_OrderBy; 
	} 
 
	public void setRole_OrderBy(int role_OrderBy) { 
		this.role_OrderBy = role_OrderBy; 
	} 
 
 
} 
