package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.OpencheckConvert; 
import com.zsxj.model.Opencheck; 
 
public class OpencheckDao extends DataAccess { 
 
	public OpencheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Opencheck opencheck) { 
		String sql = "INSERT INTO opencheck (OC_ProjectNO,OC_ENO,OC_BusinessType,OC_CustInfo,Users_ID) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), opencheck.oc_ProjectNO,opencheck.oc_ENO,opencheck.oc_BusinessType,opencheck.oc_CustInfo,opencheck.users_ID				); 
	} 
 
	public int edit(Opencheck opencheck) { 
		String sql = "UPDATE opencheck SET OC_ProjectNO=?,OC_ENO=?,OC_BusinessType=?,OC_CustInfo=?,Users_ID=? WHERE OC_ID=?"; 
		return super.update(sql,
opencheck.oc_ProjectNO,opencheck.oc_ENO,opencheck.oc_BusinessType,opencheck.oc_CustInfo,opencheck.users_ID,				 opencheck.oc_ID); 
	} 
 
	public int delete(int oC_ID) { 
		String sql = "DELETE FROM opencheck WHERE OC_ID=?"; 
		return super.update(sql, oC_ID); 
	} 
 
	public List<Opencheck> findAll() { 
		String sql = "SELECT * FROM opencheck"; 
		return super.queryForList(sql, new OpencheckConvert()); 
	} 
 
	public List<Opencheck> findWhere(String where) { 
		String sql = "SELECT * FROM opencheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new OpencheckConvert()); 
	} 
 
	public Opencheck findById(int oC_ID) { 
		String sql = "SELECT * FROM opencheck WHERE  OC_ID=?"; 
		return super.queryForObject(sql, new OpencheckConvert(), oC_ID); 
	} 
 
	public List<Opencheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM opencheck limit ?,?", 
				new OpencheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM opencheck", 
				new IntegerConverter()); 
	} 
 
} 
