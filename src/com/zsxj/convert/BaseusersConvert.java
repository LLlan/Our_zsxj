package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Baseusers; 
 
public class BaseusersConvert implements ResultConverter<Baseusers>{ 
 
	@Override 
	public Baseusers convert(ResultSet rs) throws SQLException { 
		Baseusers baseusers = new Baseusers(rs.getInt(1)); 
		baseusers.users_UserName = rs.getString(2); 
		baseusers.users_Password = rs.getString(3); 
		baseusers.users_Mobile = rs.getString(4); 
		baseusers.users_Phone = rs.getString(5); 
		baseusers.users_Email = rs.getString(6); 
		baseusers.users_TrueName = rs.getString(7); 
		baseusers.users_IsLock = rs.getInt(8); 
		baseusers.users_LastLoginTime = rs.getString(9); 
		baseusers.users_LastLoginIP = rs.getString(10); 
		baseusers.branch_ID = rs.getInt(11); 
		baseusers.role_ID = rs.getInt(12); 
		 
		return baseusers; 
	} 
 
} 
