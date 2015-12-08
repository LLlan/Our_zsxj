package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.WorkplanConvert; 
import com.zsxj.model.Workplan; 
 
public class WorkplanDao extends DataAccess { 
 
	public WorkplanDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Workplan workplan) { 
		String sql = "INSERT INTO workplan (WP_IsTemp,WP_Date,WP_Address,WP_Content,Users_ID) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), workplan.wp_IsTemp,workplan.wp_Date,workplan.wp_Address,workplan.wp_Content,workplan.users_ID				); 
	} 
 
	public int edit(Workplan workplan) { 
		String sql = "UPDATE workplan SET WP_IsTemp=?,WP_Date=?,WP_Address=?,WP_Content=?,Users_ID=? WHERE WP_ID=?"; 
		return super.update(sql,
workplan.wp_IsTemp,workplan.wp_Date,workplan.wp_Address,workplan.wp_Content,workplan.users_ID,				 workplan.wp_ID); 
	} 
 
	public int delete(int wP_ID) { 
		String sql = "DELETE FROM workplan WHERE WP_ID=?"; 
		return super.update(sql, wP_ID); 
	} 
 
	public List<Workplan> findAll() { 
		String sql = "SELECT * FROM workplan"; 
		return super.queryForList(sql, new WorkplanConvert()); 
	} 
 
	public List<Workplan> findWhere(String where) { 
		String sql = "SELECT * FROM workplan WHERE 1=1 " + where; 
		return super.queryForList(sql, new WorkplanConvert()); 
	} 
 
	public Workplan findById(int wP_ID) { 
		String sql = "SELECT * FROM workplan WHERE  WP_ID=?"; 
		return super.queryForObject(sql, new WorkplanConvert(), wP_ID); 
	} 
 
	public List<Workplan> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM workplan limit ?,?", 
				new WorkplanConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM workplan", 
				new IntegerConverter()); 
	} 
 
} 
