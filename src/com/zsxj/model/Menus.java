package com.zsxj.model;

import com.zsxj.common.database.DataModel;

public class Menus extends DataModel {
	public int menus_ID;
	public String menus_Title;
	public String menus_Url;

	public int menus_PID;

	public String menus_Code;

	public String menus_Icon;

	public int menus_OrderBy;

	public Menus(int menus_ID) {
		super();
		this.menus_ID = menus_ID;
	}

	public Menus() {
		super();
	}

	public int getMenus_ID() {
		return menus_ID;
	}

	public void setMenus_ID(int menus_ID) {
		this.menus_ID = menus_ID;
	}

	public String getMenus_Title() {
		return menus_Title;
	}

	public void setMenus_Title(String menus_Title) {
		this.menus_Title = menus_Title;
	}

	public String getMenus_Url() {
		return menus_Url;
	}

	public void setMenus_Url(String menus_Url) {
		this.menus_Url = menus_Url;
	}

	public int getMenus_PID() {
		return menus_PID;
	}

	public void setMenus_PID(int menus_PID) {
		this.menus_PID = menus_PID;
	}

	public String getMenus_Code() {
		return menus_Code;
	}

	public void setMenus_Code(String menus_Code) {
		this.menus_Code = menus_Code;
	}

	public String getMenus_Icon() {
		return menus_Icon;
	}

	public void setMenus_Icon(String menus_Icon) {
		this.menus_Icon = menus_Icon;
	}

	public int getMenus_OrderBy() {
		return menus_OrderBy;
	}

	public void setMenus_OrderBy(int menus_OrderBy) {
		this.menus_OrderBy = menus_OrderBy;
	}
	
	
}
