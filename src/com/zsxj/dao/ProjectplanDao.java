package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.ProjectplanConvert; 
import com.zsxj.model.Projectplan; 
 
public class ProjectplanDao extends DataAccess { 
 
	public ProjectplanDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Projectplan projectplan) { 
		String sql = "INSERT INTO projectplan (PP_ProjectName,PP_ProjectNo,PP_ExecComName,PP_Content,PP_BOMList,PP_StartDate,PP_EndDate,Users_ID) VALUES (?,?,?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), projectplan.pp_ProjectName,projectplan.pp_ProjectNo,projectplan.pp_ExecComName,projectplan.pp_Content,projectplan.pp_BOMList,projectplan.pp_StartDate,projectplan.pp_EndDate,projectplan.users_ID				); 
	} 
 
	public int edit(Projectplan projectplan) { 
		String sql = "UPDATE projectplan SET PP_ProjectName=?,PP_ProjectNo=?,PP_ExecComName=?,PP_Content=?,PP_BOMList=?,PP_StartDate=?,PP_EndDate=?,Users_ID=? WHERE PP_ID=?"; 
		return super.update(sql,
projectplan.pp_ProjectName,projectplan.pp_ProjectNo,projectplan.pp_ExecComName,projectplan.pp_Content,projectplan.pp_BOMList,projectplan.pp_StartDate,projectplan.pp_EndDate,projectplan.users_ID,				 projectplan.pp_ID); 
	} 
 
	public int delete(int pP_ID) { 
		String sql = "DELETE FROM projectplan WHERE PP_ID=?"; 
		return super.update(sql, pP_ID); 
	} 
 
	public List<Projectplan> findAll() { 
		String sql = "SELECT * FROM projectplan"; 
		return super.queryForList(sql, new ProjectplanConvert()); 
	} 
 
	public List<Projectplan> findWhere(String where) { 
		String sql = "SELECT * FROM projectplan WHERE 1=1 " + where; 
		return super.queryForList(sql, new ProjectplanConvert()); 
	} 
 
	public Projectplan findById(int pP_ID) { 
		String sql = "SELECT * FROM projectplan WHERE  PP_ID=?"; 
		return super.queryForObject(sql, new ProjectplanConvert(), pP_ID); 
	} 
 
	public List<Projectplan> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM projectplan limit ?,?", 
				new ProjectplanConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM projectplan", 
				new IntegerConverter()); 
	} 
 
} 
