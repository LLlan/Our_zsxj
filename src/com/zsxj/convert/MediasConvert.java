package com.zsxj.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.zsxj.common.database.convert.ResultConverter; 
import com.zsxj.model.Medias; 
 
public class MediasConvert implements ResultConverter<Medias>{ 
 
	@Override 
	public Medias convert(ResultSet rs) throws SQLException { 
		Medias medias = new Medias(rs.getInt(1)); 
		medias.medias_Type = rs.getInt(2); 
		medias.medias_Title = rs.getString(3); 
		medias.medias_AddTime = rs.getString(4); 
		medias.medias_Url = rs.getString(5); 
		medias.medias_BelongtoTable = rs.getString(6); 
		medias.medias_BelongtoID = rs.getInt(7); 
		 
		return medias; 
	} 
 
} 
