package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BaseusersroleConvert; 
import com.zsxj.model.Baseusersrole; 
 
public class BaseusersroleDao extends DataAccess { 
 
	public BaseusersroleDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Baseusersrole baseusersrole) { 
		String sql = "INSERT INTO base_usersrole (Role_Name,Role_OrderBy) VALUES (?,?)"; 
		return super.insert(sql, new IntegerConverter(), baseusersrole.role_Name,baseusersrole.role_OrderBy				); 
	} 
 
	public int edit(Baseusersrole baseusersrole) { 
		String sql = "UPDATE base_usersrole SET Role_Name=?,Role_OrderBy=? WHERE Role_ID=?"; 
		return super.update(sql,
baseusersrole.role_Name,baseusersrole.role_OrderBy,				 baseusersrole.role_ID); 
	} 
 
	public int delete(int role_ID) { 
		String sql = "DELETE FROM base_usersrole WHERE Role_ID=?"; 
		return super.update(sql, role_ID); 
	} 
 
	public List<Baseusersrole> findAll() { 
		String sql = "SELECT * FROM base_usersrole"; 
		return super.queryForList(sql, new BaseusersroleConvert()); 
	} 
 
	public List<Baseusersrole> findWhere(String where) { 
		String sql = "SELECT * FROM base_usersrole WHERE 1=1 " + where; 
		return super.queryForList(sql, new BaseusersroleConvert()); 
	} 
 
	public Baseusersrole findById(int role_ID) { 
		String sql = "SELECT * FROM base_usersrole WHERE  Role_ID=?"; 
		return super.queryForObject(sql, new BaseusersroleConvert(), role_ID); 
	} 
 
	public List<Baseusersrole> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_usersrole limit ?,?", 
				new BaseusersroleConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_usersrole", 
				new IntegerConverter()); 
	} 
 
} 
