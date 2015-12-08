package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Basemodule; 
 
public class BasemoduleConvert implements ResultConverter<Basemodule>{ 
 
	@Override 
	public Basemodule convert(ResultSet rs) throws SQLException { 
		Basemodule basemodule = new Basemodule(rs.getInt(1)); 
		basemodule.module_Name = rs.getString(2); 
		basemodule.module_Code = rs.getString(3); 
		basemodule.module_OrderBy = rs.getInt(4); 
		 
		return basemodule; 
	} 
 
} 
