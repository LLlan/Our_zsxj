package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.WorklistConvert; 
import com.zsxj.model.Worklist; 
 
public class WorklistDao extends DataAccess { 
 
	public WorklistDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Worklist worklist) { 
		String sql = "INSERT INTO worklist (WL_NO,WL_Title,WL_Content,WL_UsersIDs,WL_StartTime,WL_EndTime,Users_ID) VALUES (?,?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), worklist.wl_NO,worklist.wl_Title,worklist.wl_Content,worklist.wl_UsersIDs,worklist.wl_StartTime,worklist.wl_EndTime,worklist.users_ID				); 
	} 
 
	public int edit(Worklist worklist) { 
		String sql = "UPDATE worklist SET WL_NO=?,WL_Title=?,WL_Content=?,WL_UsersIDs=?,WL_StartTime=?,WL_EndTime=?,Users_ID=? WHERE WL_ID=?"; 
		return super.update(sql,
worklist.wl_NO,worklist.wl_Title,worklist.wl_Content,worklist.wl_UsersIDs,worklist.wl_StartTime,worklist.wl_EndTime,worklist.users_ID,				 worklist.wl_ID); 
	} 
 
	public int delete(int wL_ID) { 
		String sql = "DELETE FROM worklist WHERE WL_ID=?"; 
		return super.update(sql, wL_ID); 
	} 
 
	public List<Worklist> findAll() { 
		String sql = "SELECT * FROM worklist"; 
		return super.queryForList(sql, new WorklistConvert()); 
	} 
 
	public List<Worklist> findWhere(String where) { 
		String sql = "SELECT * FROM worklist WHERE 1=1 " + where; 
		return super.queryForList(sql, new WorklistConvert()); 
	} 
 
	public Worklist findById(int wL_ID) { 
		String sql = "SELECT * FROM worklist WHERE  WL_ID=?"; 
		return super.queryForObject(sql, new WorklistConvert(), wL_ID); 
	} 
 
	public List<Worklist> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM worklist limit ?,?", 
				new WorklistConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM worklist", 
				new IntegerConverter()); 
	} 
 
} 
