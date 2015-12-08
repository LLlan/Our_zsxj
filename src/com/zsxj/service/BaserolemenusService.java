package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BaserolemenusDao; 
import com.zsxj.model.Baserolemenus; 
 
public class BaserolemenusService extends BaseService { 
	public BaserolemenusService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BaserolemenusService() { 
		super(); 
	} 
 
	public int add(Baserolemenus baserolemenus) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.add(baserolemenus); 
	} 
 
	public int edit(Baserolemenus baserolemenus) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.edit(baserolemenus); 
	} 
 
	public int delete(int rM_ID) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.delete(rM_ID); 
	} 
 
	public List<Baserolemenus> findAll() { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Baserolemenus> findWhere(String where) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Baserolemenus findById(int rM_ID) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.findById(rM_ID); 
	} 
 
	public List<Baserolemenus> findByRange(int start, int size) { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BaserolemenusDao dao = new BaserolemenusDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
