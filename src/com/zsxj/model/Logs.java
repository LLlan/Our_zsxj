package com.zsxj.model;

import java.util.Date;

public class Logs {
	public int Log_ID;
	public String Log_Url;
	public Date Log_Date;
	public String Log_IP;
	public int Users_ID;
	public String Log_Type;
	public String Log_Desc;
	
	
	
	
	
	
	public Logs() {
		super();
	}
	
	
	public Logs(int log_ID) {
		super();
		Log_ID = log_ID;
	}


	public int getLog_ID() {
		return Log_ID;
	}
	public void setLog_ID(int log_ID) {
		Log_ID = log_ID;
	}
	public String getLog_Url() {
		return Log_Url;
	}
	public void setLog_Url(String log_Url) {
		Log_Url = log_Url;
	}
	public Date getLog_Date() {
		return Log_Date;
	}
	public void setLog_Date(Date log_Date) {
		Log_Date = log_Date;
	}
	public String getLog_IP() {
		return Log_IP;
	}
	public void setLog_IP(String log_IP) {
		Log_IP = log_IP;
	}
	public int getUsers_ID() {
		return Users_ID;
	}
	public void setUsers_ID(int users_ID) {
		Users_ID = users_ID;
	}
	public String getLog_Type() {
		return Log_Type;
	}
	public void setLog_Type(String log_Type) {
		Log_Type = log_Type;
	}
	public String getLog_Desc() {
		return Log_Desc;
	}
	public void setLog_Desc(String log_Desc) {
		Log_Desc = log_Desc;
	}

	
}
