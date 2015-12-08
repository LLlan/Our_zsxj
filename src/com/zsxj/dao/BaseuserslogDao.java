package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BaseuserslogConvert; 
import com.zsxj.model.Baseuserslog; 
 
public class BaseuserslogDao extends DataAccess { 
 
	public BaseuserslogDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Baseuserslog baseuserslog) { 
		String sql = "INSERT INTO base_userslog (Log_Url,Log_Date,Log_IP,Users_ID,Log_Type,Log_Desc) VALUES (?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), baseuserslog.log_Url,baseuserslog.log_Date,baseuserslog.log_IP,baseuserslog.users_ID,baseuserslog.log_Type,baseuserslog.log_Desc				); 
	} 
 
	public int edit(Baseuserslog baseuserslog) { 
		String sql = "UPDATE base_userslog SET Log_Url=?,Log_Date=?,Log_IP=?,Users_ID=?,Log_Type=?,Log_Desc=? WHERE Log_ID=?"; 
		return super.update(sql,
baseuserslog.log_Url,baseuserslog.log_Date,baseuserslog.log_IP,baseuserslog.users_ID,baseuserslog.log_Type,baseuserslog.log_Desc,				 baseuserslog.log_ID); 
	} 
 
	public int delete(int log_ID) { 
		String sql = "DELETE FROM base_userslog WHERE Log_ID=?"; 
		return super.update(sql, log_ID); 
	} 
 
	public List<Baseuserslog> findAll() { 
		String sql = "SELECT * FROM base_userslog"; 
		return super.queryForList(sql, new BaseuserslogConvert()); 
	} 
 
	public List<Baseuserslog> findWhere(String where) { 
		String sql = "SELECT * FROM base_userslog WHERE 1=1 " + where; 
		return super.queryForList(sql, new BaseuserslogConvert()); 
	} 
 
	public Baseuserslog findById(int log_ID) { 
		String sql = "SELECT * FROM base_userslog WHERE  Log_ID=?"; 
		return super.queryForObject(sql, new BaseuserslogConvert(), log_ID); 
	} 
 
	public List<Baseuserslog> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_userslog limit ?,?", 
				new BaseuserslogConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_userslog", 
				new IntegerConverter()); 
	} 
 
} 
