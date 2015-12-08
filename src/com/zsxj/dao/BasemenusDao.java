package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BasemenusConvert; 
import com.zsxj.model.Basemenus; 
 
public class BasemenusDao extends DataAccess { 
 
	public BasemenusDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Basemenus basemenus) { 
		String sql = "INSERT INTO base_menus (Menus_Title,Menus_Url,Menus_PID,Menus_Code,Menus_Icon,Menus_OrderBy) VALUES (?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), basemenus.menus_Title,basemenus.menus_Url,basemenus.menus_PID,basemenus.menus_Code,basemenus.menus_Icon,basemenus.menus_OrderBy				); 
	} 
 
	public int edit(Basemenus basemenus) { 
		String sql = "UPDATE base_menus SET Menus_Title=?,Menus_Url=?,Menus_PID=?,Menus_Code=?,Menus_Icon=?,Menus_OrderBy=? WHERE Menus_ID=?"; 
		return super.update(sql,
basemenus.menus_Title,basemenus.menus_Url,basemenus.menus_PID,basemenus.menus_Code,basemenus.menus_Icon,basemenus.menus_OrderBy,				 basemenus.menus_ID); 
	} 
 
	public int delete(int menus_ID) { 
		String sql = "DELETE FROM base_menus WHERE Menus_ID=?"; 
		return super.update(sql, menus_ID); 
	} 
 
	public List<Basemenus> findAll() { 
		String sql = "SELECT * FROM base_menus"; 
		return super.queryForList(sql, new BasemenusConvert()); 
	} 
 
	public List<Basemenus> findWhere(String where) { 
		String sql = "SELECT * FROM base_menus WHERE 1=1 " + where; 
		return super.queryForList(sql, new BasemenusConvert()); 
	} 
 
	public Basemenus findById(int menus_ID) { 
		String sql = "SELECT * FROM base_menus WHERE  Menus_ID=?"; 
		return super.queryForObject(sql, new BasemenusConvert(), menus_ID); 
	} 
 
	public List<Basemenus> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_menus limit ?,?", 
				new BasemenusConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_menus", 
				new IntegerConverter()); 
	} 
 
} 
