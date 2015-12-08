package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Baserolemenus; 
 
public class BaserolemenusConvert implements ResultConverter<Baserolemenus>{ 
 
	@Override 
	public Baserolemenus convert(ResultSet rs) throws SQLException { 
		Baserolemenus baserolemenus = new Baserolemenus(rs.getInt(1)); 
		baserolemenus.role_ID = rs.getInt(2); 
		baserolemenus.menus_ID = rs.getInt(3); 
		baserolemenus.module_ID = rs.getInt(4); 
		 
		return baserolemenus; 
	} 
 
} 
