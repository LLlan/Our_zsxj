package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BaseusersbranchConvert; 
import com.zsxj.model.Baseusersbranch; 
 
public class BaseusersbranchDao extends DataAccess { 
 
	public BaseusersbranchDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Baseusersbranch baseusersbranch) { 
		String sql = "INSERT INTO base_usersbranch (Branch_Name,Branch_PID,Branch_Code,Branch_OrderBy) VALUES (?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), baseusersbranch.branch_Name,baseusersbranch.branch_PID,baseusersbranch.branch_Code,baseusersbranch.branch_OrderBy				); 
	} 
 
	public int edit(Baseusersbranch baseusersbranch) { 
		String sql = "UPDATE base_usersbranch SET Branch_Name=?,Branch_PID=?,Branch_Code=?,Branch_OrderBy=? WHERE Branch_ID=?"; 
		return super.update(sql,
baseusersbranch.branch_Name,baseusersbranch.branch_PID,baseusersbranch.branch_Code,baseusersbranch.branch_OrderBy,				 baseusersbranch.branch_ID); 
	} 
 
	public int delete(int branch_ID) { 
		String sql = "DELETE FROM base_usersbranch WHERE Branch_ID=?"; 
		return super.update(sql, branch_ID); 
	} 
 
	public List<Baseusersbranch> findAll() { 
		String sql = "SELECT * FROM base_usersbranch"; 
		return super.queryForList(sql, new BaseusersbranchConvert()); 
	} 
 
	public List<Baseusersbranch> findWhere(String where) { 
		String sql = "SELECT * FROM base_usersbranch WHERE 1=1 " + where; 
		return super.queryForList(sql, new BaseusersbranchConvert()); 
	} 
 
	public Baseusersbranch findById(int branch_ID) { 
		String sql = "SELECT * FROM base_usersbranch WHERE  Branch_ID=?"; 
		return super.queryForObject(sql, new BaseusersbranchConvert(), branch_ID); 
	} 
 
	public List<Baseusersbranch> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_usersbranch limit ?,?", 
				new BaseusersbranchConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_usersbranch", 
				new IntegerConverter()); 
	} 
 
} 
