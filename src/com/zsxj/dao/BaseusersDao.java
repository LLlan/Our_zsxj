package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.BaseusersConvert; 
import com.zsxj.model.Baseusers; 
 
public class BaseusersDao extends DataAccess { 
 
	public BaseusersDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Baseusers baseusers) { 
		String sql = "INSERT INTO base_users (Users_UserName,Users_Password,Users_Mobile,Users_Phone,Users_Email,Users_TrueName,Users_IsLock,Users_LastLoginTime,Users_LastLoginIP,Branch_ID,Role_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), baseusers.users_UserName,baseusers.users_Password,baseusers.users_Mobile,baseusers.users_Phone,baseusers.users_Email,baseusers.users_TrueName,baseusers.users_IsLock,baseusers.users_LastLoginTime,baseusers.users_LastLoginIP,baseusers.branch_ID,baseusers.role_ID				); 
	} 
 
	public int edit(Baseusers baseusers) { 
		String sql = "UPDATE base_users SET Users_UserName=?,Users_Password=?,Users_Mobile=?,Users_Phone=?,Users_Email=?,Users_TrueName=?,Users_IsLock=?,Users_LastLoginTime=?,Users_LastLoginIP=?,Branch_ID=?,Role_ID=? WHERE Users_ID=?"; 
		return super.update(sql,
baseusers.users_UserName,baseusers.users_Password,baseusers.users_Mobile,baseusers.users_Phone,baseusers.users_Email,baseusers.users_TrueName,baseusers.users_IsLock,baseusers.users_LastLoginTime,baseusers.users_LastLoginIP,baseusers.branch_ID,baseusers.role_ID,				 baseusers.users_ID); 
	} 
 
	public int delete(int users_ID) { 
		String sql = "DELETE FROM base_users WHERE Users_ID=?"; 
		return super.update(sql, users_ID); 
	} 
 
	public List<Baseusers> findAll() { 
		String sql = "SELECT * FROM base_users"; 
		return super.queryForList(sql, new BaseusersConvert()); 
	} 
 
	public List<Baseusers> findWhere(String where) { 
		String sql = "SELECT * FROM base_users WHERE 1=1 " + where; 
		return super.queryForList(sql, new BaseusersConvert()); 
	} 
 
	public Baseusers findById(int users_ID) { 
		String sql = "SELECT * FROM base_users WHERE  Users_ID=?"; 
		return super.queryForObject(sql, new BaseusersConvert(), users_ID); 
	} 
 
	public List<Baseusers> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM base_users limit ?,?", 
				new BaseusersConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM base_users", 
				new IntegerConverter()); 
	} 
 
} 
