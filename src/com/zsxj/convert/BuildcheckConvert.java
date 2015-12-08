package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Buildcheck; 
 
public class BuildcheckConvert implements ResultConverter<Buildcheck>{ 
 
	@Override 
	public Buildcheck convert(ResultSet rs) throws SQLException { 
		Buildcheck buildcheck = new Buildcheck(rs.getInt(1)); 
		buildcheck.bc_Address = rs.getString(2); 
		buildcheck.bc_Project = rs.getString(3); 
		buildcheck.bc_ProjectDesc = rs.getString(4); 
		buildcheck.users_ID = rs.getString(5); 
		buildcheck.pic_Name = rs.getString(6);
		 
		return buildcheck; 
	} 
 
} 
