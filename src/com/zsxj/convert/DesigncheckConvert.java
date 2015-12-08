package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Designcheck; 
 
public class DesigncheckConvert implements ResultConverter<Designcheck>{ 
 
	@Override 
	public Designcheck convert(ResultSet rs) throws SQLException { 
		Designcheck designcheck = new Designcheck(rs.getInt(1)); 
		designcheck.dc_Date = rs.getString(2); 
		designcheck.dc_Project = rs.getString(3); 
		designcheck.dc_Content = rs.getString(4); 
		designcheck.users_ID = rs.getString(5); 
		 
		return designcheck; 
	} 
 
} 
