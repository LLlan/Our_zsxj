package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Supervisorcheck; 
 
public class SupervisorcheckConvert implements ResultConverter<Supervisorcheck>{ 
 
	@Override 
	public Supervisorcheck convert(ResultSet rs) throws SQLException { 
		Supervisorcheck supervisorcheck = new Supervisorcheck(rs.getInt(1)); 
		supervisorcheck.sc_Address = rs.getString(2); 
		supervisorcheck.sc_ProjectName = rs.getString(3); 
		supervisorcheck.sc_ProjectDesc = rs.getString(4); 
		supervisorcheck.users_ID = rs.getString(5); 
		supervisorcheck.pic_Name = rs.getString(6);
		 
		return supervisorcheck; 
	} 
 
} 
