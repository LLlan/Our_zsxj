package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BaseusersDao; 
import com.zsxj.model.Baseusers; 
 
public class BaseusersService extends BaseService { 
	public BaseusersService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BaseusersService() { 
		super(); 
	} 
 
	public int add(Baseusers baseusers) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.add(baseusers); 
	} 
 
	public int edit(Baseusers baseusers) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.edit(baseusers); 
	} 
 
	public int delete(int users_ID) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.delete(users_ID); 
	} 
 
	public List<Baseusers> findAll() { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Baseusers> findWhere(String where) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Baseusers findById(int users_ID) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.findById(users_ID); 
	} 
 
	public List<Baseusers> findByRange(int start, int size) { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BaseusersDao dao = new BaseusersDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
