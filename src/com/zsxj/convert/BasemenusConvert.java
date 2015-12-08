package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Basemenus; 
 
public class BasemenusConvert implements ResultConverter<Basemenus>{ 
 
	@Override 
	public Basemenus convert(ResultSet rs) throws SQLException { 
		Basemenus basemenus = new Basemenus(rs.getInt(1)); 
		basemenus.menus_Title = rs.getString(2); 
		basemenus.menus_Url = rs.getString(3); 
		basemenus.menus_PID = rs.getInt(4); 
		basemenus.menus_Code = rs.getString(5); 
		basemenus.menus_Icon = rs.getString(6); 
		basemenus.menus_OrderBy = rs.getInt(7); 
		 
		return basemenus; 
	} 
 
} 
