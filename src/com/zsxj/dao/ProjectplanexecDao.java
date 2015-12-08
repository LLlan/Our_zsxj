package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.ProjectplanexecConvert; 
import com.zsxj.model.Projectplanexec; 
 
public class ProjectplanexecDao extends DataAccess { 
 
	public ProjectplanexecDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Projectplanexec projectplanexec) { 
		String sql = "INSERT INTO projectplanexec (PPE_Date,PPE_RealAddress,PPE_RealContent,PP_ID,Users_ID) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), projectplanexec.ppe_Date,projectplanexec.ppe_RealAddress,projectplanexec.ppe_RealContent,projectplanexec.pp_ID,projectplanexec.users_ID				); 
	} 
 
	public int edit(Projectplanexec projectplanexec) { 
		String sql = "UPDATE projectplanexec SET PPE_Date=?,PPE_RealAddress=?,PPE_RealContent=?,PP_ID=?,Users_ID=? WHERE PPE_ID=?"; 
		return super.update(sql,
projectplanexec.ppe_Date,projectplanexec.ppe_RealAddress,projectplanexec.ppe_RealContent,projectplanexec.pp_ID,projectplanexec.users_ID,				 projectplanexec.ppe_ID); 
	} 
 
	public int delete(int pPE_ID) { 
		String sql = "DELETE FROM projectplanexec WHERE PPE_ID=?"; 
		return super.update(sql, pPE_ID); 
	} 
 
	public List<Projectplanexec> findAll() { 
		String sql = "SELECT * FROM projectplanexec"; 
		return super.queryForList(sql, new ProjectplanexecConvert()); 
	} 
 
	public List<Projectplanexec> findWhere(String where) { 
		String sql = "SELECT * FROM projectplanexec WHERE 1=1 " + where; 
		return super.queryForList(sql, new ProjectplanexecConvert()); 
	} 
 
	public Projectplanexec findById(int pPE_ID) { 
		String sql = "SELECT * FROM projectplanexec WHERE  PPE_ID=?"; 
		return super.queryForObject(sql, new ProjectplanexecConvert(), pPE_ID); 
	} 
 
	public List<Projectplanexec> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM projectplanexec limit ?,?", 
				new ProjectplanexecConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM projectplanexec", 
				new IntegerConverter()); 
	} 
 
} 
