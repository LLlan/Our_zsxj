package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.MediasConvert; 
import com.zsxj.model.Medias; 
 
public class MediasDao extends DataAccess { 
 
	public MediasDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Medias medias) { 
		String sql = "INSERT INTO medias (Medias_Type,Medias_Title,Medias_AddTime,Medias_Url,Medias_BelongtoTable,Medias_BelongtoID) VALUES (?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), medias.medias_Type,medias.medias_Title,medias.medias_AddTime,medias.medias_Url,medias.medias_BelongtoTable,medias.medias_BelongtoID				); 
	} 
 
	public int edit(Medias medias) { 
		String sql = "UPDATE medias SET Medias_Type=?,Medias_Title=?,Medias_AddTime=?,Medias_Url=?,Medias_BelongtoTable=?,Medias_BelongtoID=? WHERE Medias_ID=?"; 
		return super.update(sql,
medias.medias_Type,medias.medias_Title,medias.medias_AddTime,medias.medias_Url,medias.medias_BelongtoTable,medias.medias_BelongtoID,				 medias.medias_ID); 
	} 
 
	public int delete(int medias_ID) { 
		String sql = "DELETE FROM medias WHERE Medias_ID=?"; 
		return super.update(sql, medias_ID); 
	} 
 
	public List<Medias> findAll() { 
		String sql = "SELECT * FROM medias"; 
		return super.queryForList(sql, new MediasConvert()); 
	} 
 
	public List<Medias> findWhere(String where) { 
		String sql = "SELECT * FROM medias WHERE 1=1 " + where; 
		return super.queryForList(sql, new MediasConvert()); 
	} 
 
	public Medias findById(int medias_ID) { 
		String sql = "SELECT * FROM medias WHERE  Medias_ID=?"; 
		return super.queryForObject(sql, new MediasConvert(), medias_ID); 
	} 
 
	public List<Medias> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM medias limit ?,?", 
				new MediasConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM medias", 
				new IntegerConverter()); 
	} 
 
} 
