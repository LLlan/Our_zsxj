package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BaseusersroleDao; 
import com.zsxj.model.Baseusersrole; 
 
public class BaseusersroleService extends BaseService { 
	public BaseusersroleService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BaseusersroleService() { 
		super(); 
	} 
 
	public int add(Baseusersrole baseusersrole) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.add(baseusersrole); 
	} 
 
	public int edit(Baseusersrole baseusersrole) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.edit(baseusersrole); 
	} 
 
	public int delete(int role_ID) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.delete(role_ID); 
	} 
 
	public List<Baseusersrole> findAll() { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Baseusersrole> findWhere(String where) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Baseusersrole findById(int role_ID) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.findById(role_ID); 
	} 
 
	public List<Baseusersrole> findByRange(int start, int size) { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BaseusersroleDao dao = new BaseusersroleDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
