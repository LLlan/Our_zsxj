package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Baseuserslog; 
 
public class BaseuserslogConvert implements ResultConverter<Baseuserslog>{ 
 
	@Override 
	public Baseuserslog convert(ResultSet rs) throws SQLException { 
		Baseuserslog baseuserslog = new Baseuserslog(rs.getInt(1)); 
		baseuserslog.log_Url = rs.getString(2); 
		baseuserslog.log_Date = rs.getString(3); 
		baseuserslog.log_IP = rs.getString(4); 
		baseuserslog.users_ID = rs.getInt(5); 
		baseuserslog.log_Type = rs.getString(6); 
		baseuserslog.log_Desc = rs.getString(7); 
		 
		return baseuserslog; 
	} 
 
} 
