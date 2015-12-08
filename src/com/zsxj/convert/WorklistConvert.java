package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Worklist; 
 
public class WorklistConvert implements ResultConverter<Worklist>{ 
 
	@Override 
	public Worklist convert(ResultSet rs) throws SQLException { 
		Worklist worklist = new Worklist(rs.getInt(1)); 
		worklist.wl_NO = rs.getString(2); 
		worklist.wl_Title = rs.getString(3); 
		worklist.wl_Content = rs.getString(4); 
		worklist.wl_UsersIDs = rs.getString(5); 
		worklist.wl_StartTime = rs.getString(6); 
		worklist.wl_EndTime = rs.getString(7); 
		worklist.users_ID = rs.getInt(8); 
		 
		return worklist; 
	} 
 
} 
