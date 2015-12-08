package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Basemodule extends DataModel{ 
	public int module_ID; 
	public String module_Name; 
	public String module_Code; 
	public int module_OrderBy; 
 
	public Basemodule(int module_ID) { 
		super(); 
		this.module_ID = module_ID; 
	} 
 
	public Basemodule() { 
		super(); 
	} 
 
	public int getModule_ID() { 
		return module_ID; 
	} 
 
	public void setModule_ID(int module_ID) { 
		this.module_ID = module_ID; 
	} 
 
	public String getModule_Name() { 
		return module_Name; 
	} 
 
	public void setModule_Name(String module_Name) { 
		this.module_Name = module_Name; 
	} 
 
	public String getModule_Code() { 
		return module_Code; 
	} 
 
	public void setModule_Code(String module_Code) { 
		this.module_Code = module_Code; 
	} 
 
	public int getModule_OrderBy() { 
		return module_OrderBy; 
	} 
 
	public void setModule_OrderBy(int module_OrderBy) { 
		this.module_OrderBy = module_OrderBy; 
	} 
 
 
} 
