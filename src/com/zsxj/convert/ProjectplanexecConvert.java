package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Projectplanexec; 
 
public class ProjectplanexecConvert implements ResultConverter<Projectplanexec>{ 
 
	@Override 
	public Projectplanexec convert(ResultSet rs) throws SQLException { 
		Projectplanexec projectplanexec = new Projectplanexec(rs.getInt(1)); 
		projectplanexec.ppe_Date = rs.getString(2); 
		projectplanexec.ppe_RealAddress = rs.getString(3); 
		projectplanexec.ppe_RealContent = rs.getString(4); 
		projectplanexec.pp_ID = rs.getInt(5); 
		projectplanexec.users_ID = rs.getInt(6); 
		 
		return projectplanexec; 
	} 
 
} 
