package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.MacroomcheckConvert; 
import com.zsxj.model.Macroomcheck; 
 
public class MacroomcheckDao extends DataAccess { 
 
	public MacroomcheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Macroomcheck macroomcheck) { 
		String sql = "INSERT INTO macroomcheck (MRC_Address,Users_ID,Pic_Name) VALUES (?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), macroomcheck.mrc_Address,macroomcheck.users_ID,macroomcheck.pic_Name				); 
	} 
 
	public int edit(Macroomcheck macroomcheck) { 
		String sql = "UPDATE macroomcheck SET MRC_Address=?,Users_ID=?,Pic_Name=? WHERE MRC_ID=?"; 
		return super.update(sql,
macroomcheck.mrc_Address,macroomcheck.users_ID,macroomcheck.pic_Name,				 macroomcheck.mrc_ID); 
	} 
 
	public int delete(int mRC_ID) { 
		String sql = "DELETE FROM macroomcheck WHERE MRC_ID=?"; 
		return super.update(sql, mRC_ID); 
	} 
 
	public List<Macroomcheck> findAll() { 
		String sql = "SELECT * FROM macroomcheck"; 
		return super.queryForList(sql, new MacroomcheckConvert()); 
	} 
 
	public List<Macroomcheck> findWhere(String where) { 
		String sql = "SELECT * FROM macroomcheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new MacroomcheckConvert()); 
	} 
 
	public Macroomcheck findById(int mRC_ID) { 
		String sql = "SELECT * FROM macroomcheck WHERE  MRC_ID=?"; 
		return super.queryForObject(sql, new MacroomcheckConvert(), mRC_ID); 
	} 
 
	public List<Macroomcheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM macroomcheck limit ?,?", 
				new MacroomcheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM macroomcheck", 
				new IntegerConverter()); 
	} 
 
} 
