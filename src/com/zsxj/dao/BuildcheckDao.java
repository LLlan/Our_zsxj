package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BuildcheckConvert; 
import com.zsxj.model.Buildcheck; 
 
public class BuildcheckDao extends DataAccess { 
 
	public BuildcheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Buildcheck buildcheck) { 
		String sql = "INSERT INTO buildcheck (BC_Address,BC_Project,BC_ProjectDesc,Users_ID,pic_Name) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), buildcheck.bc_Address,buildcheck.bc_Project,buildcheck.bc_ProjectDesc,buildcheck.users_ID	,buildcheck.pic_Name			); 
	} 
 
	public int edit(Buildcheck buildcheck) { 
		String sql = "UPDATE buildcheck SET BC_Address=?,BC_Project=?,BC_ProjectDesc=?,Users_ID=?,pic_Name=? WHERE BC_ID=?"; 
		return super.update(sql,
buildcheck.bc_Address,buildcheck.bc_Project,buildcheck.bc_ProjectDesc,buildcheck.users_ID,buildcheck.pic_Name,buildcheck.bc_ID); 
	} 
 
	public int delete(int bC_ID) { 
		String sql = "DELETE FROM buildcheck WHERE BC_ID=?"; 
		return super.update(sql, bC_ID); 
	} 
 
	public List<Buildcheck> findAll() { 
		String sql = "SELECT * FROM buildcheck"; 
		return super.queryForList(sql, new BuildcheckConvert()); 
	} 
 
	public List<Buildcheck> findWhere(String where) { 
		String sql = "SELECT * FROM buildcheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new BuildcheckConvert()); 
	} 
 
	public Buildcheck findById(int bC_ID) { 
		String sql = "SELECT * FROM buildcheck WHERE  BC_ID=?"; 
		return super.queryForObject(sql, new BuildcheckConvert(), bC_ID); 
	} 
 
	public List<Buildcheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM buildcheck limit ?,?", 
				new BuildcheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM buildcheck", 
				new IntegerConverter()); 
	} 
 
} 
