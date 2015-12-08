package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Adormcheck; 
 
public class AdormcheckConvert implements ResultConverter<Adormcheck>{ 
 
	@Override 
	public Adormcheck convert(ResultSet rs) throws SQLException { 
		Adormcheck adormcheck = new Adormcheck(rs.getInt(1)); 
		adormcheck.ac_CusName = rs.getString(2); 
		adormcheck.ac_Address = rs.getString(3); 
		adormcheck.ac_AccountNum = rs.getString(4); 
		adormcheck.ac_HealthData = rs.getString(5); 
		adormcheck.users_ID = rs.getString(6); 
		adormcheck.pic_Name = rs.getString(7);  
		return adormcheck; 
	} 
 
} 
