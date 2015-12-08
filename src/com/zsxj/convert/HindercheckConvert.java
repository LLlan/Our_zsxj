package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Hindercheck; 
 
public class HindercheckConvert implements ResultConverter<Hindercheck>{ 
 
	@Override 
	public Hindercheck convert(ResultSet rs) throws SQLException { 
		Hindercheck hindercheck = new Hindercheck(rs.getInt(1)); 
		hindercheck.hc_Address = rs.getString(2); 
		hindercheck.hc_Desc = rs.getString(3); 
		hindercheck.hc_Process = rs.getString(4); 
		hindercheck.hc_ProcessUserID = rs.getString(5); 
		 
		return hindercheck; 
	} 
 
} 
