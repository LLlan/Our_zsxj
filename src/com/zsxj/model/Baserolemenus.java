package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Baserolemenus extends DataModel{ 
	
	public int rm_ID; 
	public int role_ID; 
	public int menus_ID; 
	public int module_ID; 
 
	public Baserolemenus(int rM_ID) { 
		super(); 
		this.rm_ID = rm_ID;
	} 
 
	public Baserolemenus() { 
		super(); 
	} 
 
	public int getRm_ID() {
		return rm_ID;
	}

	public void setRm_ID(int rm_ID) {
		this.rm_ID = rm_ID;
	}

	public int getRole_ID() { 
		return role_ID; 
	} 
 
	public void setRole_ID(int role_ID){ 
		this.role_ID = role_ID; 
	} 
 
	public int getMenus_ID() { 
		return menus_ID; 
	} 
 
	public void setMenus_ID(int menus_ID) { 
		this.menus_ID = menus_ID; 
	} 
 
	public int getModule_ID() { 
		return module_ID; 
	} 
 
	public void setModule_ID(int module_ID) { 
		this.module_ID = module_ID; 
	} 
 
 
} 
