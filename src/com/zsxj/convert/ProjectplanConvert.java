package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Projectplan; 
 
public class ProjectplanConvert implements ResultConverter<Projectplan>{ 
 
	@Override 
	public Projectplan convert(ResultSet rs) throws SQLException { 
		Projectplan projectplan = new Projectplan(rs.getInt(1)); 
		projectplan.pp_ProjectName = rs.getString(2); 
		projectplan.pp_ProjectNo = rs.getString(3); 
		projectplan.pp_ExecComName = rs.getString(4); 
		projectplan.pp_Content = rs.getString(5); 
		projectplan.pp_BOMList = rs.getString(6); 
		projectplan.pp_StartDate = rs.getString(7); 
		projectplan.pp_EndDate = rs.getString(8); 
		projectplan.users_ID = rs.getInt(9); 
		 
		return projectplan; 
	} 
 
} 
