package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Workplan; 
 
public class WorkplanConvert implements ResultConverter<Workplan>{ 
 
	@Override 
	public Workplan convert(ResultSet rs) throws SQLException { 
		Workplan workplan = new Workplan(rs.getInt(1)); 
		workplan.wp_IsTemp = rs.getInt(2); 
		workplan.wp_Date = rs.getString(3); 
		workplan.wp_Address = rs.getString(4); 
		workplan.wp_Content = rs.getString(5); 
		workplan.users_ID = rs.getInt(6); 
		 
		return workplan; 
	} 
 
} 
