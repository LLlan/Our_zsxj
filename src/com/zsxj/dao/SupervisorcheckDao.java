package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.SupervisorcheckConvert; 
import com.zsxj.model.Supervisorcheck; 
 
public class SupervisorcheckDao extends DataAccess { 
 
	public SupervisorcheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Supervisorcheck supervisorcheck) { 
		String sql = "INSERT INTO supervisorcheck (SC_Address,SC_ProjectName,SC_ProjectDesc,Users_ID,pic_Name) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), supervisorcheck.sc_Address,supervisorcheck.sc_ProjectName,supervisorcheck.sc_ProjectDesc,supervisorcheck.users_ID,supervisorcheck.pic_Name				); 
	} 
 
	public int edit(Supervisorcheck supervisorcheck) { 
		String sql = "UPDATE supervisorcheck SET SC_Address=?,SC_ProjectName=?,SC_ProjectDesc=?,Users_ID=?,pic_Name=? WHERE SC_ID=?"; 
		return super.update(sql,
supervisorcheck.sc_Address,supervisorcheck.sc_ProjectName,supervisorcheck.sc_ProjectDesc,supervisorcheck.users_ID,supervisorcheck.pic_Name,supervisorcheck.sc_ID); 
	} 
 
	public int delete(int sC_ID) { 
		String sql = "DELETE FROM supervisorcheck WHERE SC_ID=?"; 
		return super.update(sql, sC_ID); 
	} 
 
	public List<Supervisorcheck> findAll() { 
		String sql = "SELECT * FROM supervisorcheck"; 
		return super.queryForList(sql, new SupervisorcheckConvert()); 
	} 
 
	public List<Supervisorcheck> findWhere(String where) { 
		String sql = "SELECT * FROM supervisorcheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new SupervisorcheckConvert()); 
	} 
 
	public Supervisorcheck findById(int sC_ID) { 
		String sql = "SELECT * FROM supervisorcheck WHERE  SC_ID=?"; 
		return super.queryForObject(sql, new SupervisorcheckConvert(), sC_ID); 
	} 
 
	public List<Supervisorcheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM supervisorcheck limit ?,?", 
				new SupervisorcheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM supervisorcheck", 
				new IntegerConverter()); 
	} 
 
} 
