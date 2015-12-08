package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BaserolemenusConvert; 
import com.zsxj.model.Baserolemenus; 
 
public class BaserolemenusDao extends DataAccess { 
 
	public BaserolemenusDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Baserolemenus baserolemenus) { 
		String sql = "INSERT INTO base_rolemenus (Role_ID,Menus_ID,Module_ID) VALUES (?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), baserolemenus.role_ID,baserolemenus.menus_ID,baserolemenus.module_ID				); 
	} 
 
	public int edit(Baserolemenus baserolemenus) { 
		String sql = "UPDATE base_rolemenus SET Role_ID=?,Menus_ID=?,Module_ID=? WHERE RM_ID=?"; 
		return super.update(sql,
baserolemenus.role_ID,baserolemenus.menus_ID,baserolemenus.module_ID,				 baserolemenus.rm_ID); 
	} 
 
	public int delete(int rM_ID) { 
		String sql = "DELETE FROM base_rolemenus WHERE RM_ID=?"; 
		return super.update(sql, rM_ID); 
	} 
 
	public List<Baserolemenus> findAll() { 
		String sql = "SELECT * FROM base_rolemenus"; 
		return super.queryForList(sql, new BaserolemenusConvert()); 
	} 
 
	public List<Baserolemenus> findWhere(String where) { 
		String sql = "SELECT * FROM base_rolemenus WHERE 1=1 " + where; 
		return super.queryForList(sql, new BaserolemenusConvert()); 
	} 
 
	public Baserolemenus findById(int rM_ID) { 
		String sql = "SELECT * FROM base_rolemenus WHERE  RM_ID=?"; 
		return super.queryForObject(sql, new BaserolemenusConvert(), rM_ID); 
	} 
 
	public List<Baserolemenus> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_rolemenus limit ?,?", 
				new BaserolemenusConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_rolemenus", 
				new IntegerConverter()); 
	} 
 
} 
