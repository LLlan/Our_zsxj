package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.HindercheckConvert; 
import com.zsxj.model.Hindercheck; 
 
public class HindercheckDao extends DataAccess { 
 
	public HindercheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Hindercheck hindercheck) { 
		String sql = "INSERT INTO hindercheck (HC_Address,HC_Desc,HC_Process,HC_ProcessUserID) VALUES (?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), hindercheck.hc_Address,hindercheck.hc_Desc,hindercheck.hc_Process,hindercheck.hc_ProcessUserID				); 
	} 
 
	public int edit(Hindercheck hindercheck) { 
		String sql = "UPDATE hindercheck SET HC_Address=?,HC_Desc=?,HC_Process=?,HC_ProcessUserID=? WHERE HC_ID=?"; 
		return super.update(sql,
hindercheck.hc_Address,hindercheck.hc_Desc,hindercheck.hc_Process,hindercheck.hc_ProcessUserID,hindercheck.hc_ID); 
	} 
 
	public int delete(int hC_ID) { 
		String sql = "DELETE FROM hindercheck WHERE HC_ID=?"; 
		return super.update(sql, hC_ID); 
	} 
 
	public List<Hindercheck> findAll() { 
		String sql = "SELECT * FROM hindercheck"; 
		return super.queryForList(sql, new HindercheckConvert()); 
	} 
 
	public List<Hindercheck> findWhere(String where) { 
		String sql = "SELECT * FROM hindercheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new HindercheckConvert()); 
	} 
 
	public Hindercheck findById(int hC_ID) { 
		String sql = "SELECT * FROM hindercheck WHERE  HC_ID=?"; 
		return super.queryForObject(sql, new HindercheckConvert(), hC_ID); 
	} 
 
	public List<Hindercheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM hindercheck limit ?,?", 
				new HindercheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM hindercheck", 
				new IntegerConverter()); 
	} 
 
} 
