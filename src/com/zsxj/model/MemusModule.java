package com.zsxj.model;

public class MemusModule {
public int memusModule_ID;
public int menus_ID;
public int module_ID;


public MemusModule(int memusModule_ID) {
	super();
	this.memusModule_ID = memusModule_ID;
}
public MemusModule() {
	super();
}
public int getMemusModule_ID() {
	return memusModule_ID;
}
public void setMemusModule_ID(int memusModule_ID) {
	this.memusModule_ID = memusModule_ID;
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
