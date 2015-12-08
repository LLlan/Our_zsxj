package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.MacroomcheckDao; 
import com.zsxj.model.Macroomcheck; 
 
public class MacroomcheckService extends BaseService { 
	public MacroomcheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public MacroomcheckService() { 
		super(); 
	} 
 
	public int add(Macroomcheck macroomcheck) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.add(macroomcheck); 
	} 
 
	public int edit(Macroomcheck macroomcheck) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.edit(macroomcheck); 
	} 
 
	public int delete(int mRC_ID) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.delete(mRC_ID); 
	} 
 
	public List<Macroomcheck> findAll() { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Macroomcheck> findWhere(String where) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Macroomcheck findById(int mRC_ID) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.findById(mRC_ID); 
	} 
 
	public List<Macroomcheck> findByRange(int start, int size) { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		MacroomcheckDao dao = new MacroomcheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
