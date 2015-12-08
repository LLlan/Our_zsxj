package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BasemoduleConvert; 
import com.zsxj.model.Basemodule; 
 
public class BasemoduleDao extends DataAccess { 
 
	public BasemoduleDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Basemodule basemodule) { 
		String sql = "INSERT INTO base_module (Module_Name,Module_Code,Module_OrderBy) VALUES (?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), basemodule.module_Name,basemodule.module_Code,basemodule.module_OrderBy				); 
	} 
 
	public int edit(Basemodule basemodule) { 
		String sql = "UPDATE base_module SET Module_Name=?,Module_Code=?,Module_OrderBy=? WHERE Module_ID=?"; 
		return super.update(sql,
basemodule.module_Name,basemodule.module_Code,basemodule.module_OrderBy,				 basemodule.module_ID); 
	} 
 
	public int delete(int module_ID) { 
		String sql = "DELETE FROM base_module WHERE Module_ID=?"; 
		return super.update(sql, module_ID); 
	} 
 
	public List<Basemodule> findAll() { 
		String sql = "SELECT * FROM base_module"; 
		return super.queryForList(sql, new BasemoduleConvert()); 
	} 
 
	public List<Basemodule> findWhere(String where) { 
		String sql = "SELECT * FROM base_module WHERE 1=1 " + where; 
		return super.queryForList(sql, new BasemoduleConvert()); 
	} 
 
	public Basemodule findById(int module_ID) { 
		String sql = "SELECT * FROM base_module WHERE  Module_ID=?"; 
		return super.queryForObject(sql, new BasemoduleConvert(), module_ID); 
	} 
 
	public List<Basemodule> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_module limit ?,?", 
				new BasemoduleConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_module", 
				new IntegerConverter()); 
	} 
 
} 
