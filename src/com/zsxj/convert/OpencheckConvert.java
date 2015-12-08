package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Opencheck; 
 
public class OpencheckConvert implements ResultConverter<Opencheck>{ 
 
	@Override 
	public Opencheck convert(ResultSet rs) throws SQLException { 
		Opencheck opencheck = new Opencheck(rs.getInt(1)); 
		opencheck.oc_ProjectNO = rs.getString(2); 
		opencheck.oc_ENO = rs.getString(3); 
		opencheck.oc_BusinessType = rs.getString(4); 
		opencheck.oc_CustInfo = rs.getString(5); 
		opencheck.users_ID = rs.getString(6); 
		 
		return opencheck; 
	} 
 
} 
