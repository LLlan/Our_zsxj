package com.zsxj.model;

public class Rolemenus {
	public int RM_ID;
	public int Role_ID;

	public int Menus_ID;

	public int Module_ID;
	
	

	public Rolemenus(int rM_ID) {
		super();
		RM_ID = rM_ID;
	}

	public Rolemenus() {
		super();
	}

	public int getRM_ID() {
		return RM_ID;
	}

	public void setRM_ID(int rM_ID) {
		RM_ID = rM_ID;
	}

	public int getRole_ID() {
		return Role_ID;
	}

	public void setRole_ID(int role_ID) {
		Role_ID = role_ID;
	}

	public int getMenus_ID() {
		return Menus_ID;
	}

	public void setMenus_ID(int menus_ID) {
		Menus_ID = menus_ID;
	}

	public int getModule_ID() {
		return Module_ID;
	}

	public void setModule_ID(int module_ID) {
		Module_ID = module_ID;
	}

}
