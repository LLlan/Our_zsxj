package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Wrokplanexec; 
 
public class WrokplanexecConvert implements ResultConverter<Wrokplanexec>{ 
 
	@Override 
	public Wrokplanexec convert(ResultSet rs) throws SQLException { 
		Wrokplanexec wrokplanexec = new Wrokplanexec(rs.getInt(1)); 
		wrokplanexec.wpe_Date = rs.getString(2); 
		wrokplanexec.wpe_RealAddress = rs.getString(3); 
		wrokplanexec.wpe_RealContent = rs.getString(4); 
		wrokplanexec.users_ID = rs.getInt(5); 
		wrokplanexec.wp_ID = rs.getInt(6); 
		 
		return wrokplanexec; 
	} 
 
} 
