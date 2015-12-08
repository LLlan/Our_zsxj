package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.OpencheckDao; 
import com.zsxj.model.Opencheck; 
 
public class OpencheckService extends BaseService { 
	public OpencheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public OpencheckService() { 
		super(); 
	} 
 
	public int add(Opencheck opencheck) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.add(opencheck); 
	} 
 
	public int edit(Opencheck opencheck) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.edit(opencheck); 
	} 
 
	public int delete(int oC_ID) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.delete(oC_ID); 
	} 
 
	public List<Opencheck> findAll() { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Opencheck> findWhere(String where) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Opencheck findById(int oC_ID) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.findById(oC_ID); 
	} 
 
	public List<Opencheck> findByRange(int start, int size) { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		OpencheckDao dao = new OpencheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
