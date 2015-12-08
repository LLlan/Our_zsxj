package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Baseusersbranch extends DataModel{ 
	public int branch_ID; 
	public String branch_Name; 
	public int branch_PID; 
	public String branch_Code; 
	public int branch_OrderBy; 
 
	public Baseusersbranch(int branch_ID) { 
		super(); 
		this.branch_ID = branch_ID; 
	} 
 
	public Baseusersbranch() { 
		super(); 
	} 
 
	public int getBranch_ID() { 
		return branch_ID; 
	} 
 
	public void setBranch_ID(int branch_ID) { 
		this.branch_ID = branch_ID; 
	} 
 
	public String getBranch_Name() { 
		return branch_Name; 
	} 
 
	public void setBranch_Name(String branch_Name) { 
		this.branch_Name = branch_Name; 
	} 
 
	public int getBranch_PID() { 
		return branch_PID; 
	} 
 
	public void setBranch_PID(int branch_PID) { 
		this.branch_PID = branch_PID; 
	} 
 
	public String getBranch_Code() { 
		return branch_Code; 
	} 
 
	public void setBranch_Code(String branch_Code) { 
		this.branch_Code = branch_Code; 
	} 
 
	public int getBranch_OrderBy() { 
		return branch_OrderBy; 
	} 
 
	public void setBranch_OrderBy(int branch_OrderBy) { 
		this.branch_OrderBy = branch_OrderBy; 
	} 
 
 
} 
