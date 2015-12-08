package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Macroomcheck; 
 
public class MacroomcheckConvert implements ResultConverter<Macroomcheck>{ 
 
	@Override 
	public Macroomcheck convert(ResultSet rs) throws SQLException { 
		Macroomcheck macroomcheck = new Macroomcheck(rs.getInt(1)); 
		macroomcheck.mrc_Address = rs.getString(2); 
		macroomcheck.users_ID = rs.getString(3); 
		macroomcheck.pic_Name = rs.getString(4);
		 
		return macroomcheck; 
	} 
 
} 
