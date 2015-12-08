package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Basemenusmodule; 
 
public class BasemenusmoduleConvert implements ResultConverter<Basemenusmodule>{ 
 
	@Override 
	public Basemenusmodule convert(ResultSet rs) throws SQLException { 
		Basemenusmodule basemenusmodule = new Basemenusmodule(rs.getInt(1)); 
		basemenusmodule.menus_ID = rs.getInt(2); 
		basemenusmodule.module_ID = rs.getInt(3); 
		 
		return basemenusmodule; 
	} 
 
} 
