package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.DesigncheckConvert; 
import com.zsxj.model.Designcheck; 
 
public class DesigncheckDao extends DataAccess { 
 
	public DesigncheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Designcheck designcheck) { 
		String sql = "INSERT INTO designcheck (DC_Date,DC_Project,DC_Content,Users_ID) VALUES (?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), designcheck.dc_Date,designcheck.dc_Project,designcheck.dc_Content,designcheck.users_ID				); 
	} 
 
	public int edit(Designcheck designcheck) { 
		String sql = "UPDATE designcheck SET DC_Date=?,DC_Project=?,DC_Content=?,Users_ID=? WHERE DC_id=?"; 
		return super.update(sql,
designcheck.dc_Date,designcheck.dc_Project,designcheck.dc_Content,designcheck.users_ID,				 designcheck.dc_id); 
	} 
 
	public int delete(int dC_id) { 
		String sql = "DELETE FROM designcheck WHERE DC_id=?"; 
		return super.update(sql, dC_id); 
	} 
 
	public List<Designcheck> findAll() { 
		String sql = "SELECT * FROM designcheck"; 
		return super.queryForList(sql, new DesigncheckConvert()); 
	} 
 
	public List<Designcheck> findWhere(String where) { 
		String sql = "SELECT * FROM designcheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new DesigncheckConvert()); 
	} 
 
	public Designcheck findById(int dC_id) { 
		String sql = "SELECT * FROM designcheck WHERE  DC_id=?"; 
		return super.queryForObject(sql, new DesigncheckConvert(), dC_id); 
	} 
 
	public List<Designcheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM designcheck limit ?,?", 
				new DesigncheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM designcheck", 
				new IntegerConverter()); 
	} 
 
} 
