package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Baseusersbranch; 
 
public class BaseusersbranchConvert implements ResultConverter<Baseusersbranch>{ 
 
	@Override 
	public Baseusersbranch convert(ResultSet rs) throws SQLException { 
		Baseusersbranch baseusersbranch = new Baseusersbranch(rs.getInt(1)); 
		baseusersbranch.branch_Name = rs.getString(2); 
		baseusersbranch.branch_PID = rs.getInt(3); 
		baseusersbranch.branch_Code = rs.getString(4); 
		baseusersbranch.branch_OrderBy = rs.getInt(5); 
		 
		return baseusersbranch; 
	} 
 
} 
