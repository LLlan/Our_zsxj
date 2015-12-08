package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BaseuserslogDao; 
import com.zsxj.model.Baseuserslog; 
 
public class BaseuserslogService extends BaseService { 
	public BaseuserslogService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BaseuserslogService() { 
		super(); 
	} 
 
	public int add(Baseuserslog baseuserslog) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.add(baseuserslog); 
	} 
 
	public int edit(Baseuserslog baseuserslog) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.edit(baseuserslog); 
	} 
 
	public int delete(int log_ID) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.delete(log_ID); 
	} 
 
	public List<Baseuserslog> findAll() { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Baseuserslog> findWhere(String where) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Baseuserslog findById(int log_ID) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.findById(log_ID); 
	} 
 
	public List<Baseuserslog> findByRange(int start, int size) { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BaseuserslogDao dao = new BaseuserslogDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
