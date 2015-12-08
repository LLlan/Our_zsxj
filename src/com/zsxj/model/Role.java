package com.zsxj.model;

public class Role {
public int Role_ID;
public String  Role_Name;
public int Role_OrderBy;

public Role(int role_ID) {
	super();
	Role_ID = role_ID;
}
public Role() {
	super();
}
public int getRole_ID() {
	return Role_ID;
}
public void setRole_ID(int role_ID) {
	Role_ID = role_ID;
}
public String getRole_Name() {
	return Role_Name;
}
public void setRole_Name(String role_Name) {
	Role_Name = role_Name;
}
public int getRole_OrderBy() {
	return Role_OrderBy;
}
public void setRole_OrderBy(int role_OrderBy) {
	Role_OrderBy = role_OrderBy;
}


}
