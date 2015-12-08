package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Baseusers extends DataModel{ 
	public int users_ID; 
	public String users_UserName; 
	public String users_Password; 
	public String users_Mobile; 
	public String users_Phone; 
	public String users_Email; 
	public String users_TrueName; 
	public int users_IsLock; 
	public String users_LastLoginTime; 
	public String users_LastLoginIP; 
	public int branch_ID; 
	public int role_ID; 
 
	public Baseusers(int users_ID) { 
		super(); 
		this.users_ID = users_ID; 
	} 
 
	public Baseusers() { 
		super(); 
	} 
 
	public int getUsers_ID() { 
		return users_ID; 
	} 
 
	public void setUsers_ID(int users_ID) { 
		this.users_ID = users_ID; 
	} 
 
	public String getUsers_UserName() { 
		return users_UserName; 
	} 
 
	public void setUsers_UserName(String users_UserName) { 
		this.users_UserName = users_UserName; 
	} 
 
	public String getUsers_Password() { 
		return users_Password; 
	} 
 
	public void setUsers_Password(String users_Password) { 
		this.users_Password = users_Password; 
	} 
 
	public String getUsers_Mobile() { 
		return users_Mobile; 
	} 
 
	public void setUsers_Mobile(String users_Mobile) { 
		this.users_Mobile = users_Mobile; 
	} 
 
	public String getUsers_Phone() { 
		return users_Phone; 
	} 
 
	public void setUsers_Phone(String users_Phone) { 
		this.users_Phone = users_Phone; 
	} 
 
	public String getUsers_Email() { 
		return users_Email; 
	} 
 
	public void setUsers_Email(String users_Email) { 
		this.users_Email = users_Email; 
	} 
 
	public String getUsers_TrueName() { 
		return users_TrueName; 
	} 
 
	public void setUsers_TrueName(String users_TrueName) { 
		this.users_TrueName = users_TrueName; 
	} 
 
	public int getUsers_IsLock() { 
		return users_IsLock; 
	} 
 
	public void setUsers_IsLock(int users_IsLock) { 
		this.users_IsLock = users_IsLock; 
	} 
 
	public String getUsers_LastLoginTime() { 
		return users_LastLoginTime; 
	} 
 
	public void setUsers_LastLoginTime(String users_LastLoginTime) { 
		this.users_LastLoginTime = users_LastLoginTime; 
	} 
 
	public String getUsers_LastLoginIP() { 
		return users_LastLoginIP; 
	} 
 
	public void setUsers_LastLoginIP(String users_LastLoginIP) { 
		this.users_LastLoginIP = users_LastLoginIP; 
	} 
 
	public int getBranch_ID() { 
		return branch_ID; 
	} 
 
	public void setBranch_ID(int branch_ID) { 
		this.branch_ID = branch_ID; 
	} 
 
	public int getRole_ID() { 
		return role_ID; 
	} 
 
	public void setRole_ID(int role_ID) { 
		this.role_ID = role_ID; 
	} 
 
 
} 
