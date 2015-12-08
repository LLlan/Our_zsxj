package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BasemenusmoduleConvert; 
import com.zsxj.model.Basemenusmodule; 
 
public class BasemenusmoduleDao extends DataAccess { 
 
	public BasemenusmoduleDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Basemenusmodule basemenusmodule) { 
		String sql = "INSERT INTO base_menusmodule (Menus_ID,Module_ID) VALUES (?,?)"; 
		return super.insert(sql, new IntegerConverter(), basemenusmodule.menus_ID,basemenusmodule.module_ID				); 
	} 
 
	public int edit(Basemenusmodule basemenusmodule) { 
		String sql = "UPDATE base_menusmodule SET Menus_ID=?,Module_ID=? WHERE MemusModule_ID=?"; 
		return super.update(sql,
basemenusmodule.menus_ID,basemenusmodule.module_ID,				 basemenusmodule.memusModule_ID); 
	} 
 
	public int delete(int memusModule_ID) { 
		String sql = "DELETE FROM base_menusmodule WHERE MemusModule_ID=?"; 
		return super.update(sql, memusModule_ID); 
	} 
 
	public List<Basemenusmodule> findAll() { 
		String sql = "SELECT * FROM base_menusmodule"; 
		return super.queryForList(sql, new BasemenusmoduleConvert()); 
	} 
 
	public List<Basemenusmodule> findWhere(String where) { 
		String sql = "SELECT * FROM base_menusmodule WHERE 1=1 " + where; 
		return super.queryForList(sql, new BasemenusmoduleConvert()); 
	} 
 
	public Basemenusmodule findById(int memusModule_ID) { 
		String sql = "SELECT * FROM base_menusmodule WHERE  MemusModule_ID=?"; 
		return super.queryForObject(sql, new BasemenusmoduleConvert(), memusModule_ID); 
	} 
 
	public List<Basemenusmodule> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_menusmodule limit ?,?", 
				new BasemenusmoduleConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_menusmodule", 
				new IntegerConverter()); 
	} 
 
} 
