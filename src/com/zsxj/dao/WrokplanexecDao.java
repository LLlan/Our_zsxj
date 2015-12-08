package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.WrokplanexecConvert; 
import com.zsxj.model.Wrokplanexec; 
 
public class WrokplanexecDao extends DataAccess { 
 
	public WrokplanexecDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Wrokplanexec wrokplanexec) { 
		String sql = "INSERT INTO wrokplanexec (WPE_Date,WPE_RealAddress,WPE_RealContent,Users_ID,WP_ID) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), wrokplanexec.wpe_Date,wrokplanexec.wpe_RealAddress,wrokplanexec.wpe_RealContent,wrokplanexec.users_ID,wrokplanexec.wp_ID				); 
	} 
 
	public int edit(Wrokplanexec wrokplanexec) { 
		String sql = "UPDATE wrokplanexec SET WPE_Date=?,WPE_RealAddress=?,WPE_RealContent=?,Users_ID=?,WP_ID=? WHERE WPE_ID=?"; 
		return super.update(sql,
wrokplanexec.wpe_Date,wrokplanexec.wpe_RealAddress,wrokplanexec.wpe_RealContent,wrokplanexec.users_ID,wrokplanexec.wp_ID,				 wrokplanexec.wpe_ID); 
	} 
 
	public int delete(int wPE_ID) { 
		String sql = "DELETE FROM wrokplanexec WHERE WPE_ID=?"; 
		return super.update(sql, wPE_ID); 
	} 
 
	public List<Wrokplanexec> findAll() { 
		String sql = "SELECT * FROM wrokplanexec"; 
		return super.queryForList(sql, new WrokplanexecConvert()); 
	} 
 
	public List<Wrokplanexec> findWhere(String where) { 
		String sql = "SELECT * FROM wrokplanexec WHERE 1=1 " + where; 
		return super.queryForList(sql, new WrokplanexecConvert()); 
	} 
 
	public Wrokplanexec findById(int wPE_ID) { 
		String sql = "SELECT * FROM wrokplanexec WHERE  WPE_ID=?"; 
		return super.queryForObject(sql, new WrokplanexecConvert(), wPE_ID); 
	} 
 
	public List<Wrokplanexec> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM wrokplanexec limit ?,?", 
				new WrokplanexecConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM wrokplanexec", 
				new IntegerConverter()); 
	} 
 
} 
