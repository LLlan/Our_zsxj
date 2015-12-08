package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Worklist extends DataModel{ 
	public int wl_ID; 
	public String wl_NO; 
	public String wl_Title; 
	public String wl_Content; 
	public String wl_UsersIDs; 
	public String wl_StartTime; 
	public String wl_EndTime; 
	public int users_ID; 
 
	public Worklist(int wL_ID) { 
		super(); 
		this.wl_ID = wL_ID; 
	} 
 
	public Worklist() { 
		super(); 
	} 
 
	public int getWL_ID() { 
		return wl_ID; 
	} 
 
	public void setWL_ID(int wL_ID) { 
		this.wl_ID = wL_ID; 
	} 
 
	public String getWL_NO() { 
		return wl_NO; 
	} 
 
	public void setWL_NO(String wL_NO) { 
		this.wl_NO = wL_NO; 
	} 
 
	public String getWL_Title() { 
		return wl_Title; 
	} 
 
	public void setWL_Title(String wL_Title) { 
		this.wl_Title = wL_Title; 
	} 
 
	public String getWL_Content() { 
		return wl_Content; 
	} 
 
	public void setWL_Content(String wL_Content) { 
		this.wl_Content = wL_Content; 
	} 
 
	public String getWL_UsersIDs() { 
		return wl_UsersIDs; 
	} 
 
	public void setWL_UsersIDs(String wL_UsersIDs) { 
		this.wl_UsersIDs = wL_UsersIDs; 
	} 
 
	public String getWL_StartTime() { 
		return wl_StartTime; 
	} 
 
	public void setWL_StartTime(String wL_StartTime) { 
		this.wl_StartTime = wL_StartTime; 
	} 
 
	public String getWL_EndTime() { 
		return wl_EndTime; 
	} 
 
	public void setWL_EndTime(String wL_EndTime) { 
		this.wl_EndTime = wL_EndTime; 
	} 
 
	public int getUsers_ID() { 
		return users_ID; 
	} 
 
	public void setUsers_ID(int users_ID) { 
		this.users_ID = users_ID; 
	} 
 
 
} 
