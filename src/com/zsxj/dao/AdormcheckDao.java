package com.zsxj.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.zsxj.common.database.access.DataAccess; 
import com.zsxj.common.database.convert.IntegerConverter; 
import com.zsxj.convert.AdormcheckConvert; 
import com.zsxj.model.Adormcheck; 
 
public class AdormcheckDao extends DataAccess { 
 
	public AdormcheckDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Adormcheck adormcheck) { 
		String sql = "INSERT INTO adormcheck (AC_CusName,AC_Address,AC_AccountNum,AC_HealthData,Users_ID,pic_Name) VALUES (?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), adormcheck.ac_CusName,adormcheck.ac_Address,adormcheck.ac_AccountNum,adormcheck.ac_HealthData,adormcheck.users_ID	,adormcheck.pic_Name			); 
	} 
 
	public int edit(Adormcheck adormcheck) { 
		String sql = "UPDATE adormcheck SET AC_CusName=?,AC_Address=?,AC_AccountNum=?,AC_HealthData=?,Users_ID=?,pic_Name=? WHERE AC_ID=?"; 
		return super.update(sql,
adormcheck.ac_CusName,adormcheck.ac_Address,adormcheck.ac_AccountNum,adormcheck.ac_HealthData,adormcheck.users_ID,adormcheck.pic_Name,				 adormcheck.ac_ID); 
	} 
 
	public int delete(int aC_ID) { 
		String sql = "DELETE FROM adormcheck WHERE AC_ID=?"; 
		return super.update(sql, aC_ID); 
	} 
 
	public List<Adormcheck> findAll() { 
		String sql = "SELECT * FROM adormcheck"; 
		return super.queryForList(sql, new AdormcheckConvert()); 
	} 
 
	public List<Adormcheck> findWhere(String where) { 
		String sql = "SELECT * FROM adormcheck WHERE 1=1 " + where; 
		return super.queryForList(sql, new AdormcheckConvert()); 
	} 
 
	public Adormcheck findById(int aC_ID) { 
		String sql = "SELECT * FROM adormcheck WHERE  AC_ID=?"; 
		return super.queryForObject(sql, new AdormcheckConvert(), aC_ID); 
	} 
 
	public List<Adormcheck> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM adormcheck limit ?,?", 
				new AdormcheckConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM adormcheck", 
				new IntegerConverter()); 
	} 
 
} 
