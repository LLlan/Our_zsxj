package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Baseuserslog extends DataModel{ 
	public int log_ID; 
	public String log_Url; 
	public String log_Date; 
	public String log_IP; 
	public int users_ID; 
	public String log_Type; 
	public String log_Desc; 
 
	public Baseuserslog(int log_ID) { 
		super(); 
		this.log_ID = log_ID; 
	} 
 
	public Baseuserslog() { 
		super(); 
	} 
 
	public int getLog_ID() { 
		return log_ID; 
	} 
 
	public void setLog_ID(int log_ID) { 
		this.log_ID = log_ID; 
	} 
 
	public String getLog_Url() { 
		return log_Url; 
	} 
 
	public void setLog_Url(String log_Url) { 
		this.log_Url = log_Url; 
	} 
 
	public String getLog_Date() { 
		return log_Date; 
	} 
 
	public void setLog_Date(String log_Date) { 
		this.log_Date = log_Date; 
	} 
 
	public String getLog_IP() { 
		return log_IP; 
	} 
 
	public void setLog_IP(String log_IP) { 
		this.log_IP = log_IP; 
	} 
 
	public int getUsers_ID() { 
		return users_ID; 
	} 
 
	public void setUsers_ID(int users_ID) { 
		this.users_ID = users_ID; 
	} 
 
	public String getLog_Type() { 
		return log_Type; 
	} 
 
	public void setLog_Type(String log_Type) { 
		this.log_Type = log_Type; 
	} 
 
	public String getLog_Desc() { 
		return log_Desc; 
	} 
 
	public void setLog_Desc(String log_Desc) { 
		this.log_Desc = log_Desc; 
	} 
 
 
} 
