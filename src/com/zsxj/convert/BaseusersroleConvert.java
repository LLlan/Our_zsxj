package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Baseusersrole; 
 
public class BaseusersroleConvert implements ResultConverter<Baseusersrole>{ 
 
	@Override 
	public Baseusersrole convert(ResultSet rs) throws SQLException { 
		Baseusersrole baseusersrole = new Baseusersrole(rs.getInt(1)); 
		baseusersrole.role_Name = rs.getString(2); 
		baseusersrole.role_OrderBy = rs.getInt(3); 
		 
		return baseusersrole; 
	} 
 
} 
